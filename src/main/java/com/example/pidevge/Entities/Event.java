package com.example.pidevge.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvent;
    private String nom;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String description;
    private String lieu;
    private int capaciteMaximale;
    private double coutParticipation;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int rating;

}
