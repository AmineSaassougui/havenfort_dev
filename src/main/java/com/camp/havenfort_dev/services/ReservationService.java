package com.camp.havenfort_dev.services;







import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.ReservationRepo;
import com.camp.havenfort_dev.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return reservationRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }
}
