package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromotionRepository extends JpaRepository<Promotion, Long> {
}
