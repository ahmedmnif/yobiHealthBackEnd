package com.test.yobihealth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.yobihealth.entities.Health;
import com.test.yobihealth.repositories.HealthRepository;


@Service
@Transactional
public class HealthServiceImpl implements HealthService {

	@Autowired
	HealthRepository healthRepository ;
	
	
	
	
	@Override
	public Health saveHealth(Health health) {
		
		return healthRepository.save(health);
	}


	@Override
	public Health updateHealth(Health health) {
		
		return healthRepository.save(health);
	}


	@Override
	public void deleteHealth(Health health) {
		
		healthRepository.delete(health);
		
	}



	@Override
	public List<Health> getAllByUser(String id) {
		
		return healthRepository.getAllByUser(id);
	}


	@Override
	public List<Health> getAll() {
		return healthRepository.findAll();
	}

}
