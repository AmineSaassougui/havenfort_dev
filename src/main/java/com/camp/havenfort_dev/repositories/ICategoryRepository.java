package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Long> {
}
