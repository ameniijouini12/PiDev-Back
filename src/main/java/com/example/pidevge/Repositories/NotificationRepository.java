package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Notification;
import com.example.pidevge.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByUser(User user);

}
