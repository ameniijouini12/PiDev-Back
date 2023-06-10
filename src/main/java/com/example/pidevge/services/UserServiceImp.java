package com.example.pidevge.services;

import com.example.pidevge.Entities.User;
import com.example.pidevge.Repositories.UserRepository;
import com.example.pidevge.interfaces.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImp implements IUserService {
    @Autowired
	UserRepository userRepository ;
	
	public List<User> retrieveAllUsers(){
	return  userRepository.findAll();
	}

	public User addUser (User user){
		return userRepository.save(user);
	}

	public User updateUser (User user){
		return userRepository.save(user);
	}

	public User retrieveUser(Integer  idUser){
		return userRepository.findById(idUser).get();
	}

	public void removeUser(Integer idUser){
        User user=retrieveUser(idUser);
        userRepository.delete(user);
	}
}
