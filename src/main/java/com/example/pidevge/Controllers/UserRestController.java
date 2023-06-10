package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.User;
import com.example.pidevge.interfaces.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
@RequestMapping("/User")
@Slf4j
public class UserRestController {
    IUserService userService;

    @GetMapping("/retrieve-all-users")
    public List<User> getUsers() {
        return userService.retrieveAllUsers();
    }

    @GetMapping("/retrieve-user/{id}")
    public User retrieveUser(@PathVariable("id") Integer idUser) {
        return userService.retrieveUser(idUser);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/remove-user/{user-id}")
    public void removeUser(Integer idUser) {
        userService.removeUser(idUser);
    }

    @PutMapping("/update-user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    
}
