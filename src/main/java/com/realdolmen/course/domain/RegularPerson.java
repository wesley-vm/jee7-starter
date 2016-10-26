package com.realdolmen.course.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("RP")
public class RegularPerson extends Person {
	
	@OneToOne
    @JoinColumn(name="profile_id")
    private Profile profile;

	public Profile getProfile() {
		return profile;
	}
	
	
	public RegularPerson(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public RegularPerson(String firstName, String lastName, Profile profile) {
		super(firstName, lastName);
		this.profile = profile;
	}


	public RegularPerson() {
		super();
	}
}
