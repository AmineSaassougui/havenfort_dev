package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepo extends CrudRepository<panier,Long> {
}
