package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.Commentaire;

import java.util.List;

public interface ICommentaireService {
    public List<Commentaire> getAllCommentaires();
    public Commentaire getCommentaireById(Long id);
    public Commentaire createCommentaire(Commentaire commentaire);
    public Commentaire updateCommentaire(Commentaire commentaire);
    public void deleteCommentaireById(Long id);
}
