package com.camp.havenfort_dev.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private String pricing_desc;
    private Date date_purchase;
    private String shipping_detail;
    private float total;
    private int phone;
    private float discout;
    @OneToOne
    panier panier;
    @ManyToOne
    Delivrey delivrey;
    public Long getIdFacture() {
        return idFacture;
    }
    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }
    public String getPricing_desc() {
        return pricing_desc;
    }
    public void setPricing_desc(String pricing_desc) {
        this.pricing_desc = pricing_desc;
    }
    public Date getDate_purchase() {
        return date_purchase;
    }
    public void setDate_purchase(Date date_purchase) {
        this.date_purchase = date_purchase;
    }
    public String getShipping_detail() {
        return shipping_detail;
    }
    public void setShipping_detail(String shipping_detail) {
        this.shipping_detail = shipping_detail;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public float getDiscout() {
        return discout;
    }
    public void setDiscout(float discout) {
        this.discout = discout;
    }
    public invoice(Long idFacture, String pricing_desc, Date date_purchase, String shipping_detail, float total,
                   int phone, float discout) {
        super();
        this.idFacture = idFacture;
        this.pricing_desc = pricing_desc;
        this.date_purchase = date_purchase;
        this.shipping_detail = shipping_detail;
        this.total = total;
        this.phone = phone;
        this.discout = discout;
    }
    public invoice() {
        super();
        // TODO Auto-generated constructor stub
    }

}
