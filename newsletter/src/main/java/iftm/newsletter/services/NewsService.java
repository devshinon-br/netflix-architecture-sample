package iftm.newsletter.services;

import iftm.newsletter.messages.RabbitMqSendLog;
import iftm.newsletter.models.dto.LogDTO;
import iftm.newsletter.models.dto.NewsDTO;
import iftm.newsletter.repositories.NewsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository repository;

    @Autowired
    private RabbitMqSendLog rabbitMqSendLog;

    public ResponseEntity<List<NewsDTO>> findAll() {
        var dbNews = repository.findAll();

        if (dbNews.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var newsDtos = dbNews.stream().map(NewsDTO::new).toList();

        return ResponseEntity.ok(newsDtos);
    }

    public ResponseEntity<NewsDTO> findById(final ObjectId id) {
        if (id == null) return ResponseEntity.badRequest().build();
        var dbNews = repository.findById(id);
        return dbNews.map(news -> ResponseEntity.ok(new NewsDTO(news))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<NewsDTO> save(final NewsDTO newsDTO) {
        if (newsDTO == null) return ResponseEntity.badRequest().build();

        var savedNews = repository.save(newsDTO.toNews());
        var savedNewsDto = new NewsDTO(savedNews);

        rabbitMqSendLog.sendLog(new LogDTO<NewsDTO>("created", savedNewsDto));
        return ResponseEntity.ok(savedNewsDto);
    }

    public ResponseEntity<NewsDTO> update(final NewsDTO newsDTO) {
        if (newsDTO.getId() == null) return ResponseEntity.badRequest().build();

        var objectId = new ObjectId(String.valueOf(newsDTO.getId()));
        var dbNews = repository.findById(objectId);

        if (dbNews.isEmpty()) return ResponseEntity.notFound().build();

        var dbNewsObj = dbNews.get();
        dbNewsObj.setDate(newsDTO.getDate());
        dbNewsObj.setEditorName(newsDTO.getEditorName());
        dbNewsObj.setPosts(newsDTO.getPosts());
        dbNewsObj.setTitle(newsDTO.getTitle());

        return ResponseEntity.ok(new NewsDTO(repository.save(dbNewsObj)));
    }

    public ResponseEntity<?> delete(final ObjectId id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        var deletedNewsDto = new NewsDTO(repository.findById(id).orElseThrow());
        repository.deleteById(id);

        if (repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

        // send log
        rabbitMqSendLog.sendLog(new LogDTO<NewsDTO>("created", deletedNewsDto));
        return ResponseEntity.ok().build();
    }
}
