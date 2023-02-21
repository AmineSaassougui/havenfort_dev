package com.camp.havenfort_dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
(class declaraion)
public class Tools implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idt;

(class declaraion)
    private String name ;
    private double price ;
    private int quantity ;
    @Enumerated(EnumType.STRING)

    @Column(name = "tools_condition")
    private  Condition condition ;
    private  String description ;
    private String image ;
    @Enumerated(EnumType.STRING)
    private  Availability availability ;
    @ManyToMany(mappedBy ="tools", cascade =CascadeType.ALL)
    private Set<Promotion> promos ;

    @ManyToMany(mappedBy ="tools", cascade =CascadeType.ALL)

    private Set<Shop> shops ;
    @ManyToOne
    @JsonIgnore
    private Category category ;


}