package com.camp.havenfort_dev.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pid ;
    private String pname ;
    private double discountAmount ;
    @Temporal(TemporalType.DATE)
    private Date startdate ;
    @Temporal(TemporalType.DATE)
    private Date enddate ;
    private boolean isActive ;
    @ManyToMany
    private Set<Tools> tools ;
    @ManyToMany
    private Set<Shop> shops;
    private String promoCode;


}
