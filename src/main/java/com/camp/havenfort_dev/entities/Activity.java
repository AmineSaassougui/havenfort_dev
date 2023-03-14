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
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idActivity;
    private String name;
    private String date;
    private String lieu;
    private String price;
    private Boolean archive;
    @Enumerated(EnumType.STRING)
    private TypeCenAct typeActivity;
    @ManyToOne
    @JsonIgnore
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy="activity", cascade=CascadeType.ALL)
    private Set<ActivityLike> activityLikes;



    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private WishList wishList;
}
