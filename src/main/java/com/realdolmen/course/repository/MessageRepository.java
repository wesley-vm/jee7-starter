package com.realdolmen.course.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MessageRepository {

	//@Inject
	private List<String> messages;
	
	public List<String> readAll() {
		return new ArrayList<>(messages);
	}
}
