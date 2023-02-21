package com.camp.havenfort_dev.service;

import com.camp.havenfort_dev.entity.User;

import java.util.List;

public interface UserService {

     void addAdmin(User user);
     void addUser(User user);
     List<User> getAllUsers();
     User findById(long id) ;
     String DeleteAccount(long id) ;
     User UpdateUser(User user);


}
