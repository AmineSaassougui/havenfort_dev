package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Delivrey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepo extends CrudRepository<Delivrey,Long> {
    @Query("SELECT p FROM Delivrey p WHERE CONCAT(p.idLiv, ' ',p.DateLivr, ' ', p.status) LIKE %?1%")
    public List<Delivrey> search(String keyword);
}
