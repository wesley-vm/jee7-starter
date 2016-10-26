package com.realdolmen.course.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Profile {
	
	@Id @GeneratedValue
	private Long id;
	
	private String ageCategory;
	
	private String interest;
	
	private String maritalState;
	
	
	

	public String getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getMaritalState() {
		return maritalState;
	}

	public void setMaritalState(String maritalState) {
		this.maritalState = maritalState;
	}

	public Long getId() {
		return id;
	}

	public Profile(Long id, String ageCategory, String interest, String maritalState) {
		this.id = id;
		this.ageCategory = ageCategory;
		this.interest = interest;
		this.maritalState = maritalState;
	}

	public Profile() {
	}
	
}
