package com.example.pidevge.services;


    import com.example.pidevge.Entities.Notification;
    import com.example.pidevge.Entities.User;
    import com.example.pidevge.Repositories.NotificationRepository;
    import com.example.pidevge.interfaces.NotificationService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
        private final NotificationRepository notificationRepository;
        private final JavaMailSender mailSender;

    @Override
        public void sendNotification(User user, String content) {
            Notification notification = new Notification();
            notification.setUser(user);
            notification.setContent(content);
            notification.setCreatedDateTime(LocalDateTime.now());
            notification.setRead(false);
            notificationRepository.save(notification);

            // Envoi de l'e-mail de notification
            sendNotificationEmail(user.getEmail(), content);
        }

        @Override
        public List<Notification> getAllNotificationsForUser(User user) {
            return notificationRepository.findByUser(user);
        }

        private void sendNotificationEmail(String to, String content) {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper;
            try {
                helper = new MimeMessageHelper(message, true);
                helper.setTo(to);
                helper.setSubject("Nouvelle notification");
                helper.setText(content, true);
                mailSender.send(message);
            } catch (MessagingException e) {
                // Gérer les erreurs d'envoi d'e-mail si nécessaire
            }
        }

        // Implémentez d'autres méthodes si nécessaire
        // ...
    }


