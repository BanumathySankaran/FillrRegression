package com.mop.qa.pageobject;

import com.mop.qa.test.testBase1.*;
import io.appium.java_client.AppiumDriver;

public class FFA_Initialize_Native_App extends PageBase {
	
	
	
	public FFA_Initialize_Native_App(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}

	/*
	 * ************************ Elements XPath Values
	 */

	String gettingstartedXpath = "//*[@text='GETTING STARTED']";
	String congratsAndroid = "//*[@id='live_pass_congratulations']";
	String continueBtn = "//*[@text='CONTINUE']";
	String skipForNow = "//*[@text='SKIP FOR NOW']";
	String ageVerify = "//*[@text='ARE YOU OVER 18?']";
	String over18Btn = "//*[@text='YES, I AM OVER 18']";
	String favLeague = null;
	String mayBeLtrBtn = "//*[@text='MAYBE LATER']";
	String livePass = "//*[@text='NO THANKS']";
	String skipForCreateAcc = "//*[@text='Skip']";
	String livePassScreen = null;

	

	/* ******************************************************************** */
	/* Methods to handle the initial set up for AFL Application */
	/* ******************************************************************** */
	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {
			favLeague = "(//*[@text])[12]";
			livePassScreen = "//*[@text='fullLockup']";
	
		} 
		
		else if (platform_Name.equalsIgnoreCase("Android")) {
			livePassScreen = "//*[@id='live_pass_logo']";
			favLeague = "(//*[@id='favourite_image'])[4]";

		}
	}

	public void initializeSetup() throws Exception

	{
		System.out.println("In Initialize set Up.....");
		this.softWait(50);
		if (platform_Name.equalsIgnoreCase("iOS")) {
			if (this.isElementDisplayed(5, gettingstartedXpath, "Getting Started")) {
				this.assertTrue(isElementDisplayed(3, skipForNow, "skip For Now"), "Skip For Now is Displayed");
			}
		} 
		
		else if (platform_Name.equalsIgnoreCase("Android")) {
			if (this.isElementDisplayed(4, congratsAndroid, "continue")) {
				this.scrollDownOrUpForNTimes(2, 700, "Down");
				this.clickWithoutWait(continueBtn, "Continue");
			}
		}
		if (this.isElementDisplayed(5, gettingstartedXpath, "Getting Started")) {
		this.assertTrue(isElementDisplayed(3, gettingstartedXpath, "Getting Started"), "Getting Started is Displayed");
		this.clickWithoutWait(favLeague, "Favourite Team");
		this.clickWithoutWait(continueBtn, "Continue");
		this.assertTrue(isElementDisplayed(3, ageVerify, "Age Verification Screen"),
				"Age Verification Screen is Displayed");
		this.clickWithoutWait(over18Btn, "Over 18");
		this.clickWithoutWait(mayBeLtrBtn, "May Be Later");
		if (platform_Name.equalsIgnoreCase("iOS")) {
			this.clickWithoutWait(livePass, "No Thanks");
		}
		this.clickWithoutWait(skipForCreateAcc, "Skip");
	}
		if (isElementDisplayed(4, livePassScreen, "verifying live pass screen")) {
			if (platform_Name.equalsIgnoreCase("Android")) {
			this.scrollDownOrUpWithIfNew(livePassScreen, 700, "Down");
			this.scrollDownOrUpForNTimes(1, 400, "Down");
		}
			this.clickWithoutWait(livePass, "click on No Thanks Button");
		}
	}

}
