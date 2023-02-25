package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.EventRepo;
import com.camp.havenfort_dev.repositories.ReservationRepo;
import com.camp.havenfort_dev.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService implements IReservationService{
    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    EventRepo eventRepo;
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

    @Override
    public List<Reservation> getReservationByEvent(Long idEvent) {
        return reservationRepo.getReservationByEvent(idEvent);
    }

    @Override
    public int getNbrReservationEvent(Long idEvent) {
        return 0;
    }
    ///@Override
    //	public int getNbrRendezVousMedecin(Long idMedecin) {
    //		Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
    //		return medecin.getMesRendezVous().size();
    //	}
}
