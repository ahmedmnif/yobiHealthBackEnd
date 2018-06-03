package com.test.yobihealth.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class AppRole {

    @Id
	private String id;
	private String roleName;
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AppRole(String roleName) {
		super();
		this.roleName = roleName;
	}



	public AppRole(String id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "AppRole [id=" + id + ", roleName=" + roleName + "]";
	}

	
}
