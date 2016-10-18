package com.realdolmen.course.domain;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Tweet {

	@Past(message="{validationConstraint.date.future}")
	private Calendar date;
	@NotNull(message="Username should be filled in!")
	@Size(message="Username should be made up of atleast 2 characters!", min = 2)
	private String username;
	@Size(message="Message should not be more than 140 characters!", max = 140)
	private String message;
	@Size(message="Atleast 1 tag is required!", min = 1, groups = Tags.class)
	private Set<String> tags;
	
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Tweet(String username, String message, String... tags) {
		this.date = Calendar.getInstance();
		this.username = username;
		this.message = message;
		
		this.tags = new TreeSet<>(Arrays.asList(tags));
	}
	
	
}
