package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Formation;
import com.example.pidevge.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository  extends JpaRepository<Formation,Integer> {
}
