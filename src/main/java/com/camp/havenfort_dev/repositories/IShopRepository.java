package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepository extends CrudRepository<Shop, Long> {
}
