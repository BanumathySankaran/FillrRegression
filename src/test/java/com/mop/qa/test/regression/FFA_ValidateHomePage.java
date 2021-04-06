package com.mop.qa.test.regression;

import org.testng.annotations.Test;
import com.mop.qa.pageobject.FFA_HomePage;
import com.mop.qa.pageobject.FFA_Initialize_Native_App;
import com.mop.qa.test.testBase1.TestBase;

public class FFA_ValidateHomePage extends TestBase {
	
	@Test
	public void FFA_ValidateHomePage_TestCase() throws Exception {
		System.out.println("TestCase Title : Validate FFA Home Page : Started .....");
		FFA_Initialize_Native_App initApplication  = new FFA_Initialize_Native_App(appiumDriver);
		FFA_HomePage homePage = new FFA_HomePage(appiumDriver);	

		
		try {
			initApplication.initializeSetup();
			homePage.onHomePage();
			homePage.checkIffavBarLiveStreamExists();
			homePage.homePgSections();
			homePage.admessageBannerCheck();
			homePage.removeLeagues();
			homePage.checkLiveStream();

		} catch (Exception e) {

		}

}
}
