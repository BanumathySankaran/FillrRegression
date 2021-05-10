package com.mop.qa.pageobject;

import java.awt.Robot;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
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
	Logger logger = Logger.getLogger(launchClientURL.class.getName());
	String urlSearchBar = null;
	String clearTxtUrlBarIOS = "//*[@text='Clear text']";
	String goKey = null;
	String openTabAndr = "//*[@id='arrow']";
	private static final String macysURL = "https://www.macys.com";
	private static final String kmartAus = "https://www.kmart.com.au";
	String menuTxt = "//*[@text='MENU']";
	String tabsOpen = "//*[@id='arrow']";
	String closeBtnAndr = "//*[@id='deleteButton']";
	String profSelection = null;
	String switchProf = "//*[@text='Switch Profile']";
	String andrSwitchProfOptions = "//*[@text='Switch Profile']/following-sibling::*/child::*";
	String iosSwitchProfOptions = "(//*[@text])[3]";
	String loadProf = null;
	String okIOS = null;

	/* ******************************************************************** */
	/* Methods to handle the initial set up for AFL Application */
	/* ******************************************************************** */
	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {
			profSelection = "(//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@text='Toolbar View']]]/*/*[@class='UIAButton'])[5]";
			urlSearchBar = "//*[@id='Address Bar']";
			goKey = "//*[@text='go']";
			loadProf = "//*[@text='Load Profile' and @class='UIAStaticText']";
			okIOS = "//*[@text='OK']";
		}

		else if (platform_Name.equalsIgnoreCase("Android")) {
			profSelection = "//*[@contentDescription='More options']";
			urlSearchBar = "//*[@id='search']";
			goKey = "//*[@contentDescription='Go']";
		}
	}

	public void searchAndTypeURL(String client) throws Exception {

		String url = null;
		String AusDomain = "au";
		String USDomain = "US";
		if (platform_Name.equalsIgnoreCase("iOS")) {
			if(isElementDisplayed(5, loadProf, "Load Profile")) {
				this.clickWithoutWait(okIOS, "Ok Button");
			}
			this.click(profSelection, "select options tab at top");
			this.click(switchProf, "switch profile");
			if (client.equalsIgnoreCase("walmart")) {
				url = getAppProperties("walmart");
				@SuppressWarnings("unchecked")
				List<WebElement> profOptionsIOS = appiumDriver.findElements(By.xpath(iosSwitchProfOptions));
				for (WebElement ele : profOptionsIOS) {
					String txtValProfile = getText(ele);
					if (txtValProfile.contains("US")) {
						ele.click();
						logger.info("click on US profile successful");
						break;
					}
				}
			}
			this.clickWithWait(urlSearchBar, "search bar ios", 5);
			this.clickWithWait(clearTxtUrlBarIOS, "clear text", 5);
			WebElement wb = appiumDriver.findElement(By.xpath(urlSearchBar));
/*			JavascriptExecutor jse = (JavascriptExecutor)appiumDriver;
			jse.executeScript("arguments[0].value='"+url+"';", wb);*/
			wb.sendKeys(url);
			this.clickWithWait(urlSearchBar, "search bar ios", 5);
			this.clickWithWait(goKey, "click on go ios", 5);
			
			
		}

		else if (platform_Name.equalsIgnoreCase("Android")) {
			this.click(profSelection, "select options tab at top");
			this.click(switchProf, "switch profile");
			if (client.equalsIgnoreCase("macys")) {
				url = getAppProperties("macys");
			} else if (client.equalsIgnoreCase("kmartAus")) {
				url = getAppProperties("kmartAus");
			} else if (client.equalsIgnoreCase("myerAus")) {
				url = getAppProperties("myerAus");
			} else if (client.equalsIgnoreCase("walmart")) {
				url = getAppProperties("walmart");
			}
			@SuppressWarnings("unchecked")
			List<WebElement> optionsProfile = appiumDriver.findElements(By.xpath(andrSwitchProfOptions));
			for (WebElement ele : optionsProfile) {
				String choice = ele.getText();
				if (url.contains(AusDomain)) {
					if (choice.contains(AusDomain.toUpperCase())) {
						this.softWait(10);
						this.click(ele, "Au profile");
						System.out.println("Au profile selected");
						break;
					}
					break;
				} else if (choice.contains(USDomain)) {
					this.click(ele, "US profile");
					this.waitFor(4);
					break;
				}
			}
		}

		appiumDriver.findElement(By.xpath(urlSearchBar)).sendKeys(url);
		this.softWait(10);
		this.click(urlSearchBar, "click On searchBar");
		this.click(goKey, "click on go button Android Key Board");
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
