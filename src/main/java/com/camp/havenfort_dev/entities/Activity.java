package com.camp.havenfort_dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idActivity;
    private String type;
    private String lieu;
    private Boolean archive;
    
    @ManyToOne
    @JsonIgnore
    private Event event;
}
