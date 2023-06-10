package com.example.pidevge.interfaces;

import java.util.List;

import com.example.pidevge.Entities.User;

public interface IUserService {
    
    public List<User> retrieveAllUsers();

    public User addUser (User user);

    public User updateUser (User user);

    public User retrieveUser(Integer  idUser);
 
    public void removeUser(Integer idUser);
}
