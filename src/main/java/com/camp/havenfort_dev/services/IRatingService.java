package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Rating;

import java.io.Serializable;

public interface IRatingService extends Serializable {

    Rating addAndassignRatingToCenterOfCampAndUser(Rating r,Long idCenter ,Long idUse);

    float RatingCalcul(Long id);
    String findCenterOfCampWithHighestRating();


}
