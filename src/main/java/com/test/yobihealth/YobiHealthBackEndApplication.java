package com.test.yobihealth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.test.yobihealth.entities.AppRole;
import com.test.yobihealth.entities.AppUser;
import com.test.yobihealth.entities.Health;
import com.test.yobihealth.repositories.HealthRepository;
import com.test.yobihealth.repositories.UserRepository;
import com.test.yobihealth.services.AccountService;
import com.test.yobihealth.services.HealthService;



@SpringBootApplication
public class YobiHealthBackEndApplication implements CommandLineRunner{


	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private HealthService healthService;
	
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private UserRepository  roleRepository;
	
	@Autowired
	private HealthRepository healthRepository;
	

	
	
	public static void main(String[] args) {
		SpringApplication.run(YobiHealthBackEndApplication.class, args);
	} 
	
	/*@Bean
	public BCryptPasswordEncoder getBCPE()
	{
		return new BCryptPasswordEncoder();
	}*/
	
	@Bean
	public PasswordEncoder delegatingPasswordEncoder() {
	    PasswordEncoder defaultEncoder = new StandardPasswordEncoder();
	    Map<String, PasswordEncoder> encoders = new HashMap<>();
	    encoders.put("bcrypt", new BCryptPasswordEncoder());
	    encoders.put("scrypt", new SCryptPasswordEncoder());
	 
	    DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder(
	      "bcrypt", encoders);
	    passworEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);
	 
	    return passworEncoder;
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		this.userRepository.deleteAll();
		this.roleRepository.deleteAll();
		this.healthRepository.deleteAll();
		
		AppRole admin = new AppRole("ADMIN");
		AppRole user = new AppRole("USER");
		
		accountService.saveRole(admin);
		accountService.saveRole(user);
		
		Collection<AppRole> roles = new ArrayList<>();
		
		roles.add(admin);
		roles.add(user);
		AppUser Admin = new AppUser("admin","aa",roles );
		
		accountService.saveUser(Admin);
		
		
		
		/*AppUser usere = new AppUser("user","aa",null );
		
		accountService.addRoleToUser("user", "USER");
		
		accountService.saveUser(usere);*/
		


		
		Health healthh = new Health(1,1,1,"fff",4,4,4,4,Admin);
			
		healthService.saveHealth(healthh);
		
		
		/*healthRepository.findAll().forEach(t->{
			
			System.out.println(t.getBloodPressure());
		});*/
		
		System.out.println(accountService.findUserByUsername("admin").toString() );
		
	}
	
}
