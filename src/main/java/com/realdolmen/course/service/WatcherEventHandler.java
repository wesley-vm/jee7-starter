package com.realdolmen.course.service;

import javax.enterprise.event.Observes;

import com.realdolmen.course.domain.ShitHappened;

public class WatcherEventHandler {

	public void detectShitHappening(@Observes @ShitHappened MessageSupplier messageSupplier){
		System.out.println("Shit happened!");
	}
}
