package com.test.yobihealth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.yobihealth.entities.Health;
import com.test.yobihealth.repositories.HealthRepository;
import com.test.yobihealth.services.HealthServiceImpl;



@RestController
public class HealthRestController{

	@Autowired 
	private HealthRepository healthRepository ;
	
	@Autowired
	private HealthServiceImpl healthServiceImpl;
	
	
	@GetMapping("/healths")
	public List<Health> listHealths()
	{
		return healthServiceImpl.getAll();
	}
	
	@PostMapping("/health")
	public Health save(@RequestBody Health h)
	{
		return healthServiceImpl.saveHealth(h);
	}
	
	@GetMapping("/health")
	public List<Health> listHealthsByUser(@RequestBody String id)
	{
		return healthServiceImpl.getAllByUser(id);
	}
	
	
	
}
