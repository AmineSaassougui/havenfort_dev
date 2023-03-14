package com.camp.havenfort_dev.controller;

import com.camp.havenfort_dev.entities.CommandLine;
import com.camp.havenfort_dev.entities.Delivrey;
import com.camp.havenfort_dev.entities.invoice;
import com.camp.havenfort_dev.entities.panier;
import com.camp.havenfort_dev.services.IServiceCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CommandeController {
    @Autowired
    IServiceCommande sr;

    @PostMapping("/modifiercommande")
    void modifiercommande(@RequestBody CommandLine c)
    {
        sr.modifiercommande(c);
    }
    @PostMapping("/ajoutercommande")
    void ajoutercommande(@RequestBody CommandLine c,@Param("num") String num,@Param("msg") String msg
            ,@Param("to") String to,@Param("subject") String subject,@Param("text") String text) {
        sr.ajoutercommande(c,num,msg,to,subject,text);
    }
    @PostMapping("/ajouterpanier")
    void ajouterpanier(@RequestBody panier c)
    {
        sr.ajouterpanier(c);
    }

    @PostMapping("/modifierpanier")
    void modifierpanier(@RequestBody panier c)
    {
        sr.modifierpanier(c);
    }

    @PostMapping("/ajouterinvoice")
    void ajouterinvoice(@RequestBody invoice c)
    {
        sr.ajouterinvoice(c);
    }

    @PostMapping("/modifierinvoice")
    void modifierinvoice(@RequestBody invoice c)
    {
        sr.modifierinvoice(c);
    }
    @PostMapping("/ajouterdelivery")
    void ajouterdelivery(@RequestBody Delivrey c)
    {
        sr.ajouterdelivery(c);
    }

    @PostMapping("/modifierdelivrey")
    void modifierdelivrey(@RequestBody Delivrey c)
    {
        sr.modifierdelivery(c);
    }
    @GetMapping("/retrieve-all-commande")
    public List<CommandLine> getcommande() {

        return sr.intercommunicate();
    }
    @GetMapping("/retrieve-all-panier")
    public List<panier> getpanier() {

        return sr.afficherpanier();
    }
    @GetMapping("/retrieve-all-delivery")
    public List<Delivrey> getdelivery() {

        return sr.afficherdelivery();
    }

    @GetMapping("/retrieve-all-invoice")
    public List<invoice> getinvoice() {

        return sr.afficherinvoice();
    }
    @DeleteMapping("/remove-panier/{panier-id}")
    @ResponseBody
    public void supprimerPanier(@PathVariable("panier-id") Long panierid) {
        sr.supprimerpanier(panierid);
    }
    @DeleteMapping("/remove-commande/{commande-id}")
    @ResponseBody
    public void supprimerCommande(@PathVariable("commande-id") Long commandeid) {
        sr.supprimercommande(commandeid);
    }
    @DeleteMapping("/remove-delivery/{delivery-id}")
    @ResponseBody
    public void supprimerdelivery(@PathVariable("delivery-id") Long deliveryid) {
        sr.supprimerdelivery(deliveryid);
    }
    @DeleteMapping("/remove-invoice/{invoice-id}")
    @ResponseBody
    public void supprimerinvoice(@PathVariable("invoice-id") Long invoiceid) {
        sr.supprimerinvoice(invoiceid);
    }

}
