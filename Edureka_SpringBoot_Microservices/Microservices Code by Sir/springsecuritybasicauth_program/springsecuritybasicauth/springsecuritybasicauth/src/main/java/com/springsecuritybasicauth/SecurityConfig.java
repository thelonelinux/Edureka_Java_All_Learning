package com.springsecuritybasicauth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//migrating security configuration towards component-based approach
@Configuration
@EnableWebSecurity
//this annotation enables spring security flow

public class SecurityConfig  {

	@Autowired
	private DataSource securityDataSource;

	/*SecurityFilterChain is a Spring Security concept that represents a 
	 * collection of security filters that are applied to an HTTP request in a 
	 * particular order. It's responsible for handling authentication and 
	 * authorization for incoming requests.
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests()
		.antMatchers("/admin")
		.hasAnyRole("ADMIN")
		.antMatchers("/orders")
		.hasAnyRole("ADMIN","USER","MANAGER")
		.and()
		.httpBasic()
		.and()
		.csrf()
		.disable();
		http.authenticationProvider(authenticationProvider());
		return http.build();
	}

	//UserDetailsService is a core interface in Spring Security 
	//that is used to retrieve user details from database.
	@Bean
	public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
		userDetailsManager.setDataSource(securityDataSource);
		return userDetailsManager;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A);
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		//this will encode the user entered password during login
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}



}
