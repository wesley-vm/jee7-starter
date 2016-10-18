package com.realdolmen.course.domain;

import java.util.List;

import javax.inject.Inject;

import com.realdolmen.course.service.MessageSupplier;

@Prude
public class PrudeMessageSupplier implements MessageSupplier {
	@Inject
	@Prude
	private List<String> messages;

	@Override
	public List<String> getMessages() {
		// TODO Auto-generated method stub
		return messages;
	}
}
