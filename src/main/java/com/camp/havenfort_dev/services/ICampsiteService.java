package com.camp.havenfort_dev.services;

import entities.Campsite;

import java.io.Serializable;
import java.util.List;

public interface ICampsiteService extends Serializable {

    Campsite addCampsite(Campsite campsite);
    public List<Campsite> findAllCampsite();
    public Campsite updateCampsite(Campsite campsite);
    public Campsite findById(Long id);
    public void deleteCampsite(Long id);
}
