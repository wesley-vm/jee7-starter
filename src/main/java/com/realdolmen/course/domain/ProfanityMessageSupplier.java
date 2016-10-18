package com.realdolmen.course.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.realdolmen.course.service.MessageSupplier;

@Profane
public class ProfanityMessageSupplier implements MessageSupplier{
	
	private List<String> messages = Arrays.asList(
			"YOU JUST SPOILED FORCE AWAKENS! E CHU TA!",
			"It’s called a signal light, you spineless petaQ!",
			"How did you forget the towels, you zarking idiot!",
			"I can’t go to no fancy shindig; I ain’t got a gorram thing to wear.",
			"The Improbability Drive isn't working! Belgium!"
			);

	@Override
	public List<String> getMessages() {
		return messages;
	}
	
}
