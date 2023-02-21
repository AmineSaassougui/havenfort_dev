package com.camp.havenfort_dev.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Delivrey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idLiv;
    @Temporal(TemporalType.DATE)
    private Date DateLivr;
    private String status;
    @OneToMany
    List<invoice> invoices;
    public Long getIdLiv() {
        return idLiv;
    }
    public void setIdLiv(Long idLiv) {
        this.idLiv = idLiv;
    }
    public Date getDateLivr() {
        return DateLivr;
    }
    public void setDateLivr(Date dateLivr) {
        DateLivr = dateLivr;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Delivrey() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Delivrey(Long idLiv, Date dateLivr, String status) {
        super();
        this.idLiv = idLiv;
        DateLivr = dateLivr;
        this.status = status;
    }




}
