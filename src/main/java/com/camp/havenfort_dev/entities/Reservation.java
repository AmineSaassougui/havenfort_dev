package com.camp.havenfort_dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idReservation;
    private String prenom;
    private String nom;
    private String mail;
    private Date date;

    @ManyToOne
    @JsonIgnore
    private Event event;

    @ManyToMany(mappedBy="reservations", cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;

}
