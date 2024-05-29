package com.bitgo.Notification.Services;

import com.bitgo.Notification.Models.Notification;
import com.bitgo.Notification.Models.Status;
import com.bitgo.Notification.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification){
        notification.setStatus(Status.draft);
        notification.setId(generateId());
        notificationRepository.saveNotification(notification);
        return notification;
    }

    public List<Notification> getNotificationList(){
        return notificationRepository.getAllNotifications();
    }

    public Notification updateNotification(Notification notification){
        notificationRepository.saveNotification(notification);
        return notification;
    }

    public Notification sendNotification(String id, List<String> emailIds){
        Notification notification = notificationRepository.getNotificationById(id);
        notification.setEmailIdList(emailIds);
        notification.setStatus(Status.sent);
        notificationRepository.saveNotification(notification);
        return notification;
    }

    private String generateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
