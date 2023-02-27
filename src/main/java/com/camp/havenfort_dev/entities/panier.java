package com.camp.havenfort_dev.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpanier;
    private float discout;
    @OneToOne
    invoice invoice;
    @OneToMany
    List<CommandLine> commandeLines;


    public Long getIdpanier() {
        return idpanier;
    }
    public void setIdpanier(Long idpanier) {
        this.idpanier = idpanier;
    }
    public float getDiscout() {
        return discout;
    }
    public void setDiscout(float discout) {
        this.discout = discout;
    }
    public panier() {
        super();
        // TODO Auto-generated constructor stub
    }
    public panier(Long idpanier, float discout) {
        super();
        this.idpanier = idpanier;
        this.discout = discout;
    }

}
