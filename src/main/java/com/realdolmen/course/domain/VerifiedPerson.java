package com.realdolmen.course.domain;

import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

@Entity
@DiscriminatorValue("VP")
public class VerifiedPerson extends Person {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past(message="{validationConstraint.date.future}")
	private Calendar verificationDate;
	
	private Integer verificationID;
	
	private String creditCard;

	public Calendar getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(Calendar verificationDate) {
		this.verificationDate = verificationDate;
	}

	public Integer getVerificationID() {
		return verificationID;
	}

	public void setVerificationID(Integer verificationID) {
		this.verificationID = verificationID;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}	
	
	public VerifiedPerson(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public VerifiedPerson(String firstName, String lastName, Calendar verificationDate, Integer verificationID, String creditCard) {
		super(firstName, lastName);
		this.verificationDate = verificationDate;
		this.verificationID = verificationID;
		this.creditCard = creditCard;
	}

	public VerifiedPerson() {
		super();
	}
	
}
