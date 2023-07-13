package com.example.pidevge.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pidevge.Entities.User;
import com.example.pidevge.Entities.UserType;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class UserService implements IUserServices {
    @Autowired
    com.example.pidevge.Repositories.Iuser iuserRpo ;

    @Override
    public User addUser(User user) {
        return iuserRpo.save(user);
    }

    @Override
    public List<User> retrieveAllUsers() {
        return iuserRpo.findAll();
    }

    @Override
    public User retrieveUser(Integer idUser) {
        return iuserRpo.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void removeUser(Integer idUser) {
        iuserRpo.deleteById(idUser);
    }

    public User updateUser(Integer id, User user) {
		return iuserRpo.save(user);
	}


    public List<User> retrieveUserByUserType(UserType userType) {
        return iuserRpo.findByUserType(userType);
    }

    public List<User> retrieveUserStatus(Boolean isActive) {
        return iuserRpo.findByIsActive(isActive);
    }

   
}

