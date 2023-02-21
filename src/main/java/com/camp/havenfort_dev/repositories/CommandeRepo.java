package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.CommandLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepo extends CrudRepository<CommandLine,Long> {
}
