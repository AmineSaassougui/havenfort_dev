package services;

import entities.Campsite;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CampsiteRepo;

import java.util.List;

public class CampsiteService implements ICampsiteService{
    @Autowired
    CampsiteRepo campsiteRepo;
    @Override
    public Campsite addCampsite(Campsite campsite) {
        return null;
    }

    @Override
    public List<Campsite> findAllCampsite() {
        return null;
    }

    @Override
    public Campsite updateCampsite(Campsite campsite) {
        return null;
    }

    @Override
    public Campsite findById(Long id) {
        return null;
    }

    @Override
    public void deleteCampsite(Long id) {

    }
}
