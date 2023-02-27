package com.camp.havenfort_dev.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rec ;

    private String contenue ;
    private String sujet ;
    private Date datecrea ;

    @ManyToOne
    @JoinColumn(name="id_user",referencedColumnName = "id")
    private User etages;

    @ManyToMany(mappedBy = "reclamations",cascade = CascadeType.ALL)
    private Set<Tools> tools ;



    public long getId_rec() {
        return id_rec;
    }

    public void setId_rec(long id_rec) {
        this.id_rec = id_rec;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDatecrea() {
        return datecrea;
    }

    public void setDatecrea(Date datecrea) {
        this.datecrea = datecrea;
    }

    public User getEtages() {
        return etages;
    }

    public void setEtages(User etages) {
        this.etages = etages;
    }
}
