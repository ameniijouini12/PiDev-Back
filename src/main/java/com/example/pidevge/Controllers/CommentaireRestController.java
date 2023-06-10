package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.Commentaire;
import com.example.pidevge.interfaces.ICommentaireService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaires")

@AllArgsConstructor
public class CommentaireRestController {

ICommentaireService commentaireService;


    @GetMapping("/getall")
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public Commentaire getCommentaireById(@PathVariable Long id) {
        return commentaireService.getCommentaireById(id);
    }

    @PostMapping
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire) {
        return commentaireService.createCommentaire(commentaire);
    }

    @PutMapping("/{id}")
    public Commentaire updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        commentaire.setId(id);
        return commentaireService.updateCommentaire(commentaire);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaireById(id);
    }


}
