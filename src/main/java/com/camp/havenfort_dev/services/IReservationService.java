package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.Reservation;




import java.io.Serializable;
import java.util.List;

public interface IReservationService extends Serializable {

    Reservation addReservation(Reservation r);
    List<Reservation> findAllReservation();
    Reservation updateReservation(Reservation r);
    Reservation findReservationById(Long id);
    void deleteReservation(Long id);
    List<Reservation> getReservationByEvent(Long idEvent);
    int getNbrReservationEvent(Long idEvent);
}
