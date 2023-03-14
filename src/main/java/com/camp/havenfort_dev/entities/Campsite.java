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
public class Campsite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idCampsite;
    private String distance;
    private String description;
    private  String adresse;
    private String altitude;
    private String longitude;
    @JsonIgnore
    @OneToMany(mappedBy="campsite", cascade=CascadeType.ALL)
    private Set<Event> events;
}
