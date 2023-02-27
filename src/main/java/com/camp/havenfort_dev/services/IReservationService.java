package com.camp.havenfort_dev.services;

import entities.Reservation;

import java.io.Serializable;
import java.util.List;

public interface IReservationService extends Serializable {

    Reservation addReservation(Reservation r);
    public List<Reservation> findAllReservation();
    public Reservation updateReservation(Reservation r);
    public Reservation findReservationById(Long id);
    public void deleteReservation(Long id);
}
