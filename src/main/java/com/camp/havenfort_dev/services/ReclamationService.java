package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Reclamation;

import java.util.List;

public interface ReclamationService {

    void addReclamation(Reclamation Reclamation);
    List<Reclamation> getAllReclamations();
    Reclamation findById(long id) ;
    String DeleteAccount(long id) ;
    Reclamation UpdateReclamation(Reclamation Reclamation);
    
}
