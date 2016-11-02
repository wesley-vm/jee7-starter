package com.realdolmen;

import static org.junit.Assert.assertNotNull;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import com.realdolmen.course.service.PersonServiceBean;

public class Demo {
	@Test
	public void testWeldWorks() {		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		PersonServiceBean psb = container.instance().select(PersonServiceBean.class).get();
		System.out.println(psb);
		assertNotNull(psb);
	}
}