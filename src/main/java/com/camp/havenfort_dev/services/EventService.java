package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.Repositories.ActivityRepo;
import com.camp.havenfort_dev.Repositories.CenterOfCampRepo;
import com.camp.havenfort_dev.Repositories.EventRepo;
import com.camp.havenfort_dev.Repositories.ReservationRepo;
import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.CenterOfCamp;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.entities.Reservation;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService{
   @Autowired
   ActivityRepo activityRepo;
   @Autowired
   CenterOfCampRepo centerOfCampRepo;
   @Autowired
   EventRepo eventRepo;
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
    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);

    }
  //  @Override
   // public List<Event> getEventByCampsite(Long idCampsite) {
   //     return eventRepo.getEventByCampsite(idCampsite);
   // }

    @Override
    public List<Event> getEventByCenterOfCamp(Long idCenterOfCamp) {
        return eventRepo.getEventByCenterOfCamp(idCenterOfCamp);
    }

    @Override
    public Event assignEventToCenterOfCamp(Event event, String nomC, String lieuC) {
        CenterOfCamp centerOfCamp = centerOfCampRepo.getCenterOfCampByNomAndLieu(nomC,lieuC);
        if (eventRepo.countByActiveIsFalseAndCenterOfCamp(centerOfCamp)<2){
            event.setCenterOfCamp(centerOfCamp);
            eventRepo.save(event);
        }

        return event;
    }

}
