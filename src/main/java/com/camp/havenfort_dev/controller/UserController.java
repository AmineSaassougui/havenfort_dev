package com.camp.havenfort_dev.controller;


import java.util.List;
import java.util.UUID;

import com.camp.havenfort_dev.Repository.PasswordResetTokenRepository;
import com.camp.havenfort_dev.entity.PasswordResetToken;
import com.camp.havenfort_dev.entity.User;
import com.camp.havenfort_dev.service.UserService;
import com.camp.havenfort_dev.service.imp.MailSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService ;
	@Autowired
	private MailSendService mailSendService ;
	@Autowired 
	private PasswordResetTokenRepository passwordResetTokenRepository ;
	
/*	
{
        
        "firstName": "mohamed",
        "lastName": "Louhichi",
        "email": "meleklouhichi1998@gmail.com",
        "userName": "meleklouhichi98",
        "password": "93357422",
        "image": "hhh.img",
        "enabled": true,
        "role": "Admin"
    }
    http://localhost:3000/user/registerAdmin
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
	    http://localhost:3000/user/registerParent
	  
	*/
	
	@PostMapping("/registerParent")
	public String RegisterParent(@RequestBody User user) {
		userService.addParent(user);
		return "RegistrationDone! ";
	}
	
	//4af2cc68-b835-45c1-98e5-0c8f907a669e
	//http://localhost:3000/user/Verif/4af2cc68-b835-45c1-98e5-0c8f907a669e
	@GetMapping("/Verif/{token}")
	public String VerifAccount(@PathVariable String token) {
		userService.verifyAccount(token);
		return "Account Confirmed"; 
	}
	
	
	//http://localhost:3000/user/all
	@GetMapping("/all")
	public List<User> show() {
		logger.info("Démarrage des services OK .....");
		List<User> users = userService.getAllUsers() ; 
		return users ; 
	}
	//*http://localhost:3000/user/Delete
		/*{
	        "id": 5,
	        "userName": "55"

	        
	    }*/
	@DeleteMapping("/Delete")
	public String DeleteUser(@RequestBody User user) {
		long userid =  userService.getUserId(user) ; 
		return userService.DeleteAccount(userid) ; 
	}
	/*{
        "id": 4,
        "firstName": "Aziz",
        "lastName": "Louhichi",
        "email": "Azizlouhichi@gmail.com",
        "userName": "aziz",
        "password": "54875458",
        "image": "hhh.img",
        "enabled": true,
        "role": "Parent"
    }
    http://localhost:3000/user/modifyuser
    */
	@PutMapping("/modifyuser")
	@ResponseBody 
	 public User modifyUser(@RequestBody User user) { 
		 return userService.UpdateUser(user);
	 }
	

	@PostMapping("/resetPassword/{id}")
	public String resetPassword( @PathVariable("id") long id) {
	    User user = userService.findById(id);
	    
	    String token = UUID.randomUUID().toString();
	    
	    PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(token);
        passwordResetToken.setUser(user);
        passwordResetTokenRepository.save(passwordResetToken);
		mailSendService.sendEmail(user.getEmail(),"Please Click On The Link Bellow To change your password : http://localhost:3000/user/changePassword/ "+token,"Please Confirm Your Account");
	    return " mail sended .ok " ;
	}
	
	@PutMapping("/changePassword/{token}/{Newpassword}")
	public String changepass(@PathVariable("token") String token,@PathVariable("Newpassword") String Newpassword) {
		PasswordResetToken t = passwordResetTokenRepository.findByToken(token);
		User user = t.getUser();
		userService.changeUserPassword(user,Newpassword);
		return "true";
		
			
	}

	
 		@GetMapping("/search/{keyword}")
	  //@PreAuthorize("hasRole('Admin')")
	    public ResponseEntity<List<User>> getAllUsersByWord(@PathVariable("keyword") String keyword) {
		    final List<User> users = userService.findByFirstNameLikeOrLastNameLikeOrEmailLike(keyword);
		    return ResponseEntity.ok(users);
	    }

}
