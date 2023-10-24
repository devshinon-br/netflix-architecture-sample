package iftm.newsletter.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage implements Serializable {
    private String recipientToken;
    private String title;
    private String body;
    private String image;
    private Map<String, String> data;
}
