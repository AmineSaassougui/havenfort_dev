package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.Reservation;



import entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ReservationRepo;

import java.util.List;
@Service
public class ReservationService implements IReservationService{
    @Autowired
    ReservationRepo reservationRepo;

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public List<Reservation> findAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public Reservation findReservationById(Long id) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }
}
