package com.camp.havenfort_dev.repositories;

import entities.Campsite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampsiteRepo extends JpaRepository<Campsite,Long> {
}
