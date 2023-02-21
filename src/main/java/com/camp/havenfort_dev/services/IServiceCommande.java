package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.CommandLine;
import com.camp.havenfort_dev.entities.Delivrey;
import com.camp.havenfort_dev.entities.invoice;
import com.camp.havenfort_dev.entities.panier;

import java.util.List;

public interface IServiceCommande {
    void ajoutercommande(CommandLine c);
    void modifiercommande(CommandLine c);
    void supprimercommande(Long id);
    List<CommandLine> affichercommande();


    void ajouterpanier(panier c);
    void modifierpanier(panier c);

    List<panier> afficherpanier();


    void ajouterinvoice(invoice c);
    void modifierinvoice(invoice c);
    void supprimerinvoice(Long id);
    List<invoice> afficherinvoice();


    void ajouterdelivery(Delivrey c);
    void modifierdelivery(Delivrey c);
    void supprimerdelivery(Long id);
    List<Delivrey> afficherdelivery();


    List<CommandLine> intercommunicate();

    void supprimerpanier(Long panierid);
}
