package com.camp.havenfort_dev.service;

import com.camp.havenfort_dev.entity.Reclamation;

import java.util.List;

public interface ReclamationService {

    void addReclamation(Reclamation Reclamation);
    List<Reclamation> getAllReclamations();
    Reclamation findById(long id) ;
    String DeleteAccount(long id) ;
    Reclamation UpdateReclamation(Reclamation Reclamation);
    
}
