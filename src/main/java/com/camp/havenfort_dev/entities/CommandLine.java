package com.camp.havenfort_dev.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommandLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCommLine;
    private int quantite;
    @ManyToOne
    panier panier;


    @ManyToOne
    Tools tools ;

    public Long getIdCommLine() {
        return idCommLine;
    }
    public void setIdCommLine(Long idCommLine) {
        this.idCommLine = idCommLine;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public CommandLine(Long idCommLine, int quantite) {
        super();
        this.idCommLine = idCommLine;
        this.quantite = quantite;
    }
    public CommandLine() {
        super();
        // TODO Auto-generated constructor stub
    }



}
