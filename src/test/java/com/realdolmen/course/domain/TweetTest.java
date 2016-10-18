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
		Tweet t = new Tweet("Jimi", "I can see purpe haze all along the watchtower", "#Jimi");
		t.setDate(new GregorianCalendar(2015,0,31));
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet_Date_CurrentDate() throws Exception{
		Tweet t = new Tweet("Jimi", "I can see purpe haze all along the watchtower", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet_Date_FutureDate() throws Exception{
		Tweet t = new Tweet("Jimi", "I can see purpe haze all along the watchtower", "#Jimi");
		t.setDate(new GregorianCalendar(2017,0,31));
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(1, violations.size());
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Date should be in the past!", error.getMessage());
		System.out.println(violations);
	}
	
	
	
	@Test
	public void createTweet__Username_IsNull() throws Exception{
		Tweet t = new Tweet(null, "I can see purpe haze all along the watchtower", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Username should be filled in!", error.getMessage());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_IsEmptyString() throws Exception{
		Tweet t = new Tweet("", "I can see purpe haze all along the watchtower", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Username should be made up of atleast 2 characters!", error.getMessage());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_IsOneChar() throws Exception{
		Tweet t = new Tweet("J", "I can see purpe haze all along the watchtower", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Username should be made up of atleast 2 characters!", error.getMessage());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_IsMandatory() throws Exception{
		Tweet t = new Tweet("Jimi", "I can see purpe haze all along the watchtower", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	
	@Test
	public void createTweet_Message_IsNull() throws Exception{
		Tweet t = new Tweet("Jimi", null, "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Message_IsEmptyString() throws Exception{
		Tweet t = new Tweet("Jimi", "", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_IsMaxChar() throws Exception{
		Tweet t = new Tweet("Jimi", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et ma", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet__Username_ExceedsMax() throws Exception{
		Tweet t = new Tweet("Jimi", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et mag", "#Jimi");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Message should not be more than 140 characters!", error.getMessage());
		System.out.println(violations);
	}
	
	
	@Test
	public void createTweet_Tags_emptyTagList() throws Exception{
		Tweet t = new Tweet("Jimi", "I can see purpe haze all along the watchtower");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
	
	@Test
	public void createTweet_Tags_oneElementInTagList() throws Exception{
		Tweet t = new Tweet("Jimi", "I can see purpe haze all along the watchtower", "#Music");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}

	@Test
	public void createTweet_Tags_multipleElementsInTagList() throws Exception{
		Tweet t = new Tweet("Jimi", "I can see purpe haze all along the watchtower", "#Music", "Jimi", "Hendrix", "Classic", "Purple", "Watchtower", "Haze", "Rock", "Singer", "Songwriter", "Guitar");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}
}
