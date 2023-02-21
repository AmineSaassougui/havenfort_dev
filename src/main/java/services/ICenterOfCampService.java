package services;

import entities.CenterOfCamp;

import java.io.Serializable;
import java.util.List;

public interface ICenterOfCampService extends Serializable {

    CenterOfCamp addCenterOfCamp(CenterOfCamp centerOfCamp);
    List<CenterOfCamp> findAllCenterOfCamp();
    CenterOfCamp updateCenterOfCamp(CenterOfCamp centerOfCamp);
    CenterOfCamp findById(Long id);
    void deleteCenterOfCamp(Long id);
}