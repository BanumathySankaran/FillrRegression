package com.mop.qa.pageobject;

import org.openqa.selenium.By;

import com.mop.qa.test.testBase1.PageBase;

import io.appium.java_client.AppiumDriver;

public class wallmartHome extends PageBase {
	public wallmartHome(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}

	String menu = null;
	String beautyCateg = null;
	String allBeauty = null;
	String beautyCateg2 = null;
	String searchBar = null;
	String goKeyAndroid = "//*[@contentDescription='Go']";
	String searchBtn = null;
	String header = null;

	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {

		}

		else if (platform_Name.equalsIgnoreCase("Android")) {
			menu = "//*[@text='Menu']";
			beautyCateg = "//*[@text='Beauty']";
			allBeauty = "//*[@text='Shop All Beauty']";
			beautyCateg2 = "//*[@text='Beauty' and @class='android.widget.Button']";
			searchBar = "//*[@id='global-search-input']";
			searchBtn = "//*[@text='Perform Search']";
			header = "//*[@text='header']";

		}

	}

	public void naviagteToProdPage() throws Exception {
		this.clickWithWait(menu, "Walmart Menu", 5);
		this.swipeDownForNTimes(3);
		this.waitFor(2);
		this.clickWithWait(beautyCateg, "Beauty", 5);
		this.clickWithWait(beautyCateg2, "Beauty", 5);
		
	}
}
