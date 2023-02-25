package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.entities.Reservation;

import java.io.Serializable;
import java.util.List;

public interface IEventService extends Serializable {

    Event addEvent(Event event);

    List<Event> findAllEvent();
    Event updateEvent(Event event);
    Event findById(Long id);
    void deleteEvent(Long id);
    void addEventToActivity(Event event,Long idActivity);
    void addEventToReservation(Event event, Long idReservation);
    List<Event> getEventByCampsite(Long idCampsite);
    List<Event> getEventByCenterOfCamp(Long idCenterOfCamp);


}
