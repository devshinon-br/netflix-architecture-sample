package iftm.logpool.models.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PostDTO implements Serializable {
    private String title;
    private String authorName;
    private String body;
    private List<TagDTO> tags;

    public PostDTO() {
    }

    public PostDTO(final String title, final String authorName, final String body, final List<TagDTO> tags) {
        this.title = title;
        this.authorName = authorName;
        this.body = body;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(final List<TagDTO> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PostDTO postDTO = (PostDTO) o;
        return Objects.equals(title, postDTO.title) && Objects.equals(authorName, postDTO.authorName) && Objects.equals(body, postDTO.body) && Objects.equals(tags, postDTO.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName, body, tags);
    }

    @Override
    public String toString() {
        return "PostDTO{" + "title='" + title + '\'' + ", authorName='" + authorName + '\'' + ", body='" + body + '\'' + ", tags=" + tags + '}';
    }
}
