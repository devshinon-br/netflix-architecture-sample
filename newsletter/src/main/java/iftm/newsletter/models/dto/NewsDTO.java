package iftm.newsletter.models.dto;

import iftm.newsletter.models.News;
import iftm.newsletter.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO implements Serializable {
    private String id;
    private String title;
    private String date;
    private String editorName;
    private List<Post> posts;

    public NewsDTO(final News news) {
        if (news.getId() != null) this.id = news.getId().toString();
        this.title = news.getTitle();
        this.editorName = news.getEditorName();
        this.date = news.getDate();
        this.posts = news.getPosts();
    }

    public News toNews() {
        ObjectId id = null;
        if (this.id != null)
            id = new ObjectId(this.id);

        return new News(
            id,
            this.title,
            this.date,
            this.editorName,
            this.posts
        );
    }
}
