package iftm.newsletter.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String title;
    private String authorName;
    private String body;
    private List<Tag> tags;
}
