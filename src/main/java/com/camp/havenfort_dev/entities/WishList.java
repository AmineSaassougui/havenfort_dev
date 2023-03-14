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
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;


    @JsonIgnore
    @OneToMany(mappedBy = "wishList",fetch = FetchType.EAGER)
    private Set<Activity> activities;


    @JsonIgnore
    @OneToOne(mappedBy = "wishList")
    private User user;
}
