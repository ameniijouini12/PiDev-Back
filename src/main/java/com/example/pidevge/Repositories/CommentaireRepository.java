package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository  extends JpaRepository<Commentaire, Long> {
}
