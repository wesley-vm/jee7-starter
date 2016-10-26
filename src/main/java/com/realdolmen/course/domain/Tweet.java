package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name = Tweet.FIND_ALL, query="select t from Tweet t"),
			})
public class Tweet {

	public static final String FIND_ALL = "Tweet.findAll";
	public static final String FIND_BY_FULL_NAME = "Tweet.findByFullName";
	public static final String AVERAGE_TAGS_PER_TWEET = "Tweet.averageTagsPerTweet";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Past(message="{validationConstraint.date.future}")
	private Calendar date;
	
	@Valid
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Person user;
	@Size(message="Message should not be more than 140 characters!", max = 140)
	private String message;
	
	@ManyToMany
	@JoinTable(
			name = "tweet_tag",
			joinColumns = @JoinColumn(name = "tweet_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id"))
	@Size(message="Atleast 1 tag is required!", min = 1, groups = Tags.class)
	private List<Tag> tags;
	@Enumerated(EnumType.STRING)
	private Status status;
	

	public Integer getId() {
		return id;
	}
	
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setList(List<Tag> tags) {
		this.tags = tags;
	}
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Tweet() {
		this.date = Calendar.getInstance();
		this.status = Status.DRAFT;
	}
	
	public Tweet(Person user, String message, Tag... tags) {
		this.date = Calendar.getInstance();
		this.user = user;
		this.message = message;
		
		this.tags = new ArrayList<>(Arrays.asList(tags));
		this.status = Status.DRAFT;
	}	
}
