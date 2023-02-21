package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.CommandLine;
import com.camp.havenfort_dev.entities.Delivrey;
import com.camp.havenfort_dev.entities.invoice;
import com.camp.havenfort_dev.entities.panier;
import com.camp.havenfort_dev.repositories.CommandeRepo;
import com.camp.havenfort_dev.repositories.DeliveryRepo;
import com.camp.havenfort_dev.repositories.PanierRepo;
import com.camp.havenfort_dev.repositories.invoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCommande implements IServiceCommande {

    @Autowired
    CommandeRepo cr;
    @Autowired
    invoiceRepo ir;
    @Autowired
    PanierRepo pr;
    @Autowired
    DeliveryRepo dr;


    @Override
    public void ajoutercommande(CommandLine c) {
        cr.save(c);

    }

    @Override
    public void modifiercommande(CommandLine c) {
        cr.save(c);

    }





    @Override
    public void ajouterpanier(panier c) {
        pr.save(c);

    }

    @Override
    public void modifierpanier(panier c) {
        pr.save(c);

    }




    @Override
    public void ajouterinvoice(invoice c) {
        ir.save(c);
    }

    @Override
    public void modifierinvoice(invoice c) {
        ir.save(c);

    }



    @Override
    public void ajouterdelivery(Delivrey c) {
        dr.save(c);

    }

    @Override
    public void modifierdelivery(Delivrey c) {
        dr.save(c);

    }

    @Override
    public void supprimerdelivery(Long id) {
        dr.deleteById(id);

    }



    @Override
    public void supprimercommande(Long id) {
        cr.deleteById(id);

    }

    @Override
    public void supprimerinvoice(Long id) {
        ir.deleteById(id);


    }

    @Override
    public List<CommandLine> affichercommande() {
        return (List<CommandLine>)cr.findAll();
    }

    @Override
    public List<panier> afficherpanier() {
        return (List<panier>)pr.findAll();
    }

    @Override
    public List<invoice> afficherinvoice() {
        return (List<invoice>)ir.findAll();
    }

    @Override
    public List<Delivrey> afficherdelivery() {

        return (List<Delivrey>)dr.findAll();
    }

    @Override
    public List<CommandLine> intercommunicate() {
        return null;
    }

    @Override
    public void supprimerpanier(Long panierid) {

    }

}
