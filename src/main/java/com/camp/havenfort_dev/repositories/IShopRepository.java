package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShopRepository extends JpaRepository<Shop, Long> {
    @Query("select sh from Shop sh where sh.nameshop like %:keyword% or sh.shopdescription like %:keyword% or sh.address like %:keyword%")
    List<Shop> findShopsBykeyword(@Param("keyword") String keyword);


}
