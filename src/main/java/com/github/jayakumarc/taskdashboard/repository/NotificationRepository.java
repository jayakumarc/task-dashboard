package com.github.jayakumarc.taskdashboard.repository;

import com.github.jayakumarc.taskdashboard.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
