package com.camp.havenfort_dev.service.imp;

import java.util.List;
import java.util.UUID;

import com.camp.havenfort_dev.Repository.PasswordResetTokenRepository;
import com.camp.havenfort_dev.Repository.Userrepository;
import com.camp.havenfort_dev.Repository.VerificationTokenrepository;
import com.camp.havenfort_dev.entity.Role;
import com.camp.havenfort_dev.entity.User;
import com.camp.havenfort_dev.entity.VerificationToken;
import com.camp.havenfort_dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private Userrepository userRepository ;
	@Autowired
	private VerificationTokenrepository verificationTokenRepository ;
	@Autowired
	private MailSendService mailSendService ; 
	//@Autowired
//	private UploadFileRepository uploadFileRepository ;
	
	private PasswordResetTokenRepository passwordResetTokenRepository ;
	
	@Override
	public void addAdmin(User user) {
		user.setPassword( new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole(Role.admin);
		user.setEnabled(true);
		userRepository.save(user); 
	}

	@Override
	public void addParent(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole(Role.user);
		user.setEnabled(false);
		userRepository.save(user); 
		
	    String token =generateVerificationToken(user); 
		mailSendService.sendEmail(user.getEmail(),"Please Click On The Link Bellow To Confirm : http://localhost:3000/user/Verif/"+token,"Please Confirm Your Account");
		
		
	}
	
	
	
	private String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
	}

	
	private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUserName();
        User user = userRepository.findByUserName(username);
        user.setEnabled(true);
        userRepository.save(user);
    }
	
	public void verifyAccount(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        fetchUserAndEnable(verificationToken);
    }
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users ; 
	}
	
	@Override 
	public User findById(long id) {
		User user = userRepository.findById(id).get();
		return user ;
	}
	@Override
	public long getUserId(User user) {
		long id=0 ; 
		List<User> users =  getAllUsers() ;
		for (User user1:users) {
			if (user.getUserName().equals(user1.getUserName())) {
				id=user1.getId() ; 
			}
			
		}
		return id; 
	}
	
/*	@Override
	public String Authentification (String userName , String password) {
		boolean test = false  ;
		Role pers = null ; 
		List<User> users =  getAllUsers() ;
		for(User user:users)
		{
			if (user.getUserName().equals(userName))
			{
				test = new BCryptPasswordEncoder().matches(password, user.getPassword()) ; 
				//test = password.equals(user.getPassword());
			 if (test == true ) { 
				 pers = user.getRole() ; 
				 break ;
				 } 
			 else return "Incorrect Password" ; 
			}
			else return "User Doen't Exist " ; 
		}
		
		
		return ("Welcome" + pers );    
	}
*/	
	@Override
	public String DeleteAccount(long id) {
		userRepository.deleteById(id);
		return "Deleted"; 
	}
	
	@Override
	public User UpdateUser(User user) {
	    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	
	
	@Override
	public void changeUserPassword(User user, String password) {
	    user.setPassword(new BCryptPasswordEncoder().encode(password));
	    userRepository.save(user);
	}
	
	/*@Override
	public List<User> listAll(String keyword){
	
		return userRepository.findByKeyword(keyword);
		
		
	}*/
	
	@Transactional(readOnly = true)
    public List<User> findByFirstNameLikeOrLastNameLikeOrEmailLike(String keyword) {
        return userRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, keyword);
    }

	

}
