package iftm.logpool.models.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class NewsDTO implements Serializable {

    private String id;
    private String title;
    private String date;
    private String editorName;
    private List<PostDTO> posts;

    public NewsDTO() {
    }

    public NewsDTO(final String title, final String date, final String editorName, final List<PostDTO> posts) {
        this.title = title;
        this.date = date;
        this.editorName = editorName;
        this.posts = posts;
    }

    public NewsDTO(final String id, final String title, final String date, final String editorName, final List<PostDTO> posts) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.editorName = editorName;
        this.posts = posts;
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

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(final List<PostDTO> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final NewsDTO newsDTO = (NewsDTO) o;
        return Objects.equals(id, newsDTO.id) && Objects.equals(title, newsDTO.title) && Objects.equals(date, newsDTO.date) && Objects.equals(editorName, newsDTO.editorName) && Objects.equals(posts, newsDTO.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, editorName, posts);
    }

    @Override
    public String toString() {
        return "NewsDTO{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", date='" + date + '\'' + ", editorName='" + editorName + '\'' + ", posts=" + posts + '}';
    }
}
