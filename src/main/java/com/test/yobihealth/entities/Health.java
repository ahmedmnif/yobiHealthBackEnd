package com.test.yobihealth.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Health {

	@Id
	private String id ;
	
	private float glucose;
	
	private float ceratinine;
	
	private float crp;
	
	private String bloodPressure;
	
	private float heartBeat;
	
	private float nbrOfSteps;
	
	private float sleepDuration;
	
	private float timeUpAndGo;
	
	
	
	@DBRef
	private AppUser user ;
	
	
	
	
	

	public Health() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Health(float glucose, float ceratinine, float crp, String bloodPressure, float heartBeat, float nbrOfSteps,
			float sleepDuration, float timeUpAndGo, AppUser user) {
		super();
		this.glucose = glucose;
		this.ceratinine = ceratinine;
		this.crp = crp;
		this.bloodPressure = bloodPressure;
		this.heartBeat = heartBeat;
		this.nbrOfSteps = nbrOfSteps;
		this.sleepDuration = sleepDuration;
		this.timeUpAndGo = timeUpAndGo;
		this.user = user;
	}












	public Health(String id, float glucose, float ceratinine, float crp, String bloodPressure, float heartBeat,
			float nbrOfSteps, float sleepDuration, float timeUpAndGo, AppUser user) {
		super();
		this.id = id;
		this.glucose = glucose;
		this.ceratinine = ceratinine;
		this.crp = crp;
		this.bloodPressure = bloodPressure;
		this.heartBeat = heartBeat;
		this.nbrOfSteps = nbrOfSteps;
		this.sleepDuration = sleepDuration;
		this.timeUpAndGo = timeUpAndGo;
		this.user = user;
	}


	









	public AppUser getUser() {
		return user;
	}




	













	public void setUser(AppUser user) {
		this.user = user;
	}






	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getGlucose() {
		return glucose;
	}

	public void setGlucose(float glucose) {
		this.glucose = glucose;
	}

	public float getCeratinine() {
		return ceratinine;
	}

	public void setCeratinine(float ceratinine) {
		this.ceratinine = ceratinine;
	}

	public float getCrp() {
		return crp;
	}

	public void setCrp(float crp) {
		this.crp = crp;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public float getHeartBeat() {
		return heartBeat;
	}

	public void setHeartBeat(float heartBeat) {
		this.heartBeat = heartBeat;
	}

	public float getNbrOfSteps() {
		return nbrOfSteps;
	}

	public void setNbrOfSteps(float nbrOfSteps) {
		this.nbrOfSteps = nbrOfSteps;
	}

	public float getSleepDuration() {
		return sleepDuration;
	}

	public void setSleepDuration(float sleepDuration) {
		this.sleepDuration = sleepDuration;
	}

	public float getTimeUpAndGo() {
		return timeUpAndGo;
	}

	public void setTimeUpAndGo(float timeUpAndGo) {
		this.timeUpAndGo = timeUpAndGo;
	}

	@Override
	public String toString() {
		return "Health [id=" + id + ", glucose=" + glucose + ", ceratinine=" + ceratinine + ", crp=" + crp
				+ ", bloodPressure=" + bloodPressure + ", heartBeat=" + heartBeat + ", nbrOfSteps=" + nbrOfSteps
				+ ", sleepDuration=" + sleepDuration + ", timeUpAndGo=" + timeUpAndGo + "]";
	}
	
	
	
	
	
	
	
	
	
}
