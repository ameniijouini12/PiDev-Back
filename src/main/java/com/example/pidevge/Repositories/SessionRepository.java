package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Reclamation;

import com.example.pidevge.Entities.session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<session,Integer> {
}
