package com.example.pidevge.services;

import com.example.pidevge.Entities.Commentaire;
import com.example.pidevge.Repositories.CommentaireRepository;
import com.example.pidevge.interfaces.ICommentaireService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CommentaireServiceImp implements ICommentaireService {

    @Autowired
    CommentaireRepository commentaireRepository;


    public Commentaire getCommentaireById(Long id) {
        return commentaireRepository.findById(id).orElse(null);
    }

    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public Commentaire updateCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public void deleteCommentaireById(Long id) {
        commentaireRepository.deleteById(id);
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }
}
