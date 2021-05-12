package com.mop.qa.pageobject;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mop.qa.test.testBase1.PageBase;

import io.appium.java_client.AppiumDriver;

public class wallmartHome extends PageBase {
	public wallmartHome(AppiumDriver<?> appiumDriver) {
		super(appiumDriver);
		init_elementsXpath();
	}

	Logger logger = Logger.getLogger(wallmartHome.class.getName());

	String menu = "//*[@text='Menu']";;
	String prodCateg1 = "//*[@text='Clothing, Shoes & Accessories']";
	String allBeauty = null;
	String prodCateg2 = "//*[@text='Sunglasses']";
	String searchBar = null;
	String goKey = null;
	String searchBtn = null;
	String header = null;
	String prod = null;
	String prodQntity = null;
	String qnChoice = null;
	String addToCart = null;
	String formValCap = null;
	String okBtn = null;
	String kart = null;
	String cartDetector = "//*[contains(text(),'Cart Detected')]";
	String wallmartOption = "//*[@text='Walmart.com']";
	String remBtn = "//*[contains(text(),'Remove')]";
	String backBtn = null;
	String urlSearchBar = null;

	public void init_elementsXpath() {
		if (platform_Name.equalsIgnoreCase("iOS")) {
			kart = "//*[@class='UIAView' and @width>0 and ./*[contains(text(),'Cart')]]";
			urlSearchBar = "//*[@class='UIAView' and ./*[@id='Address Bar']]";
			goKey = "//*[@text='go']";
			okBtn = "//*[@text='Dismiss']";
			prod = "(//*[@class='UIAView' and @width>0 and ./*[@id]])[24]/child::*";
			prodQntity = "//*[@text='Quantity']";
			addToCart = "//*[@text='Add to cart' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='UIAView']]]";
		}

		else if (platform_Name.equalsIgnoreCase("Android")) {
			okBtn = "//*[@text='OK']";
			allBeauty = "//*[@text='Shop All Beauty']";
			searchBar = "//*[@id='global-search-input']";
			searchBtn = "//*[@text='Perform Search']";
			header = "//*[@text='header']";
			prod = "(//*[@class='android.widget.Image' and ./parent::*[./parent::*[@contentDescription]]])[1]";
			prodQntity = "//*[@text='1']";
			qnChoice = "(//*[@class='android.widget.ListView']/*[@id='text1'])[3]";
			addToCart = "//*[@class='android.view.View' and ./*[@text='Add to cart']]";
			formValCap = "//*[@text='Form Values Captured']";
			kart = "//*[@id='hf-cart']";
			backBtn = "//*[@id='back']";
			urlSearchBar = "//*[@id='search']";
			goKey = "//*[@contentDescription='Go']";
		}

	}

	public void naviagteToProdPage() throws Exception {
		this.waitFor(13);
		checkIfItemIsPresentInCart();
		this.waitFor(10);
		this.clickWithWait(menu, "Walmart Menu", 5);
		this.swipeDownForNTimes(2);
		this.waitFor(2);
		this.reloadPgIfBtnNotDisp(prodCateg1, urlSearchBar, goKey);
		this.clickWithWait(prodCateg1, "Random category once", 7);
		this.clickWithWait(prodCateg2, "random sub category", 7);
		this.swipeDownForNTimes(1);
		this.waitFor(5);
		WebElement randProd = appiumDriver.findElement(By.xpath(prod));
		this.softWait(4);
		try {
			randProd.click();
		} catch (Exception e1) {
			randProd.click();
		}
	}

	public void addToCart() throws InterruptedException, Exception {
		try {
			this.waitFor(10);
			this.swipeDownForNTimes(3);
			this.assertTrue(isElementDisplayed(4, prodQntity, "check the no of items"), "no of items box is present");
			this.waitFor(5);
			logger.info("check if the button is displayed if not reload the page: ");
			reloadPgIfBtnNotDisp(addToCart,urlSearchBar,goKey);
			WebElement ele = findElementByXpath(addToCart, "add to cart button");
			this.softWait(5);
			ele.click();
			logger.info("item added to cart");
			cartDetectorCheck(cartDetector, okBtn);
			formValCapturedCheck(formValCap, okBtn);
			this.scrollUpNnoOfTimes(1);
			this.waitFor(13);
			if(platform_Name.equalsIgnoreCase("iOS")) {
			cartDetectorCheck(cartDetector, okBtn);
			}
			this.assertTrue(isElementDisplayed(5, kart, "cart"), "cart is present");
			logger.info("click on cart now");
			this.clickWithWait(kart, "click on  cart", 7);
			this.waitFor(3);
		} catch (Exception e) {

		}
	}

	public void checkIfItemIsPresentInCart() throws Exception {
		this.clickWithWait(kart, "click on  cart", 5);
		this.reloadPgIfBtnNotDisp(remBtn,urlSearchBar,goKey);
		cartDetectorCheck(cartDetector, okBtn);
		if(platform_Name.equalsIgnoreCase("iOS")) {
			this.swipeDownForNTimes(1);
		}
		if (isElementDisplayed(6, remBtn, "Check if remove is present")) {
			this.clickWithWait(remBtn, "Remove Button", 10);
			this.scrollUpNnoOfTimes(1);
		}

	}
}
