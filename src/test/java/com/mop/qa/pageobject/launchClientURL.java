package com.mop.qa.pageobject;

import org.openqa.selenium.By;

import com.mop.qa.test.testBase1.*;
import io.appium.java_client.AppiumDriver;

public class launchClientURL extends PageBase {
	
	
	
	public launchClientURL(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}

	/*
	 * ************************ Elements XPath Values
	 */

	String urlSearchBar = null;
	String goKeyAndroid = "//*[@contentDescription='Go']";
	String openTabAndr = "//*[@id='arrow']";
 private static final String macysURL = "https://www.macys.com";
 String macysLogo = null;


	

	/* ******************************************************************** */
	/* Methods to handle the initial set up for AFL Application */
	/* ******************************************************************** */
	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {

	
		} 
		
		else if (platform_Name.equalsIgnoreCase("Android")) {
	
			urlSearchBar = "//*[@id='search']";
			macysLogo = "//*[@text='macys-logo']";
		}
	}

	public void searchAndTypeURL() throws Exception {
		//this.click(urlSearchBar, "click On searchBar");
		if(isElementDisplayed(5, openTabAndr, "any open tab"))
		appiumDriver.findElement(By.xpath(urlSearchBar)).sendKeys(macysURL);
		this.softWait(10);
		this.click(urlSearchBar, "click On searchBar");		
		this.click(goKeyAndroid, "click on go button Android Key Board");
		}
	
	public void checkIfMacysLogoVisible() throws Exception {
		this.softWait(10);
		this.assertTrue(isElementDisplayed(10, macysLogo, "MacysLogo"),"Macys logo is visible");
		this.softWait(10);
		System.out.println("Macys logo is visible");
		//appiumDriver.quit();
	}
	}
