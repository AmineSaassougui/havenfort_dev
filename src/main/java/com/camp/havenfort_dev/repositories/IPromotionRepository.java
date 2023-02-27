package com.camp.havenfort_dev.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromotionRepository extends CrudRepository<Promotion, Long> {
}
