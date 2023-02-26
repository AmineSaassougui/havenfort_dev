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
public class CenterOfCamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idCenterOfCamp;
    private String nomCenter;
    private String lieuCenter;
    private String owner;
    private Integer capacity;
    private Integer nbStaff;
    private String opening;
    private String closure;
    private TypeCenAct typeCenter;

    @JsonIgnore
    @OneToMany(mappedBy="centerOfCamp", cascade=CascadeType.ALL)
    private Set<Event> events;
}
