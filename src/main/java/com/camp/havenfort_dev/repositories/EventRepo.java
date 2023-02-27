package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Long> {
}
