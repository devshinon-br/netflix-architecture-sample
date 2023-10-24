package iftm.pushnotification.notification.models;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
public class NotificationMessage implements Serializable {
    private String recipientToken;
    private String title;
    private String body;
    private String image;
    private Map<String, String> data;
}
