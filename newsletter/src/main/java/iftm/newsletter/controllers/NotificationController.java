package iftm.newsletter.controllers;

import iftm.newsletter.models.NotificationMessage;
import iftm.newsletter.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService messagingService;

    @PostMapping
    public ResponseEntity<?> sendNotificationByToken(@RequestBody final NotificationMessage notificationMessage) {
        return messagingService.sendNotification(notificationMessage);
    }
}
