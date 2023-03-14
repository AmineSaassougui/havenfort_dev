package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface invoiceRepo extends CrudRepository<invoice,Long> {
    @Query("SELECT p FROM invoice p WHERE CONCAT(p.idFacture, ' ',p.total, ' ', p.date_purchase, ' ', p.discout) LIKE %?1%")
    public List<invoice> search(String keyword);
}
