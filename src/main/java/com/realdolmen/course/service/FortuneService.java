package com.realdolmen.course.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.realdolmen.course.domain.Prude;

@Named("myFortuneService")
public class FortuneService {

	@Inject
	@Prude
	private MessageSupplier messageSupplier;
	
	
	public String fortune(){
		// Play that funky music white boy
		return messageSupplier.supplyRandomMessage();
	}
}
