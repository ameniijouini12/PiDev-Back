package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Formation;
import com.example.pidevge.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FormationRepository  extends JpaRepository<Formation,Integer> {



    // Méthode pour filtrer les formations par nom (utilisation de la clause "LIKE" dans la requête SQL)
    List<Formation> findByNomContainingIgnoreCase(String keyword);

    // Méthode pour filtrer les formations par date de début (utilisation de la clause ">= date" dans la requête SQL)
    List<Formation> findByDateDebutGreaterThanEqual(LocalDateTime startDate);

    // Méthode pour filtrer les formations par nom et date de début (combinaison des deux critères)
    List<Formation> findByNomContainingIgnoreCaseAndDateDebutGreaterThanEqual(String keyword, LocalDateTime startDate);
}
