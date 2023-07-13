package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Reclamation;
import com.example.pidevge.Entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.pidevge.Entities.UserType;

@Repository
public interface Iuser extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    List<User> findByUserType(UserType userType);
    List<User> findByIsActive(Boolean isActive);

}



    