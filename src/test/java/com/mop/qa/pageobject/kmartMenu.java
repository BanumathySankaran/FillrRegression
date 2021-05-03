package com.mop.qa.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.mop.qa.test.testBase1.PageBase;

import io.appium.java_client.AppiumDriver;

public class kmartMenu extends PageBase{

	public kmartMenu(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}
	String menuTxt = null;
	String womens = null;
	String viewAllToys = "//*[@text='View all Toys']";
	String womenShoes = null;
	String viewAllShoes = null;
	String formDet = null;
	String okBtn = "//*[@text='OK']";
	String close = "//*[@text='Close ']";
	String closeX = "//*[@text='X']";
	String size = null;
	String addToBag = null;
	String prod1 = "(//*[@class='android.widget.Image' and ./parent::*[@id]])[1]";
	String prod2 = "(//*[@text and @class='android.widget.Image' and ./parent::*])[2]";
	String productList= "((//*[@text='View all Shoes']/parent::*/following-sibling::*)[2]/child::*)[5]";
	String backBtn = null;
	String postcode = null;
	String postcodeOption = null;
	String shoppingBag = null;
	String proceedToCheck = null;
	String shoesOption = null;

	
	
	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {

	
		} 
		
		else if (platform_Name.equalsIgnoreCase("Android")) {
			menuTxt = "//*[@contentDescription='MENU']";
			womens = "//*[@id='level1a_womens']";
			womenShoes = "(//*[@class='android.widget.TextView' and ./parent::*[@contentDescription]])[3]";
			viewAllShoes = "(//*[contains(text(),'View all')])[2]";
			formDet = "//*[@text='Form Detected']";
			size = "(//*[@text='Size']/following-sibling::*)[3]";
			addToBag = "//*[@text='add to bag link']";
			backBtn = "//*[@id='back']";
			postcode = "//*[@text='Delivery Postcode:']";
			postcodeOption = "(((//*[@text='Delivery Postcode:']/following-sibling::*)[2]/child::*/child::*)[2]/child::*)[4]/child::*";
			shoppingBag = "//*[contains(text(),'Shopping Bag')]";
			proceedToCheck = "//*[@text='PROCEED TO CHECKOUT']";
			shoesOption = "(//*[@class='android.widget.TextView' and ./parent::*[@contentDescription]])[4]";
			
		}
	}
	
	
	public void addItemsToCartKmart() throws Exception {
		this.waitFor(38);
		clickOnClosePopUp();
		this.clickWithWait(menuTxt, "menu",5);
		this.clickWithoutWait(womens, "womens");	
		this.clickWithoutWait(womenShoes, "womens shoes");
		this.clickWithWait(shoesOption, "shoe option", 5);
		this.clickWithoutWait(viewAllShoes, "view all");
		if(isElementDisplayed(6, formDet, "Form detected pop up")) {
			this.click(okBtn, "click on ok");	
		}
		this.waitFor(10);
		this.swipeDownForNTimes(2);		
		this.clickWithWait(prod1, "random product", 1);
		this.waitFor(10);
		clickOnOkPopUp();
		this.swipeDownForNTimes(2);
		this.clickWithWait(size, "size", 1);
		this.clickWithWait(addToBag, "add item to bag", 1);
		if(isElementDisplayed(4, postcode, "post code")) {
		this.click(postcodeOption, "choose the post code option");	
		}
		this.scrollUpNnoOfTimes(1);
		this.click(backBtn, "back to prod list");
		this.click(prod2, "item 2");
		clickOnOkPopUp();
		this.scrollDownOrUpForNTimes(1, 400, "Down");
		this.click(size,"select size");
		this.click(addToBag,"Add to Bag");
		this.scrollDownOrUpForNTimes(1, 500, "Up");
		this.click(shoppingBag,"Add to Bag");
		clickOnOkPopUp();
		this.scrollDownOrUpForNTimes(1, 600, "Down");
		this.click(proceedToCheck, "check out");
		clickOnOkPopUp();
		
	}


	private void clickOnOkPopUp() throws Exception {
		if(isElementDisplayed(6, okBtn, "OK Button displayed")) {
			this.click(okBtn, "click on ok");	
		}
	}
	
	private void clickOnClosePopUp() throws Exception {
		if(isElementDisplayed(6, close, "close Button displayed")) {
			this.click(closeX, "click on close");	
		}
	}
	

}
