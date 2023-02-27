package com.camp.havenfort_dev.Repositories;

import com.camp.havenfort_dev.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository  extends CrudRepository<User,Long> {
}
