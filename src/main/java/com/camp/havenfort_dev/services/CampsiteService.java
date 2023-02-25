package com.camp.havenfort_dev.services;


public class CampsiteService {

import com.camp.havenfort_dev.entities.Campsite;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.CampsiteRepo;
import com.camp.havenfort_dev.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CampsiteService implements ICampsiteService{
    @Autowired
    CampsiteRepo campsiteRepo;
    @Autowired
    EventRepo eventRepo;
    @Override
    public Campsite addCampsite(Campsite campsite) {
        return campsiteRepo.save(campsite);
    }

    @Override
    public List<Campsite> findAllCampsite() {
        return campsiteRepo.findAll();
    }

    @Override
    public Campsite updateCampsite(Campsite campsite) {
        return campsiteRepo.save(campsite);
    }

    @Override
    public Campsite findById(Long id) {
        return campsiteRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public void deleteCampsite(Long id) {
        campsiteRepo.deleteById(id);

    }

    @Override
    public void addCampsiteToEvent(Campsite campsite, Long idEvent) {
        Event event = eventRepo.findById(idEvent).orElse(null);
        event.setCampsite(campsite);
        campsiteRepo.save(campsite);

    }

}
