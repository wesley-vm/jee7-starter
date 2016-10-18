package com.realdolmen.course.service;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FortuneServiceIntegrationTest {
	
	private WeldContainer weldContainer;

	@Before
	public void init(){
		Weld weld = new Weld();
		weldContainer = weld.initialize();
	}
	
	@After
	public void destroy(){
		weldContainer.shutdown();
	}

	@Test
	public void fortuneYieldsProfaneMessage() {
		FortuneService fs = weldContainer.instance().select(FortuneService.class).get();
		String message = fs.fortune();
		System.out.println(message);
		Assert.assertNotNull(message); //Reasonable proof
	}

}
