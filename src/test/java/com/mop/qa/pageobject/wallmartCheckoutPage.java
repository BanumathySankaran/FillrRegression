package com.mop.qa.pageobject;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mop.qa.test.testBase1.PageBase;

import io.appium.java_client.AppiumDriver;

public class wallmartCheckoutPage extends PageBase {
	public wallmartCheckoutPage(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}

	Logger logger = Logger.getLogger(wallmartCheckoutPage.class.getName());
	String checkOut = null;
	String signInEmail = null;
	String passWdField = null;
	String show = "//*[@text='Show']";
	String cartDetector = "//*[contains(text(),'Cart Detected')]";
	String okBtn = null;
	String contWithoutAcc = "//*[@text='Continue without account']";
	String continueBtn = null;
	String createAcc = "//*[@text='create a new account']";
	String goKey = null;
	String editBtn = "//*[@text='Edit']";
	String editDelAddress = "//*[@text='Edit Delivery Address']";
	String cusFirstName = null;
	String cusLastName = null;
	String cusPhoneNo = null;
	String addFirstLine = null;
	String addSecLine = null;
	String cityVal = null;
	String stateVal = null;
	String zipCodeVal = null;
	String useThisAddress = "//*[@text='Use this address']";
	String contThisAdd = "//*[@text='Continue with this address']";
	String creditCardOption = "//*[@text='Credit card']";
	String credCardNum = null;
	String credDate = "//*[contains(text(),'Expiration Month')]";
	String credMonth = "//*[contains(text(),'Expiration Year')]";
	String ccValue = null;
	String contBtn2 = null;
	String formValCap = "//*[@text='Form Values Captured']";
	String urlSearchBar = null;
	String cusEmailID = null;

	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {
			checkOut = "((//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAWebView']]]]]/*[@class='UIAView'])[2]/*/*[contains(text(),'Check out')])[1]";
			urlSearchBar = "//*[@class='UIAView' and ./*[@id='Address Bar']]";
			goKey = "//*[@text='go']";
			signInEmail = "//*[@class='UIATextField' and (./preceding-sibling::* | ./following-sibling::*)[@text='Sign in']]";
			passWdField = "//*[@id='Password (required)']/parent::*/parent::*/following-sibling::*";
			okBtn = "//*[@text='Dismiss']";
			continueBtn = "//*[@id='Continue to Delivery Address']";
			cusFirstName = "(((((//*[@text='Choose delivery address']/*[@class='UIAView'])[5]/*[@class='UIAView'])[3]/*[@class='UIAView'])[1]/*[@class='UIAView'])[1]/*[@class='UIATextField'])[1]";
			cusLastName = "(((((//*[@text='Choose delivery address']/*[@class='UIAView'])[5]/*[@class='UIAView'])[3]/*[@class='UIAView'])[1]/*[@class='UIAView'])[1]/*[@class='UIATextField'])[2]";
			cusPhoneNo = "(((((//*[@text='Choose delivery address']/*[@class='UIAView'])[5]/*[@class='UIAView'])[3]/*[@class='UIAView'])[1]/*[@class='UIAView'])[1]/*[@class='UIATextField'])[3]";
			cusEmailID = "(((((//*[@text='Choose delivery address']/*[@class='UIAView'])[5]/*[@class='UIAView'])[3]/*[@class='UIAView'])[1]/*[@class='UIAView'])[1]/*[@class='UIATextField'])[4]";
			addFirstLine = "(((((//*[@text='Choose delivery address']/*[@class='UIAView'])[5]/*[@class='UIAView'])[3]/*[@class='UIAView'])[1]/*[@class='UIAView'])[1]/*[@class='UIATextField'])[5]";
			addSecLine = "(((((//*[@text='Choose delivery address']/*[@class='UIAView'])[5]/*[@class='UIAView'])[3]/*[@class='UIAView'])[1]/*[@class='UIAView'])[1]/*[@class='UIATextField'])[6]";
			cityVal = "(((((//*[@text='Choose delivery address']/*[@class='UIAView'])[5]/*[@class='UIAView'])[3]/*[@class='UIAView'])[1]/*[@class='UIAView'])[1]/*[@class='UIATextField'])[7]";
			stateVal = "//*[@text and @class='UIAView' and (./preceding-sibling::* | ./following-sibling::*)[@class='UIAView' and ./*[@id='State*']] and ./parent::*[@class='UIAView']]";
			zipCodeVal = "//*[@id='zipcode']";
			credCardNum = "//*[@id='Card number*' and @class='UIATextField']";
			ccValue = "//*[@placeholder=' ']";

		}

