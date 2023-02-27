package com.camp.havenfort_dev.services.imp;

import com.camp.havenfort_dev.Repositories.Userrepository;
import com.camp.havenfort_dev.entities.Role;
import com.camp.havenfort_dev.entities.User;
import com.camp.havenfort_dev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private Userrepository userRepository ;

    @Override
    public void addAdmin(User user) {
        user.setRole(Role.admin);
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public void addUser(User user) {

        user.setRole(Role.user);
        user.setEnabled(false);
        userRepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return  userRepository.findById(id).get();
    }

    @Override
    public String DeleteAccount(long id) {
        userRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public User UpdateUser(User user) {
        userRepository.save(user);
        return user;
    }
}
