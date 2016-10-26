package com.realdolmen.course.domain;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;


public class TweetPersistenceTest extends JpaPersistenceTest {
	
	@Test
	public void tweet_CanBeRetrieved(){
		EntityManager em = entityManager();
				
		Tweet tweet = em.find(Tweet.class, 1000);
		Assert.assertEquals("John", tweet.getUser().getFirstName());
		Assert.assertEquals("Doe", tweet.getUser().getLastName());
		Assert.assertEquals("I see purple haze", tweet.getMessage());
	}

	@Test
	public void tweet_Entity_CanBePersisted(){
		EntityManager em = entityManager();
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		
		Tweet tweet = new Tweet(person, "PersistTest", tag);
		
		Assert.assertNull(tweet.getId());
		
		em.persist(person);
		em.persist(tag);
		em.persist(tweet);
		
		em.flush();
		em.clear();
		
		Assert.assertNotNull(tweet.getId());
	}
	
	@Test
	public void tweet_Date_CanBePersisted(){
		EntityManager em = entityManager();
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		
		Tweet tweet = new Tweet(person, "PersistTest", tag);
		tweet.setDate(new GregorianCalendar(2015,0,31));
		
		em.persist(person);
		em.persist(tag);
		em.persist(tweet);
		
		em.flush();
		em.clear();
		
		Tweet retrievedTweet = em.find(Tweet.class, tweet.getId());
		Assert.assertEquals(tweet.getDate(), retrievedTweet.getDate());
	}
	
	@Test
	public void tweet_Status_CanBePersisted(){
		EntityManager em = entityManager();
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		
		Tweet tweet = new Tweet(person, "PersistTest", tag);
		tweet.setStatus(Status.INACTIVE);
		
		em.persist(person);
		em.persist(tag);
		em.persist(tweet);
		
		em.flush();
		em.clear();
		
		Tweet retrievedTweet = em.find(Tweet.class, tweet.getId());
		Assert.assertEquals(Status.INACTIVE, retrievedTweet.getStatus());
	}
	
	@Test
	public void tweet_OneTag_CanBePersisted() throws Exception{
		EntityManager em = entityManager();
		Person person = new RegularPerson("Jimi", "Hendrix");
		Tag tag = new Tag("Jimi");
		
		Tweet tweet = new Tweet(person, "PersistTest", tag);
		Thread.sleep(1000);
		
		em.persist(person);
		em.persist(tag);
		em.persist(tweet);
		
		em.flush();
		em.clear();
		
		Tweet retrievedTweet = em.find(Tweet.class, tweet.getId());
		Assert.assertEquals(1, retrievedTweet.getTags().size());
		Assert.assertEquals(retrievedTweet.getMessage(), retrievedTweet.getMessage());
	}
	
	@Test
	public void tweet_MultipleTags_CanBePersisted(){
		EntityManager em = entityManager();
		
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
		
		Tweet tweet = new Tweet(person, "I can see purpe haze all along the watchtower", tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9, tag10, tag11);
		
		em.persist(person);
		em.persist(tag1);
		em.persist(tag2);
		em.persist(tag3);
		em.persist(tag4);
		em.persist(tag5);
		em.persist(tag6);
		em.persist(tag7);
		em.persist(tag8);
		em.persist(tag9);
		em.persist(tag10);
		em.persist(tag11);
		em.persist(tweet);
		
		em.flush();
		em.clear();
		
		Tweet retrievedTweet = em.find(Tweet.class, tweet.getId());
		Assert.assertEquals(11, retrievedTweet.getTags().size());
		Assert.assertEquals(retrievedTweet.getMessage(), retrievedTweet.getMessage());
	}
}
