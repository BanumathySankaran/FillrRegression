package com.mop.qa.pageobject;

import com.mop.qa.test.testBase1.PageBase;

import io.appium.java_client.AppiumDriver;

public class kmartCheckoutPage extends PageBase{
	
	public kmartCheckoutPage(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}

	String firstName = null;
	
	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {

	
		} 
		
		else if (platform_Name.equalsIgnoreCase("Android")) {

			firstName = "//*[@id='first-name']";
			
		}
	}
}
