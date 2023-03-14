package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.Repositories.CenterOfCampRepo;
import com.camp.havenfort_dev.Repositories.EventRepo;
import com.camp.havenfort_dev.entities.CenterOfCamp;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public CenterOfCamp updateCenterOfCamp(CenterOfCamp centerOfCamp) {
        return centerOfCampRepo.save(centerOfCamp);

    }

    @Override
    public void deleteCenterOfCamp(Long id) {
        centerOfCampRepo.deleteById(id);

    }




}
