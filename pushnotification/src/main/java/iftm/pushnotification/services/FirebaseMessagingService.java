package iftm.pushnotification.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import iftm.pushnotification.notification.models.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public ResponseEntity<?> sendNotification(final NotificationMessage notificationMessage) {
        var notification = Notification
            .builder()
            .setTitle(notificationMessage.getTitle())
            .setBody(notificationMessage.getBody())
            .setImage(notificationMessage.getImage())
            .build();

        var message = Message
            .builder()
            .setToken(notificationMessage.getRecipientToken())
            .setNotification(notification)
            .putAllData(notificationMessage.getData())
            .build();

        try {
            firebaseMessaging.send(message);
            return ResponseEntity.ok().build();

        } catch (FirebaseMessagingException ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
