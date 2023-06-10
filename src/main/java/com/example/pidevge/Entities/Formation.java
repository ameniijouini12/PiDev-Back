package com.example.pidevge.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormation;

    private String nom;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String description;
    private String lieu;
    private int capaciteMaximale;
    private double coutParticipation;
    private Long idFormateur;
    private int rating;
}
