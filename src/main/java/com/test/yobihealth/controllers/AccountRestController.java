package com.test.yobihealth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.yobihealth.entities.AppUser;
import com.test.yobihealth.services.AccountService;


@RestController
public class AccountRestController {

	
	@Autowired
	private AccountService accountService;
	
	 
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm)
	{
		if(!userForm.getPassword().equals(userForm.getPassword()))
		throw new RuntimeException("bad passs");
		
		AppUser user = accountService.findUserByUsername(userForm.getUsername());
		if(user != null) throw new RuntimeException("thsis usere exixsts");
		AppUser appUser = new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		return accountService.saveUser(appUser);	
	}
	
	@GetMapping("/user/{username}")
	public AppUser getUserById(@PathVariable String username)
	{
		return accountService.findUserByUsername(username);
	}
	
	
}
