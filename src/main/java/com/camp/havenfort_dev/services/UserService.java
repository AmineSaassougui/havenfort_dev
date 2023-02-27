package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.User;

import java.util.List;

public interface UserService {

     void addAdmin(User user);
     void addUser(User user);
     List<User> getAllUsers();
     User findById(long id) ;
     String DeleteAccount(long id) ;
     User UpdateUser(User user);


}
