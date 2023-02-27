package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface invoiceRepo extends CrudRepository<invoice,Long> {
}
