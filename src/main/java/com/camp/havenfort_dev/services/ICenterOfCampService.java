package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.CenterOfCamp;



import com.camp.havenfort_dev.entities.Campsite;



import java.io.Serializable;
import java.util.List;

public interface ICenterOfCampService extends Serializable {

    CenterOfCamp addCenterOfCamp(CenterOfCamp centerOfCamp);
    List<CenterOfCamp> findAllCenterOfCamp();
    CenterOfCamp updateCenterOfCamp(CenterOfCamp centerOfCamp);
    CenterOfCamp findById(Long id);
    void deleteCenterOfCamp(Long id);
    void addCenterOfCampToEvent(CenterOfCamp centerOfCamp, Long idEvent);
}
