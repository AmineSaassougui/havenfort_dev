package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity,Long> {
    @Query("SELECT DISTINCT act FROM Activity act join act.event")
    List<Activity> getActivityByEvent(@Param("idEvent") Long idEvent);
}
