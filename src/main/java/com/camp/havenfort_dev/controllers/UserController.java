package com.camp.havenfort_dev.controllers;

import com.camp.havenfort_dev.entities.User;
import com.camp.havenfort_dev.services.imp.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    /*
{

        "firstName": "saber",
        "lastName": "berber",
        "email": "saber@gmail.com",
        "userName": "saber",
        "password": "123456789",
        "role": "Admin"
    }
    http://localhost:8089/user/registerAdmin
    */
    @PostMapping("/registerAdmin")
    public String RegisterAdmin(@RequestBody User user) {
        logger.info("Démarrage des services OK .....");
        userService.addAdmin(user);
        return "RegistrationDone! ";
    }


    	/*
	{

	        "firstName": "saber",
	        "lastName": "Louhichi",
	        "email": "saberlouhichi@gmail.com",
	        "userName": "saber",
	        "password": "93357422",
	        "image": "hhh.img",
	        "enabled": true,
	        "role": "Parent"
	    }
	    http://localhost:8089/user/registerUser

	*/

    @PostMapping("/registerUser")
    public String registerUser(@RequestBody User user) {
        userService.addUser(user);
        return "RegistrationDone! ";
    }

    //http://localhost:8089/user/all
    @GetMapping("/all")
    public List<User> show() {
        logger.info("Démarrage des services OK .....");

        return userService.getAllUsers();
    }


    //*http://localhost:8089/user/Delete
		/*{
	        "id": 5,


	    }*/
    @DeleteMapping("/Delete")
    public String DeleteUser(@RequestBody User user) {
        long userid = userService.findById(user.getId()).getId();
        return userService.DeleteAccount(userid);


    }


    /*{
    "id": 2,
    "firstName": "Aziz",
    "lastName": "low",
    "email": "low@gmail.com",
    "userName": "aziz",
    "password": "123456",
    "image": "hhh.img",
    "enabled": true,
    "role": "user"
}
http://localhost:8089/user/modifyuser
*/
    @PutMapping("/modifyuser")
    @ResponseBody
    public User modifyUser(@RequestBody User user) {
        return userService.UpdateUser(user);
    }


}
