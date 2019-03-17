package com.github.jayakumarc.taskdashboard.rest;

import java.util.List;
import javax.validation.Valid;
import com.github.jayakumarc.taskdashboard.model.Notification;
import com.github.jayakumarc.taskdashboard.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping("/notifications")
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @PostMapping("/notifications")
    public Notification createNotification(@Valid @RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }

    @GetMapping("/notifications/{id}")
    public Notification getNotificationById(@PathVariable(value = "id") Long notificationId) {
        return notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Notification with id %s not found", notificationId)));
    }

}
