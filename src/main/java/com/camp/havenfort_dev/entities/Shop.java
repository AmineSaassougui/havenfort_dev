package com.camp.havenfort_dev.entities;

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


public class Shop implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idshop;
    private String nameshop ;
    private String address ;
    private String phonenumber ;

    @ManyToMany
    private Set<Tools> tools ;







}
