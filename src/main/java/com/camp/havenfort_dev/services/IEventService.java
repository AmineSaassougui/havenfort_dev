package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.Event;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface IEventService extends Serializable {

    Event addEvent(Event event);

    List<Event> findAllEvent();
    Event updateEvent(Event event);

    void deleteEvent(Long id);


   // List<Event> getEventByCampsite(Long idCampsite);
    List<Event> getEventByCenterOfCamp(Long idCenterOfCamp);
    Event assignEventToCenterOfCamp(Event event, String nomC, String lieuC);




}
