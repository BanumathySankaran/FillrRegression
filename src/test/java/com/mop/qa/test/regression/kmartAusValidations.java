package com.mop.qa.test.regression;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.kmartMenu;
import com.mop.qa.pageobject.launchClientURL;
import com.mop.qa.test.testBase1.TestBase;

public class kmartAusValidations extends TestBase {
	@Test
	public void kmartAusValidations_TestCase() throws Exception {
		System.out.println("TestCase Title : Kmart Australia validations : Started .....");
		launchClientURL launchUrl  = new launchClientURL(appiumDriver);
		kmartMenu kmartCont = new kmartMenu(appiumDriver);
		
		
		launchUrl.searchAndTypeURL("kmartAus");
		kmartCont.addItemsToCartKmart();
		
	}

}
