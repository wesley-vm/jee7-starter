package com.realdolmen.course.service;

import java.util.List;
import java.util.Random;

import com.realdolmen.course.domain.ShitHappened;

@ShitHappened
public interface MessageSupplier {

	List<String> getMessages();
	
	public default String supplyRandomMessage() {
		Random random = new Random();
		int index = random.nextInt(getMessages().size());
		
		return getMessages().get(index);
	}
}
