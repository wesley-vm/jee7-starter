package com.realdolmen.course.repository;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;

import com.realdolmen.course.domain.Prude;

public class MessageListFactory {


	@Prude
	@Produces
	public List<String> createMessages(){
		return Arrays.asList(
				"Worst. Episode. Ever",
				"What is the air-speed velocity of an unladen swallow?",
				"With great power there must also come — great responsibility.",
				"Invention, my dear friends, is 93% perspiration, 6% electricity, 4% evaporation, and 2% butterscotch ripple.",
				"I find your lack of faith disturbing.");
	}
}
