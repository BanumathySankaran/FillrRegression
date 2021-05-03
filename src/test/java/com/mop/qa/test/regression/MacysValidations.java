package com.mop.qa.test.regression;

import org.testng.annotations.Test;
import com.mop.qa.pageobject.launchClientURL;
import com.mop.qa.pageobject.macysMenu;
import com.mop.qa.test.testBase1.TestBase;

public class MacysValidations extends TestBase {
	@Test
	public void MacysValidations_TestCase() throws Exception {
		System.out.println("TestCase Title : Test Browser Onboarding : Started .....");
		launchClientURL launchUrl  = new launchClientURL(appiumDriver);
		macysMenu macysPg = new macysMenu(appiumDriver);
		launchUrl.searchAndTypeURL("macys");
		macysPg.checkIfMacysLogoVisible();
		//this.appiumDriver.quit();
	}

}