		else if (platform_Name.equalsIgnoreCase("Android")) {
			checkOut = "//*[@class='android.view.View' and ./*[contains(text(),'Check out')]]";
			signInEmail = "//*[@id='sign-in-email']";
			passWdField = "//*[@class='android.widget.EditText' and ./parent::*[@class='android.view.View' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Password (required)']]]]";
			continueBtn = "//*[@text='2021']";
			cusFirstName = "//*[@id='firstName']";
			cusLastName = "//*[@id='lastName']";
			cusPhoneNo = "//*[@id='phone']";
			addFirstLine = "//*[@id='addressLineOne']";
			addSecLine = "//*[@id='addressLineTwo']";
			cityVal = "//*[@id='city']";
			stateVal = "//*[@id='state']";
			zipCodeVal = "//*[@id='postalCode']";
			contBtn2 = "//*[@text='Do not sell my personal information']";
			urlSearchBar = "//*[@id='search']";
			goKey = "//*[@contentDescription='Go']";
			okBtn = "//*[@text='OK']";
			credCardNum = "//*[@id='creditCard']";
			ccValue = "//*[@id='cvv']";
		}
	}

	public void cartPageValidate() throws Exception {
		cartDetectorCheck(cartDetector, okBtn);
		this.waitFor(4);
		if (!isElementDisplayed(6, checkOut, "checkout button")) {
			reloadPgIfBtnNotDisp(checkOut, urlSearchBar, goKey);
			WebElement checkOutBtn = findElementByXpath(checkOut, "Check out button");
			this.softWait(5);
			checkOutBtn.click();
			logger.info("The checkout button is selected");
		} else {
			try {
				this.clickWithWait(checkOut, "checkout page", 5);
			} catch (Exception e) {
				this.clickWithWait(checkOut, "checkout page", 5);
			}
		}
		formValCapturedCheck(formValCap, okBtn);
		if (isElementDisplayed(5, editBtn, "edit button")) {
			this.clickWithWait(editBtn, "edit the Address of customer", 10);
		} else if (isElementDisplayed(6, signInEmail, "email field display check")) {
			this.softWait(10);
			String textFromEmail = getText(signInEmail);
			this.assertTrue(!textFromEmail.isEmpty(), "email Field not empty");
			this.clickWithoutWait(show, "show password");
			String txtFromPasswd = getText(passWdField);
			this.assertTrue(!txtFromPasswd.isEmpty(), "password Field not empty");
			this.click(goKey, "click on go button: ");
			if (isElementDisplayed(5, contWithoutAcc, "Continue without account")) {
				this.clickWithoutWait(contWithoutAcc, "Continue without account");
			}
		}
	}

	public void guestDetailsAndPaymentPageValidations() throws Exception {
		formValCapturedCheck(formValCap, okBtn);
		this.cartDetectorCheck(cartDetector, okBtn);
		this.waitFor(7);
		this.scrollDownNnoOfTimes(1);
		this.clickWithWait(continueBtn, "Continue", 7);
		// this.clickWithWait(editBtn, "edit the Address of customer", 10);
	}

	public void validateCusAddress() throws Exception {
		cartDetectorCheck(cartDetector, okBtn);
		this.waitFor(15);
		if (isElementDisplayed(5, editDelAddress, "edit button")) {
			this.clickWithWait(editDelAddress, "edit the Address of customer", 10);
		} else if (isElementDisplayed(5, editBtn, "edit button")) {
			this.clickWithWait(editBtn, "edit the Address of customer", 10);
		}
		verify_addressDetails();
		this.swipeDownForNTimes(1);
		if (platform_Name.equalsIgnoreCase("iOS")) {
			String contToPaymnt = "//*[@text='Continue to Payment Options']";
			this.clickWithoutWait(contToPaymnt, "Continue to payment");
			cartDetectorCheck(cartDetector, okBtn);
			if (isElementDisplayed(5, continueBtn, "continue to payment button")) {
				this.clickWithoutWait(continueBtn, "Continue to payment again");
			}
		}

		else {
			this.clickWithWait(useThisAddress, "Use this address", 8);
			if (isElementDisplayed(5, createAcc, "Create Acc")) {
				this.clickWithWait(createAcc, "create account", 8);
			}
			formValCapturedCheck(formValCap, okBtn);
			if (isElementDisplayed(5, contWithoutAcc, "Continue without account")) {
				this.clickWithoutWait(contWithoutAcc, "Continue without account");
			}
			// this.clickWithWait(contThisAdd, "Continue with this address", 8);
			verify_addressDetails();
			this.swipeDownForNTimes(2);
			this.clickWithWait(continueBtn, "Continue", 7);
			logger.info("All the Address fields are validated");
		}
	}

	private void verify_addressDetails() throws Exception {
		if (isElementDisplayed(5, cusFirstName, "Customer first name field")) {
			String textFromFirstName = getText(cusFirstName);
			this.assertTrue(!textFromFirstName.isEmpty(), "First Name Field not empty: " + textFromFirstName);
			String textFromSecName = getText(cusLastName);
			this.assertTrue(!textFromSecName.isEmpty(), "Last Name Field not empty: " + textFromSecName);
			String textFromPhNo = getText(cusPhoneNo);
			this.assertTrue(!textFromPhNo.isEmpty(), "Ph No Field not empty: " + textFromPhNo);
			String addressFirstLine = getText(addFirstLine);
			if (platform_Name.equalsIgnoreCase("iOS")) {
				this.swipeDownForNTimes(1);
			}
			this.assertTrue(!addressFirstLine.isEmpty(), "Address First Line Field not empty: " + addressFirstLine);
			String addressLastLine = getText(addSecLine);
			this.assertTrue(!addressLastLine.isEmpty(), "Address second Field not empty: " + addressLastLine);
			String textFromCity = getText(cityVal);
			this.assertTrue(!textFromCity.isEmpty(), "City Name Field not empty: " + textFromCity);
			String textFromState = getText(stateVal);
			this.assertTrue(!textFromState.isEmpty(), "State Field not empty: " + textFromState);
			String textFromZipCode = getText(zipCodeVal);
			this.assertTrue(!textFromZipCode.isEmpty(), "postal code Field not empty: " + textFromZipCode);
		}
	}

	public void validatePaymentDetails() throws Exception {
		this.cartDetectorCheck(cartDetector, okBtn);
		this.waitFor(3);
		String textFromFirstName = null;
		String textFromSecName = null;
		this.assertTrue(isElementDisplayed(4, creditCardOption, "Credit card"), "credit card option is selected");
		if (platform_Name.equalsIgnoreCase("iOS")) {
			String cusFirstNamePayment = "(//*[@text='First name on card*']/parent::*/following-sibling::*)[1]";
			String LastNamePaymnt = "(//*[@text='Last name on card*']/parent::*/following-sibling::*)[1]";
			textFromFirstName = getText(cusFirstNamePayment);
			this.assertTrue(!textFromFirstName.isEmpty(), "First Name Field not empty: " + textFromFirstName);
			textFromSecName = getText(LastNamePaymnt);
			this.assertTrue(!textFromSecName.isEmpty(), "Last Name Field not empty: " + textFromSecName);
		} else {
			textFromFirstName = getText(cusFirstName);
			this.assertTrue(!textFromFirstName.isEmpty(), "First Name Field not empty: " + textFromFirstName);
			textFromSecName = getText(cusLastName);
			this.assertTrue(!textFromSecName.isEmpty(), "Last Name Field not empty: " + textFromSecName);
		}
		String ccNumber = getText(credCardNum);
		this.assertTrue(!ccNumber.isEmpty(), "CC Number Field not empty: " + ccNumber);
		String ccDate = getText(credDate);
		this.assertTrue(!ccDate.isEmpty(), "CC Date Field not empty: " + ccDate);
		String ccMonth = getText(credMonth);
		this.assertTrue(!ccMonth.isEmpty(), "CC Month Field not empty: " + ccMonth);
		String ccvNum = getText(ccValue);
		this.assertTrue(!ccvNum.isEmpty(), "CCV No: Field not empty: " + ccvNum);
		logger.info("All the CC fields are validated");
	}

}
