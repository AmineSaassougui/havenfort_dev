package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IToolsRepository extends JpaRepository<Tools, Long> {
    @Query("SELECT t FROM Tools t WHERE t.name LIKE %:keyword% OR t.description LIKE %:keyword%  ")
    List<Tools> findByKeyword(@Param("keyword") String keyword);




}
