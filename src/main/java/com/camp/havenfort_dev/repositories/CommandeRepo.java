package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.CommandLine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepo extends CrudRepository<CommandLine,Long> {
    @Query("SELECT p FROM CommandLine p WHERE CONCAT(p.idCommLine, ' ',p.tools.category.cname, ' ', p.tools.name, ' ', p.tools.conndition, ' ',p.tools.availability) LIKE %?1%")
    public List<CommandLine> search(String keyword);
}
