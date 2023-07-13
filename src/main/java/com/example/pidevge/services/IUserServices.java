package com.example.pidevge.services;

import java.util.List;

import com.example.pidevge.Entities.User;
import com.example.pidevge.Entities.UserType;
import com.example.pidevge.Repositories.Iuser;

public interface IUserServices {

    
    User addUser (User user);
    public List<User> retrieveAllUsers() ;
    public User retrieveUser(Integer idUser);
    public void removeUser(Integer idUser);

    public User updateUser(Integer id, User user) ;

    public List<User> retrieveUserByUserType(UserType userType );
    public List<User> retrieveUserStatus(Boolean isActive );


    
}