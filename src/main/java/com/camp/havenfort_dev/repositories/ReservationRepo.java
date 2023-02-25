package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    @Query("SELECT DISTINCT res FROM Reservation res join res.event")
    List<Reservation> getReservationByEvent(@Param("idEvent") Long idEvent);
}
