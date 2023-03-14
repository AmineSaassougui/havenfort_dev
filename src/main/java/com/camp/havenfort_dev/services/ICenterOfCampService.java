package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.CenterOfCamp;

import java.io.Serializable;
import java.util.List;

public interface ICenterOfCampService extends Serializable {

    CenterOfCamp addCenterOfCamp(CenterOfCamp centerOfCamp);

    CenterOfCamp updateCenterOfCamp(CenterOfCamp centerOfCamp);

    void deleteCenterOfCamp(Long id);

}
