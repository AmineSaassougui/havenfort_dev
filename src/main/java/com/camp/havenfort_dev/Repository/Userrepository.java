package com.camp.havenfort_dev.Repository;

import com.camp.havenfort_dev.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Userrepository  extends CrudRepository<User,Long> {

    User findByUserName(String username);

    List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String firstName, String lastName, String email);

}
