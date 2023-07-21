package com.example.pidevge.Repositories;


import com.example.pidevge.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {
}
