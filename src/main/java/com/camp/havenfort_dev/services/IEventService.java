package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.entities.Reservation;

import java.io.Serializable;
import java.util.List;

public interface IEventService extends Serializable {

    Event addEvent(Event event);

    public List<Event> findAllEvent();
    public Event updateEvent(Event event);
    public Event findById(Long id);
    public void deleteEvent(Long id);
    void addEventToActivity(Event event,Long idActivity);
    void addEventToReservation(Event event, Long idReservation);

}
