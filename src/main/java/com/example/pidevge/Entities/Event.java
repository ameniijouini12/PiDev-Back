package com.example.pidevge.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private String lieu;
    private int capaciteMaximale;
    private double coutParticipation;
    private int nbPlaceRestantes;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int rating;
    private String affiche;
    @OneToOne(mappedBy = "event",cascade = CascadeType.ALL)
    private Booking booking;
}
