package com.realdolmen.course.service.jms;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import com.realdolmen.course.repository.MessageRepository;

public class FortuneService {

	@Inject
	private MessageRepository mr;
	
	private Random random = new Random();
	
	public String fortune() {
		List<String> messages = mr.readAll();
		return messages.get(random.nextInt(messages.size()));
	}
}
