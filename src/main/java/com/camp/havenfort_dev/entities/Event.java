package com.camp.havenfort_dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String type;
    @JsonIgnore
    @OneToMany(mappedBy="event", cascade=CascadeType.ALL)
    private Set<Activity> activities;

    @ManyToOne
    @JsonIgnore
    private Campsite campsite;

    @ManyToOne
    @JsonIgnore
    private CenterOfCamp centerOfCamp;

    @JsonIgnore
    @OneToMany(mappedBy="event", cascade=CascadeType.ALL)
    private Set<Reservation> reservations ;

    @ManyToMany(mappedBy="events", cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;


}
