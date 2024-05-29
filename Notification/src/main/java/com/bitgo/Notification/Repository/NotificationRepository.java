package com.bitgo.Notification.Repository;

import com.bitgo.Notification.Models.Notification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NotificationRepository {

    private static Map<String, Notification> notifications = new HashMap<>();

    public Notification getNotificationById(String id){
        return notifications.get(id);
    }

    public Notification saveNotification(Notification notification){
        notifications.put(notification.getId(),notification);
        return notification;
    }

    public List<Notification> getAllNotifications(){
        List<Notification> notificationList = new ArrayList<>();
        notifications.forEach((key,value) -> notificationList.add(value));
        return notificationList;
    }

}
