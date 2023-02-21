package com.camp.havenfort_dev.Repository;

import com.camp.havenfort_dev.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository  extends CrudRepository<User,Long> {
}
