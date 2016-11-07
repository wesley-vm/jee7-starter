package com.realdolmen.course.repository;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;

public class MessagesFactory {

	//@Produces
	public List<String> niceMessages() {
		return Arrays.asList("Have a nice day.", "You will meet an interesting person today.",
				"Chuck Norris never sleeps, he just closes his eyes to think harder.");
	}
}
