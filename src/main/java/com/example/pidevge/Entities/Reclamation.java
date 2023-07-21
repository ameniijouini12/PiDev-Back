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
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idRec;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;

    private Date date;

    @Enumerated(EnumType.STRING)
    private statut statut;
}
