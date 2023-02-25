package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Campsite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampsiteRepo extends JpaRepository<Campsite,Long> {
}
