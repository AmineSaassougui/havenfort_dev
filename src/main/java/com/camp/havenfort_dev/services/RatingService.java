package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.Repositories.CenterOfCampRepo;
import com.camp.havenfort_dev.Repositories.RatingRepo;
import com.camp.havenfort_dev.Repositories.Userrepository;
import com.camp.havenfort_dev.entities.CenterOfCamp;
import com.camp.havenfort_dev.entities.Rating;
import com.camp.havenfort_dev.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RatingService implements IRatingService{

    @Autowired
    RatingRepo ratingRepo;
    @Autowired
    Userrepository userrepository;
    @Autowired
    CenterOfCampRepo centerOfCampRepo;


    @Override
    public Rating addAndassignRatingToCenterOfCampAndUser(Rating r, Long idCenter, Long idUse) {
        CenterOfCamp centerOfCamp = centerOfCampRepo.findById(idCenter).orElse(null);
        User user = userrepository.findById(idUse).orElse(null);
        r.setUser(user);
        r.setCenterOfCamp(centerOfCamp);
        ratingRepo.save(r);
         

        return r;
    }

    @Override
    public float RatingCalcul(Long id) {
        return ratingRepo.NbRating(id);
    }

    @Override
    public String findCenterOfCampWithHighestRating() {

        List<CenterOfCamp> centerOfCamps = centerOfCampRepo.findAll();
        float highestRating = 0;
        CenterOfCamp nbev = null;

        for (CenterOfCamp cent : centerOfCamps) {
            Set<Rating> ratings = cent.getRatings();
            if (ratings != null && !ratings.isEmpty()) {
                float totalRating = 0;
                for (Rating rating : ratings) {
                    totalRating += rating.getNote();
                }
                float moy = totalRating / ratings.size();
                if (moy > highestRating) {
                    highestRating = moy;
                    nbev = cent;
                }
            }
        }
        return "Le center of camp avec la note la plus élevée est  "+ nbev.getTypeCenter()+" avec une moyenne de "+ highestRating;


}


}

