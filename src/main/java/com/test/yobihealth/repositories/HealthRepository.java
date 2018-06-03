package com.test.yobihealth.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.yobihealth.entities.Health;

public interface HealthRepository extends MongoRepository<Health,String>{
	
	
	public Health findOneByBloodPressure(String bloodPressure);
	public Health findOneByCrpAndHeartBeat(String crp,String heartBeat);
	
	public List<Health> getAllByUser(String id);


}
