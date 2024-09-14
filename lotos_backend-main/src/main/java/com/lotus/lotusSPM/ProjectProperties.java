package com.lotus.lotusSPM;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "projectapi")
public class ProjectProperties {

	private boolean displayStocks = false;

	public boolean isDisplayStocks() {
		return displayStocks;
	}

	public void setDisplayStocks(boolean displayStocks) {
		this.displayStocks = displayStocks;
	}
}
