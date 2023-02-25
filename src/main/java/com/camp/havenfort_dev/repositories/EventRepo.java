package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepo extends JpaRepository<Event,Long> {
    @Query("SELECT DISTINCT eve FROM Event eve join eve.campsite")
    List<Event> getEventByCampsite(@Param("idCampsite") Long idCampsite);

    @Query("SELECT DISTINCT e FROM Event e join e.centerOfCamp")
    List<Event> getEventByCenterOfCamp(@Param("idCenterOfCamp") Long idCenterOfCamp);
}
