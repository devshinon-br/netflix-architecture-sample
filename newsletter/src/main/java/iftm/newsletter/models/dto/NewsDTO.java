package iftm.newsletter.models.dto;

import iftm.newsletter.models.News;
import iftm.newsletter.models.Post;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

public class NewsDTO implements Serializable {
    private String id;
    private String title;
    private String date;
    private String editorName;
    private List<Post> posts;

    public NewsDTO() {
    }

    public NewsDTO(final String title, final String date, final String editorName, final List<Post> posts) {
        this.title = title;
        this.date = date;
        this.editorName = editorName;
        this.posts = posts;
    }

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

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(final String editorName) {
        this.editorName = editorName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(final List<Post> posts) {
        this.posts = posts;
    }
}
