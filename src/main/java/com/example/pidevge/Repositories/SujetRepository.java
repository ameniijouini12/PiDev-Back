package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetRepository extends JpaRepository<Sujet, Long>{
}
