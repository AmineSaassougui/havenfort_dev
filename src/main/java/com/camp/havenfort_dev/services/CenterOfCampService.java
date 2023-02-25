package com.camp.havenfort_dev.services;


public class CenterOfCampService {

import com.camp.havenfort_dev.entities.CenterOfCamp;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camp.havenfort_dev.repositories.CenterOfCampRepo;

import java.util.List;
@Service
public class CenterOfCampService implements ICenterOfCampService{
    @Autowired
    CenterOfCampRepo centerOfCampRepo;
    @Autowired
    EventRepo eventRepo;
    @Override
    public CenterOfCamp addCenterOfCamp(CenterOfCamp centerOfCamp) {
        return centerOfCampRepo.save(centerOfCamp);
    }

    @Override
    public List<CenterOfCamp> findAllCenterOfCamp() {
        return centerOfCampRepo.findAll();
    }

    @Override
    public CenterOfCamp updateCenterOfCamp(CenterOfCamp centerOfCamp) {
        return centerOfCampRepo.save(centerOfCamp);

    }

    @Override
    public CenterOfCamp findById(Long id) {
        return centerOfCampRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public void deleteCenterOfCamp(Long id) {
        centerOfCampRepo.deleteById(id);

    }

    @Override
    public void addCenterOfCampToEvent(CenterOfCamp centerOfCamp, Long idEvent) {
        Event event = eventRepo.findById(idEvent).orElse(null);
        event.setCenterOfCamp(centerOfCamp);
        centerOfCampRepo.save(centerOfCamp);

    }


}
