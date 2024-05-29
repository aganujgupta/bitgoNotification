package com.bitgo.Notification.Controllers;

import com.bitgo.Notification.Models.Notification;
import com.bitgo.Notification.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
        notification = notificationService.createNotification(notification);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(notification);
    }

    @PutMapping("/notification")
    public ResponseEntity<Notification> updateNotification(@RequestBody Notification notification){
        notification = notificationService.updateNotification(notification);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(notification);
    }

    @GetMapping("/notificationList")
    public ResponseEntity<List<Notification>> getNotificationList(){
        List<Notification> notificationList = notificationService.getNotificationList();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(notificationList);
    }

    @PutMapping("/send-notification")
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification){
        String id = notification.getId();
        List<String> emailIds = notification.getEmailIdList();
        notification = notificationService.sendNotification(id,emailIds);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(notification);
    }
}
