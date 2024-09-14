package com.lotus.lotusSPM;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

	@Autowired
	private ProjectProperties properties;
	
	@PostConstruct
	public void init() {
		System.out.println("Display stocks:" + properties.isDisplayStocks());
	}
}
