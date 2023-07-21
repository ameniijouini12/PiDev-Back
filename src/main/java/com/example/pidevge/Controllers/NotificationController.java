package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.Notification;
import com.example.pidevge.Entities.User;
import com.example.pidevge.interfaces.NotificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/{userId}/send")
    public void sendNotification(@PathVariable Integer idUser, @RequestBody String content) {
        // Ici, vous pouvez obtenir l'utilisateur à partir de son ID (à partir de votre service User) et appeler sendNotification
        // Vous pouvez également ajouter des vérifications supplémentaires avant d'envoyer la notification, par exemple si l'utilisateur existe, etc.
        User user = getUserById(idUser); // Remplacez getUserById avec votre logique pour récupérer un utilisateur par son ID
        notificationService.sendNotification(user, content);
    }

    @GetMapping("/{userId}/all")
    public List<Notification> getAllNotificationsForUser(@PathVariable Integer userId) {
        // Obtenez l'utilisateur à partir de son ID et renvoyez toutes ses notifications
        User user = getUserById(userId); // Remplacez getUserById avec votre logique pour récupérer un utilisateur par son ID
        return notificationService.getAllNotificationsForUser(user);
    }


    private User getUserById(Integer idUser) {

        User user = new User();
        user.setIdUser(idUser);
        user.setNom("john_doe");
        user.setEmail("john.doe@example.com");
        return user;
    }
}
