package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepository extends JpaRepository<Shop, Long> {
}
