package com.example.demo.businessLayer.service.Notification;

import com.example.demo.businessLayer.to.NotificationTO;

import java.util.List;

public interface INotification {
    public StringBuilder GenerateTags(List<NotificationTO> notifications);
    public StringBuilder convertToScript(StringBuilder htmlString);
}
