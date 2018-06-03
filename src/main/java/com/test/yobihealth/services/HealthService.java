package com.test.yobihealth.services;


import java.util.List;

import com.test.yobihealth.entities.Health;

public interface HealthService {

	
	public List<Health> getAll();
	
	
	public Health saveHealth(Health health);
	
	public Health updateHealth(Health health);
	
	public List<Health> getAllByUser(String id);
	
	public void deleteHealth(Health health);
	
}
