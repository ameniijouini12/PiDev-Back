package com.example.pidevge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Sujet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categorie;
    private String description;
    private Long userId;
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private User user;

}
