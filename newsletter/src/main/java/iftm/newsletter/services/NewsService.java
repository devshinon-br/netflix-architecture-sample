package iftm.newsletter.services;

import iftm.newsletter.models.dto.NewsDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class NewsService {
    public ResponseEntity<List<NewsDTO>> findAll() {
        return null;
    }

    public ResponseEntity<NewsDTO> findById(final ObjectId id) {
        return null;
    }

    public ResponseEntity<NewsDTO> save(final NewsDTO newsDTO) {
        return null;
    }

    public ResponseEntity<NewsDTO> update(final NewsDTO newsDTO) {
        return null;
    }

    public ResponseEntity<?> delete(final ObjectId id) {
        return null;
    }
}
