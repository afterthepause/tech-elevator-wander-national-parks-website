package com.techelevator.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	
	
	public Long surveyId;
	public String parkCode;
	
	@NotBlank(message="Email Required")
	@Email(message="Must be a valid email address")
	public String email;
	
	@NotBlank(message="State Required")
	public String state;
	
	@NotBlank(message="Activity Level Required")
	public String activityLevel;
	
	
	
	
	public Long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	
	

}
