
package com.camp.havenfort_dev.config;

import com.camp.havenfort_dev.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Autowired
    private UserDetailsService userDetailsService;
    @Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


	/*@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
				.authorizeRequests()
				 //.antMatchers("/home/*").permitAll()
				 //.antMatchers("/App/parentArea/*").hasRole("Parent")
				 //.antMatchers("/App/adminArea/*").hasRole("Admin")
				.antMatchers("/App/adminArea/*").hasRole("Admin")
				.antMatchers("/App/parentArea/*").hasAnyRole("Parent" , "Admin")
             	.antMatchers("/home/*").permitAll()				
						.anyRequest().authenticated().and().
						exceptionHandling();
		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}
*/	
@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/home/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/user/search")
                .permitAll()
                .antMatchers("/api/Publication/**").permitAll()
                .antMatchers(HttpMethod.GET, "/user")
                .permitAll()
                .antMatchers("/user/**").permitAll()
                .anyRequest()
                .authenticated();
       httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
