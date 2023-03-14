package com.camp.havenfort_dev.Repositories;

import com.camp.havenfort_dev.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {

}
