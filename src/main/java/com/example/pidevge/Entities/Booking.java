package com.example.pidevge.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBooking;
    @ManyToOne
    private User user;
    @OneToOne
    private Event event;
    private boolean state;
    private double price;

    public Booking(User user, Event event, boolean state, double price) {
        this.user = user;
        this.event = event;
        this.state = state;
        this.price = price;
    }
}

