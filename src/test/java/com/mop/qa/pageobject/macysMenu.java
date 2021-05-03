package com.mop.qa.pageobject;

import com.mop.qa.test.testBase1.PageBase;

import io.appium.java_client.AppiumDriver;

public class macysMenu extends PageBase {
	public macysMenu(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}
	String mainMenu = null;
	String macysLogo = null;
	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {

	
		} 
		
		else if (platform_Name.equalsIgnoreCase("Android")) {
			mainMenu = "//*[@text='Main Navigation']";
			macysLogo = "//*[@text='macys-logo']";
			
		}
	}
	
	
	public void checkIfMacysLogoVisible() throws Exception {
		this.softWait(10);
		this.assertTrue(isElementDisplayed(10, macysLogo, "MacysLogo"),"Macys logo is visible");
		this.softWait(10);
		System.out.println("Macys logo is visible");
	}
	public void clickOnMacysMenu() {
		
	}
}
