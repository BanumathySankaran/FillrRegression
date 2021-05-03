package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mop.qa.test.testBase1.*;
import io.appium.java_client.AppiumDriver;

public class launchClientURL extends PageBase {

	public launchClientURL(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}

	/*
	 * ************************ Elements XPath Values
	 */

	String urlSearchBar = null;
	String goKeyAndroid = "//*[@contentDescription='Go']";
	String openTabAndr = "//*[@id='arrow']";
	private static final String macysURL = "https://www.macys.com";
	private static final String kmartAus = "https://www.kmart.com.au";

	String menuTxt = "//*[@text='MENU']";
	String tabsOpen = "//*[@id='arrow']";
	String closeBtnAndr = "//*[@id='deleteButton']";
	String profSelectionAndr = "//*[@contentDescription='More options']";
	String switchProf = "//*[@text='Switch Profile']";
	String andrSwitchProfOptions = "//*[@text='Switch Profile']/following-sibling::*/child::*";

	/* ******************************************************************** */
	/* Methods to handle the initial set up for AFL Application */
	/* ******************************************************************** */
	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {

		}

		else if (platform_Name.equalsIgnoreCase("Android")) {

			urlSearchBar = "//*[@id='search']";
		}
	}

	public void searchAndTypeURL(String client) throws Exception {

		String url = null;
		String AusDomain = "au";
		String USDomain = "US";
		this.click(profSelectionAndr, "select options tab at top");
		this.click(switchProf, "switch profile");
		if (client.equalsIgnoreCase("macys")) {
			url = getAppProperties("macys");
		} else if (client.equalsIgnoreCase("kmartAus")) {
			url = getAppProperties("kmartAus");
		} else if (client.equalsIgnoreCase("myerAus")) {
			url = getAppProperties("myerAus");
		}else if(client.equalsIgnoreCase("walmart")) {
			url = getAppProperties("walmart");
		}
			@SuppressWarnings("unchecked")
			List<WebElement> optionsProfile = appiumDriver.findElements(By.xpath(andrSwitchProfOptions));
			for (WebElement ele : optionsProfile) {
				String choice = ele.getText();
				if(url.contains(AusDomain)) {
				if (choice.contains(AusDomain.toUpperCase())) {
					this.softWait(10);
					this.click(ele, "Au profile");
					System.out.println("Au profile selected");
					break;
				}
				break;
				}
				else if(choice.contains(USDomain)) {
					this.click(ele, "US profile");
					this.waitFor(4);
					break;
				}
			}

			appiumDriver.findElement(By.xpath(urlSearchBar)).sendKeys(url);


		this.softWait(10);
		this.click(urlSearchBar, "click On searchBar");
		this.click(goKeyAndroid, "click on go button Android Key Board");
	}

	public void closeTabs() throws Exception {
		if (isElementDisplayed(5, tabsOpen, "any open tabs seen: ")) {
			@SuppressWarnings("unchecked")
			List<WebElement> closeButtons = appiumDriver.findElements(By.xpath(closeBtnAndr));
			for (WebElement ele : closeButtons) {
				this.click(ele, "Close tabs that are open");
				this.softWait(7);
			}
		}
	}

}
