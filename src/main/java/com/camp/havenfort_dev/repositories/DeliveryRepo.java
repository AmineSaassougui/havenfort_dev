package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Delivrey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends CrudRepository<Delivrey,Long> {
}
