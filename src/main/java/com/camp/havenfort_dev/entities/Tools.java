package com.camp.havenfort_dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Tools implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idt;


    private String name ;
    private double price ;
    private int quantity ;
    @Enumerated(EnumType.STRING)
    private  Condition conndition ;
    private  String description ;
    private String reviews;
    @Enumerated(EnumType.STRING)
    private ToolStatus status;
    private String image ;
    @Enumerated(EnumType.STRING)
    private  Availability availability ;
    @ManyToMany(mappedBy ="tools", cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<Promotion> promos ;


    @ManyToMany(mappedBy ="tools", cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<Shop> shops ;
    @ManyToOne
    @JsonIgnore
    private Category category ;


    @OneToMany(mappedBy = "tools", cascade = CascadeType.ALL)
    private List<CommandLine> commandeLines;

    @ManyToOne
    private User users ;

    @ManyToMany
    @JsonIgnore
    private Set<Reclamation> reclamations ;



}
