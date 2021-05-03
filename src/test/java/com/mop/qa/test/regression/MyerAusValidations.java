package com.mop.qa.test.regression;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.launchClientURL;
import com.mop.qa.test.testBase1.TestBase;

public class MyerAusValidations extends TestBase{
	@Test
	public void MyerAusValidations_TestCase() throws Exception {
		System.out.println("TestCase Title : Myer Australia validations : Started .....");
		
		launchClientURL launchUrl  = new launchClientURL(appiumDriver);
		launchUrl.searchAndTypeURL("myerAus");
	}
}
