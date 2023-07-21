package com.example.pidevge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String email;
    private String nom;
    private String prenom;
    private String mail;
    private String num;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;
    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    private List<feedback> feedbacks;
    @OneToMany
    private List<Reclamation> reclamations;
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Sujet> sujets ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Formation> formations;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Event> events;
}
