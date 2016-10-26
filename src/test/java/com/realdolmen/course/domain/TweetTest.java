package com.realdolmen.course.domain;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TweetTest {
	
	private ValidatorFactory factory;
	private Validator validator;
	
	@Before
	public void initValidatorInfrastructure() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@After
	public void destroyValidatorInfrastructure(){
		factory.close();
	}
	
	@Test
	public void createTweet_Date_PastDate() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag);
		
		t.setDate(new GregorianCalendar(2015,0,31));
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet_Date_CurrentDate() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet_Date_FutureDate() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag);
		
		t.setDate(new GregorianCalendar(2017,0,31));
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(1, violations.size());
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Date should be in the past!", error.getMessage());
		System.out.println(violations);
	}
	
	
	
	@Test
	public void createTweet__Username_IsNull() throws Exception{
		Person person = new RegularPerson(null, null);
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(2, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_IsEmptyString() throws Exception{
		Person person = new RegularPerson("", "");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(2, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_IsMandatory() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	
	@Test
	public void createTweet_Message_IsNull() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, null, tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Message_IsEmptyString() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "", tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_IsMaxChar() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et ma", tag);

		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_ExceedsMax() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et mag", tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Message should not be more than 140 characters!", error.getMessage());
		System.out.println(violations);
	}
	
	
	@Test
	public void createTweet_Tags_emptyTagList() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower");
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet_Tags_oneElementInTagList() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}

	@Test
	public void createTweet_Tags_multipleElementsInTagList() throws Exception{
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag1 = new Tag("Music");
		Tag tag2 = new Tag("Jimi");
		Tag tag3 = new Tag("Hendrix");
		Tag tag4 = new Tag("Classic");
		Tag tag5 = new Tag("Purple");
		Tag tag6 = new Tag("Watchtower");
		Tag tag7 = new Tag("Haze");
		Tag tag8 = new Tag("Rock");
		Tag tag9 = new Tag("Songwriter");
		Tag tag10 = new Tag("Guiter");
		Tag tag11 = new Tag("Legend");
		
		Tweet t = new Tweet(person, "I can see purpe haze all along the watchtower", tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9, tag10, tag11);
		
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
}
