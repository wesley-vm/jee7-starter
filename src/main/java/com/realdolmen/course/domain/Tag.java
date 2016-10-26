package com.realdolmen.course.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Tag {


	public static final String FIND_BY_FIRST_NAME_FIRST_CHARACTER = "Tag.findByFirstNameFirstCharacter";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(mappedBy = "tags")
	private List<Tweet> tweets;
	
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}



	/*
	 * Used by JPA.
	 */
	protected Tag() {
	}


	public Tag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "#" + name;
	}
	
	
}
