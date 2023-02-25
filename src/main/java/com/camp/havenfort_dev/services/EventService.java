package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.entities.Reservation;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.ActivityRepo;
import com.camp.havenfort_dev.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camp.havenfort_dev.repositories.EventRepo;

import java.util.List;
@Service
public class EventService implements IEventService{
    @Autowired
    EventRepo eventRepo;
    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    ReservationRepo reservationRepo;
    @Override
    public Event addEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public List<Event> findAllEvent() {
        return eventRepo.findAll();
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);

    }

    @Override
    public void addEventToActivity(Event event, Long idActivity) {
        Activity activity = activityRepo.findById(idActivity).orElse(null);
        activity.setEvent(event);
        eventRepo.save(event);

    }

    @Override
    public void addEventToReservation(Event event, Long idReservation) {
        Reservation reservation = reservationRepo.findById(idReservation).orElse(null);
        reservation.setEvent(event);
        eventRepo.save(event);

    }

    @Override
    public List<Event> getEventByCampsite(Long idCampsite) {
        return eventRepo.getEventByCampsite(idCampsite);
    }

    @Override
    public List<Event> getEventByCenterOfCamp(Long idCenterOfCamp) {
        return eventRepo.getEventByCenterOfCamp(idCenterOfCamp);
    }


}
