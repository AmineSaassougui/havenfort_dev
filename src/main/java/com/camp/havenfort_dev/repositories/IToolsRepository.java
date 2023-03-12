package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IToolsRepository extends JpaRepository<Tools, Long> {



}
