package com.camp.havenfort_dev.service.imp;

import com.camp.havenfort_dev.Repository.Userrepository;
import com.camp.havenfort_dev.entity.User;
import com.camp.havenfort_dev.entity.UserDet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetService implements UserDetailsService {
	
	
	@Autowired
	private Userrepository userRepository;
		
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user = this.userRepository.findByUserName(userName);
		 UserDet userDet = new UserDet(user);

		 
		 return userDet ; 
	}
}
