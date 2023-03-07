package com.camp.havenfort_dev.controller;

import java.io.IOException;

import com.camp.havenfort_dev.filter.JwtProvider;
import com.camp.havenfort_dev.requests.LoginRequest;
import com.camp.havenfort_dev.requests.LoginResponse;
import com.camp.havenfort_dev.service.imp.UserDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/home")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager ;
	@Autowired
	private JwtProvider jwtProvider ;
	@Autowired
	private UserDetService userDetailsService ;
	

	@PostMapping("/Login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws AuthenticationException, IOException {

		// Perform the security
        Authentication authentication;
		//authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        System.out.println("firststep");
        
       
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            System.out.println("secondstep");

   
        

		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        //System.out.println("abababa"+userDetails.getUsername());
		final String jwt = jwtProvider.generateToken(userDetails);
		
		return ResponseEntity.ok(new LoginResponse(jwt));
	}
	
	
	
}
