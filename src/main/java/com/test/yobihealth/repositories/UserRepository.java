package com.test.yobihealth.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.yobihealth.entities.AppUser;



public interface UserRepository extends MongoRepository<AppUser,String>{

	
	public AppUser findByUsername(String username) ;
}
