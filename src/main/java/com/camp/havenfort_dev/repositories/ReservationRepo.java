package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {
}
