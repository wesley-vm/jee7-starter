package com.realdolmen.course.service;

import java.util.List;

import javax.inject.Inject;

import com.realdolmen.course.domain.Prude;

public class ConfigurableMessageSupplier implements MessageSupplier {
	
	private List<String> messages;
	
	@Inject
	public ConfigurableMessageSupplier(@Prude List<String> messages) {
		// TODO Auto-generated constructor stub
		this.messages = messages;
	}

	@Override
	public List<String> getMessages() {
		// TODO Auto-generated method stub
		return this.messages;
	}

}
