package com.camp.havenfort_dev.Repositories;

import com.camp.havenfort_dev.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepo extends JpaRepository<Rating,Long> {

    @Query("select AVG(cr.note) from CenterOfCamp c inner join c.ratings cr where c.idCenterOfCamp= :id")
    float NbRating(Long id);
}
