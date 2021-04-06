package com.mop.qa.test.regression;

import com.mop.qa.test.testBase1.*;
import org.testng.annotations.Test;
import com.mop.qa.pageobject.FFA_HomePage;
import com.mop.qa.pageobject.FFA_Initialize_Native_App;

public class FFA_OnBoarding extends TestBase
{	
	@Test
	public void FFA_OnBoarding_TestCase() throws Exception 
	{
		System.out.println("TestCase Title : Verify FFA Onboarding : Started .....");
		FFA_Initialize_Native_App initApplication  = new FFA_Initialize_Native_App(appiumDriver);
		FFA_HomePage homePage = new FFA_HomePage(appiumDriver);	
		
		try 
		{
			initApplication.initializeSetup();
			homePage.onHomePage();


		} catch (Exception e) 
		
		{
			System.out.println("TestCase Exception :" + e.getMessage());
		}
		
	}

}
