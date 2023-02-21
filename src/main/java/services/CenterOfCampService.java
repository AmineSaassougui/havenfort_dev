package services;

import entities.CenterOfCamp;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CenterOfCampRepo;

import java.util.List;

public class CenterOfCampService implements ICenterOfCampService{
    @Autowired
    CenterOfCampRepo centerOfCampRepo;
    @Override
    public CenterOfCamp addCenterOfCamp(CenterOfCamp centerOfCamp) {
        return null;
    }

    @Override
    public List<CenterOfCamp> findAllCenterOfCamp() {
        return null;
    }

    @Override
    public CenterOfCamp updateCenterOfCamp(CenterOfCamp centerOfCamp) {
        return null;
    }

    @Override
    public CenterOfCamp findById(Long id) {
        return null;
    }

    @Override
    public void deleteCenterOfCamp(Long id) {

    }
}
