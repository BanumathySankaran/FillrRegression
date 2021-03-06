package com.mop.qa.test.regression;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.launchClientURL;
import com.mop.qa.pageobject.wallmartCheckoutPage;
import com.mop.qa.pageobject.wallmartHome;
import com.mop.qa.test.testBase1.TestBase;

public class wallmartValidations extends TestBase {
	@Test
	public void wallmartValidations_TestCase() throws Exception {
		System.out.println("TestCase Title : wallmart validations : Started .....");
		
		launchClientURL launchUrl  = new launchClientURL(appiumDriver);
		wallmartHome homePg = new wallmartHome(appiumDriver);
		wallmartCheckoutPage checkout = new wallmartCheckoutPage(appiumDriver);
		
		
		launchUrl.searchAndTypeURL("walmart");
		homePg.naviagteToProdPage();
		homePg.addToCart();
		checkout.cartPageValidate();
		checkout.guestDetailsAndPaymentPageValidations();
		checkout.validateCusAddress();
		checkout.validatePaymentDetails();
	}
	
	
}
