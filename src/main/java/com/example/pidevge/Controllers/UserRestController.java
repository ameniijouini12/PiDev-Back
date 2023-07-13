package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.User;
import com.example.pidevge.Entities.UserType;
import com.example.pidevge.services.IUserServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/AUTH/auth")
@Slf4j
public class UserRestController {
    IUserServices iUserServices;


    @GetMapping("/retrieve-users-by-type/{userType}")
    public List<User> getUsersByType(@PathVariable("userType") UserType userType) {
        return iUserServices.retrieveUserByUserType(userType);
    }

    @GetMapping("/retrieve-users-by-status/{isActive}")
    public List<User> getUsersByStatus(@PathVariable("isActive") Boolean isActive) {
        return iUserServices.retrieveUserStatus(isActive);
    }

    @GetMapping("/retrieve-all-users")
    public List<User> getUsers() {
        return iUserServices.retrieveAllUsers();
    }

    @GetMapping("/retrieve-user/{id}")
    public User retrieveUser(@PathVariable("id") Integer idUser) {
        return iUserServices.retrieveUser(idUser);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return iUserServices.addUser(user);
    }

    @DeleteMapping("/remove-user/{user-id}")
    public void removeUser(Integer idUser) {
        iUserServices.removeUser(idUser);
    }

 
    @PutMapping("/UserUpdate/{id}")
    public User updateUser(@PathVariable(value = "id")Integer id,@Valid @RequestBody User user) {
        return iUserServices.updateUser(id, user);
    }
    

    @PutMapping("/enable-user-status/{id}")
    public ResponseEntity<String> updateUserStatus(@PathVariable("id") Integer idUser) {
    User user = iUserServices.retrieveUser(idUser);
    if (user != null) {
        user.setIsActive(user.isEnabled());
        iUserServices.updateUser(idUser, user);
        String message = user.isEnabled() ? "User account enabled successfully." : "User account disabled successfully.";
        return ResponseEntity.ok(message);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }
}


@PutMapping("/disable-user-status/{id}")
    public ResponseEntity<String> disableUserStatus(@PathVariable("id") Integer idUser) {
    User user = iUserServices.retrieveUser(idUser);
    if (user != null) {
        user.setIsActive(!user.isEnabled());
        iUserServices.updateUser(idUser, user);
        String message = user.isEnabled() ? "User account disabled successfully." : "User account enabled successfully.";
        return ResponseEntity.ok(message);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }
}
}
