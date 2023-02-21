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

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idc ;
    private String cname ;
    private  String cdescription ;

    @OneToMany(mappedBy = "category",  cascade =CascadeType.ALL)
    private Set<Tools> tools ;

}
