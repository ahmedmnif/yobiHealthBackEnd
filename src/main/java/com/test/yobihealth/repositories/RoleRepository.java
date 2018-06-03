package com.test.yobihealth.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.yobihealth.entities.AppRole;



public interface RoleRepository extends MongoRepository<AppRole,String>{
	
	public AppRole findByRoleName(String roleName) ;

}
