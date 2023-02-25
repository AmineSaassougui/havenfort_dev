package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.CenterOfCamp;
import com.camp.havenfort_dev.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepo extends JpaRepository<Event,Long> {
    @Query("SELECT DISTINCT eve FROM Event eve WHERE eve.campsite.idCampsite =:id")
    List<Event> getEventByCampsite(@Param("id") Long idCampsite);

    @Query("SELECT DISTINCT e FROM Event e WHERE e.centerOfCamp.idCenterOfCamp =:id")
    List<Event> getEventByCenterOfCamp(@Param("id") Long idCenterOfCamp);
    @Query("SELECT ev FROM Event ev WHERE ev.nomEvent = :nom and ev.typeEvent = :type")
    Event getEventByNomAndType(@Param("nom") String nomE,@Param("type") String typeE);

    Integer countByActiveIsFalseAndCenterOfCamp(CenterOfCamp centerOfCamp);
}
