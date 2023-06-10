package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Reclamation;
import com.example.pidevge.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
