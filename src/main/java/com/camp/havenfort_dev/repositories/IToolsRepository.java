package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Tools;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToolsRepository extends CrudRepository<Tools, Long> {
}
