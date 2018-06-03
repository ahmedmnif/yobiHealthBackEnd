package com.test.yobihealth.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.yobihealth.entities.AppRole;
import com.test.yobihealth.entities.AppUser;
import com.test.yobihealth.repositories.RoleRepository;
import com.test.yobihealth.repositories.UserRepository;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private PasswordEncoder pa ;
	
	
	@Autowired
	UserRepository userRepository ;
	
	
	@Autowired
	RoleRepository roleRepository ;
	
	
	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = pa.encode(user.getPassword()); 
	 	user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);
		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
