package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.entities.TypeCenAct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity,Long> {
    @Query("SELECT DISTINCT act FROM Activity act WHERE act.event.idEvent =:id")
    List<Activity> getActivityByEvent(@Param("id") Long idEvent);

    Integer countByArchiveIsFalseAndEvent(Event event);
    @Query("SELECT ac FROM Activity ac WHERE ac.typeActivity = :type")
    Activity getActivitiesByType(@Param("type") TypeCenAct typeActivity);
}
