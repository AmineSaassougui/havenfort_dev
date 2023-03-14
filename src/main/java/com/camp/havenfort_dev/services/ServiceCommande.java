package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.CommandLine;
import com.camp.havenfort_dev.entities.Delivrey;
import com.camp.havenfort_dev.entities.invoice;
import com.camp.havenfort_dev.entities.panier;
import com.camp.havenfort_dev.repositories.CommandeRepo;
import com.camp.havenfort_dev.repositories.DeliveryRepo;
import com.camp.havenfort_dev.repositories.PanierRepo;
import com.camp.havenfort_dev.repositories.invoiceRepo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

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
    public void ajoutercommande(CommandLine c, String num, String msg, String to, String subject, String text) {
        envoyerSMS(num, msg);
        envoyerEmail(to,subject,text);
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
    panier p= pr.findById(panierid).get();
    pr.delete(p);
    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("seifeddine.naloufi1@esprit.tn");
        mailSender.setPassword("GoogleMeet");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
    @Autowired
    private JavaMailSender emailSender;

     @Override
    public void envoyerEmail(String to, String subject, String text) {

              SimpleMailMessage message = new SimpleMailMessage();
             message.setFrom("karim.troudi@esprit.tn");
             message.setTo(to);
             message.setSubject(subject);
             message.setText(text);
             emailSender.send(message);
          }



    @Override
    public void envoyerSMS(String num, String msg) {
            Twilio.init("TWILIO_ACCOUNT_SID","TWILIO_AUTH_TOKEN");

            Message.creator(new PhoneNumber(num),
                    new PhoneNumber("<FROM number - ie your Twilio number"), msg).create();
      }


    @Override
    public ResponseEntity<?> recherch(String keyword, String type) {
       if (type == "commande") {
           if (keyword != null) {
               return new ResponseEntity<List<CommandLine>>(cr.search(keyword), HttpStatus.OK);
           }
           return new ResponseEntity<Iterable<CommandLine>>(cr.findAll(), HttpStatus.OK);
       }
       else if (type == "invoice") {
           if (keyword != null) {
               return new ResponseEntity<List<invoice>>(ir.search(keyword), HttpStatus.OK);
           }
           return new ResponseEntity<Iterable<invoice>>(ir.findAll(), HttpStatus.OK);

       } else if (type == "deliviry") {
           if (keyword != null) {
               return new ResponseEntity<List<Delivrey>>(dr.search(keyword), HttpStatus.OK);
           }
           return new ResponseEntity<Iterable<Delivrey>>(dr.findAll(), HttpStatus.OK);

       }

        return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);

    }
}
