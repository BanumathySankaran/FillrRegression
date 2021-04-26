package com.mop.qa.test.testBase1;

import com.google.inject.internal.util.ImmutableMap;
import com.mop.qa.test.Utilities.ExtentUtility;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.DMatch;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 2001413
 *
 */
@SuppressWarnings("deprecation")
public class PageBase {
	public RemoteWebDriver remoteDriver;

	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriver;

	protected String toolName;

	public String device_OS;

	protected static String appType;

	public static String platform_Name;

	public static String locality_value;

	TestBase t;

	String filesperator = System.getProperty("file.separator");

	String installApp = null;

	String deviceSerialNumber = null;

	String installPath = null;

	public int count3;

	public int imagewidth1;

	public int imageheight1;

	public int imagewidth2;

	public int imageheight2;

	public enum Page {
		FirstThrid, SecondThrid, Whole, swipe;
	}

	@SuppressWarnings("rawtypes")
	public PageBase(AppiumDriver driver) {
		this.count3 = 1;
		this.text1 = null;
		this.tool = null;
		this.webBrowser = null;
		this.chromeDriverPath = null;
		this.fireFoxDriverPath = null;
		this.IEDriverPath = null;
		this.deviceName = null;
		this.appName = null;
		this.appiumPort = null;
		this.deviceVersion = null;
		this.appPackage = null;
		this.appActivity = null;
		this.Android_Appium_Server_Path = null;
		this.appiumPort_Ios = null;
		this.devicePlatformName_Ios = null;
		this.deviceVersion_Ios = null;
		this.device_UDID = null;
		this.platformName = null;
		this.applicationPath = null;
		this.appiumURL = null;
		this.ParentWinhadleMob = null;
		this.ParentWinhadle = null;
		this.mobileCloud = null;
		this.accesskey = null;
		PageBase.appiumDriver = driver;
		PageFactory.initElements((WebDriver) PageBase.appiumDriver, this);
		this.toolName = "Appium";
		TestBase testBaseObj = new TestBase();
		appType = testBaseObj.appType;
	}

	public PageBase(RemoteWebDriver driver) {
		this.count3 = 1;
		this.text1 = null;
		this.tool = null;
		this.webBrowser = null;
		this.chromeDriverPath = null;
		this.fireFoxDriverPath = null;
		this.IEDriverPath = null;
		this.deviceName = null;
		this.appName = null;
		this.appiumPort = null;
		this.deviceVersion = null;
		this.appPackage = null;
		this.appActivity = null;
		this.Android_Appium_Server_Path = null;
		this.appiumPort_Ios = null;
		this.devicePlatformName_Ios = null;
		this.deviceVersion_Ios = null;
		this.device_UDID = null;
		this.platformName = null;
		this.applicationPath = null;
		this.appiumURL = null;
		this.ParentWinhadleMob = null;
		this.ParentWinhadle = null;
		this.mobileCloud = null;
		this.accesskey = null;
		this.remoteDriver = driver;
		PageFactory.initElements((WebDriver) this.remoteDriver, this);
		this.toolName = "Selenium";
	}

	public PageBase() {
		this.count3 = 1;
		this.text1 = null;
		this.tool = null;
		this.webBrowser = null;
		this.chromeDriverPath = null;
		this.fireFoxDriverPath = null;
		this.IEDriverPath = null;
		this.deviceName = null;
		this.appName = null;
		this.appiumPort = null;
		this.deviceVersion = null;
		this.appPackage = null;
		this.appActivity = null;
		this.Android_Appium_Server_Path = null;
		this.appiumPort_Ios = null;
		this.devicePlatformName_Ios = null;
		this.deviceVersion_Ios = null;
		this.device_UDID = null;
		this.platformName = null;
		this.applicationPath = null;
		this.appiumURL = null;
		this.ParentWinhadleMob = null;
		this.ParentWinhadle = null;
		this.mobileCloud = null;
		this.accesskey = null;
		try {
			TestBase testBaseObj = new TestBase();
			if (testBaseObj.toolName.equalsIgnoreCase("selenium")) {
				PageFactory.initElements((WebDriver) this.remoteDriver, this);
				this.toolName = "Selenium";
			} else if (testBaseObj.toolName.equalsIgnoreCase("appium")) {
				PageFactory.initElements((WebDriver) PageBase.appiumDriver, this);
				this.toolName = "Appium";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int n = 0;

	public String text1;

	public String tool;

	public String webBrowser;

	public String chromeDriverPath;

	public String fireFoxDriverPath;

	public String IEDriverPath;

	public String deviceName;

	public String appName;

	public String appiumPort;

	public String deviceVersion;

	public String appPackage;

	public String appActivity;

	public String Android_Appium_Server_Path;

	public String appiumPort_Ios;

	public String devicePlatformName_Ios;

	public String deviceVersion_Ios;

	public String device_UDID;

	public String platformName;

	public String applicationPath;

	public String appiumURL;

	public String ParentWinhadleMob;

	public String ParentWinhadle;

	public String mobileCloud;

	public String accesskey;

	@SuppressWarnings("rawtypes")
	public AppiumDriver<WebElement> launchApp(String udid, String locality, String url, String toolname, String appType,
			String port, String platformName, String startURL) throws Exception {
		platform_Name = platformName;
		locality_value = locality;
		System.out.println("platformName " + platformName);
		System.out.println("appType " + appType);
		this.tool = this.toolName;
		this.installApp = getAppProperties("installApplication");
		this.appName = getAppProperties("appName");
		this.deviceVersion = getAppProperties("deviceVersion");
		this.appPackage = getAppProperties("appPackage");
		this.appActivity = getAppProperties("appActivity");
		String bundleID = getAppProperties("bundleID");
		if (locality.equalsIgnoreCase("Hub")) {
			if (this.tool.equalsIgnoreCase("Appium"))
				if (platformName.equalsIgnoreCase("iOS") && appType.equalsIgnoreCase("Native")) {
					System.out.println("iOS Native");
					DesiredCapabilities capabilities = new DesiredCapabilities();
					String bootstrapPath = getAppProperties("bootstrapPath");
					String agentPath = getAppProperties("agentPath");
					this.appiumPort_Ios = getAppProperties("appiumPort_Ios");
					this.deviceVersion_Ios = getAppProperties("deviceVersion_Ios");
					if (udid == null)
						udid = getAppProperties("device_UDID");
					this.applicationPath = getAppProperties("applicationPath");
					System.out.println("port: " + port);
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://127.0.0.1:" + port + "/wd/hub";
					} else {
						this.appiumURL = "http://0.0.0.0:" + port + "/wd/hub";
					}
					System.out.println("URL  : " + this.appiumURL);
					capabilities.setCapability("deviceName", "iPhone 7");
					capabilities.setCapability("platformName", platformName);
					capabilities.setCapability("platformVersion", this.deviceVersion_Ios);
					capabilities.setCapability("instrumentApp", "true");
					capabilities.setCapability("udid", udid);
					capabilities.setCapability("automationName", "XCUITest");
					capabilities.setCapability("autoAcceptAlerts", true);
					capabilities.setCapability("autoDismissAlerts", true);
					capabilities.setCapability("autoGrantPermissions", true);
					if (this.installApp == "Y")
						capabilities.setCapability("app", this.applicationPath);
					capabilities.setCapability("bundleId", bundleID);
					capabilities.setCapability("bootstrapPath", bootstrapPath);
					capabilities.setCapability("agentPath", agentPath);
					capabilities.setCapability("noReset", true);
					capabilities.setCapability("newCommandTimeout", "60");
					capabilities.setCapability("clearSystemFiles", true);
					capabilities.setCapability("newCommandTimeout", Integer.valueOf(200));
					if (PageBase.appiumDriver == null)
						PageBase.appiumDriver = null;
					PageBase.appiumDriver = (AppiumDriver<WebElement>) new IOSDriver<WebElement>(
							new URL(this.appiumURL), (Capabilities) capabilities);
					PageBase.appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
					PageBase.appiumDriver.context("NATIVE_APP");
				} else if (platformName.equalsIgnoreCase("Android") && appType.equalsIgnoreCase("Native")) {
					System.out.println("Android Native");
					DesiredCapabilities capabilities = new DesiredCapabilities();
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://127.0.0.1:" + port + "/wd/hub";
					} else {
						this.appiumURL = "http://0.0.0.0:" + port + "/wd/hub";
					}
					System.out.println(port);
					capabilities.setCapability("appium-version", "1.0");
					if (this.installApp == "Y")
						capabilities.setCapability("app", this.appName);
					capabilities.setCapability("platformName", platformName);
					if (udid == null)
						udid = getAppProperties("device_UDID");
					capabilities.setCapability("deviceName", udid);
					capabilities.setCapability("udid", udid);
					capabilities.setCapability("appPackage", this.appPackage);
					capabilities.setCapability("appActivity", this.appActivity);
					capabilities.setCapability("--session-override", true);
					capabilities.setCapability("noReset", true);
					capabilities.setCapability("clearSystemFiles", true);
					capabilities.setCapability("newCommandTimeout", Integer.valueOf(200));
					capabilities.setCapability("autoAcceptAlerts", true);
					capabilities.setCapability("autoDismissAlerts", true);
					capabilities.setCapability("autoGrantPermissions", true);
					System.out.println(this.appiumURL);
					PageBase.appiumDriver = (AppiumDriver<WebElement>) new AndroidDriver<WebElement>(
							new URL(this.appiumURL), (Capabilities) capabilities);
					PageBase.appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
				} else if (platformName.equalsIgnoreCase("Android") && appType.equalsIgnoreCase("Web")) {
					System.out.println("Android Browser");
					this.deviceVersion = getAppProperties("deviceVersion");
					this.deviceName = getAppProperties("deviceName");
					this.appiumPort = getAppProperties("appiumPort");
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://127.0.0.1:" + port + "/wd/hub";
					} else {
						this.appiumURL = "http://127.0.0.1:" + port + "/wd/hub";
					}
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("browserName", "Chrome");
					capabilities.setCapability("newCommandTimeout", Integer.valueOf(300));
					capabilities.setCapability("appium-version", "1.0");
					capabilities.setCapability("platformName", platformName);
					capabilities.setCapability("deviceName", udid);
					capabilities.setCapability("udid", udid);
					PageBase.appiumDriver = (AppiumDriver<WebElement>) new AndroidDriver<WebElement>(
							new URL(this.appiumURL), (Capabilities) capabilities);
					PageBase.appiumDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
				} else if (platformName.equalsIgnoreCase("iOS") && appType.equalsIgnoreCase("Web")) {
					System.out.println("iOS Browser");
					this.deviceVersion = getAppProperties("deviceVersion_Ios");
					this.deviceName = getAppProperties("device_UDID");
					this.appiumPort = getAppProperties("appiumPort");
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://127.0.0.1:" + port + "/wd/hub";
					} else {
						this.appiumURL = "http://127.0.0.1:" + port + "/wd/hub";
					}
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("deviceName", "IME's iPhone");
					cap.setCapability("automationName", "XCUITest");
					cap.setCapability("browserName", "Safari");
					cap.setCapability("platformVersion", this.deviceVersion);
					cap.setCapability("platformName", platformName);
					cap.setCapability("udid", this.deviceName);
					cap.setCapability("newCommandTimeout", Integer.valueOf(20000));
					cap.setCapability("safariInitialUrl", startURL.trim());
					PageBase.appiumDriver = (AppiumDriver<WebElement>) new IOSDriver<WebElement>(
							new URL(this.appiumURL), (Capabilities) cap);
					Thread.sleep(10000L);
					PageBase.appiumDriver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
				}
		} else if (locality.equalsIgnoreCase("Grid")) {
			if (!url.equalsIgnoreCase("NA") && this.tool.equalsIgnoreCase("Appium"))
				if (platformName.equalsIgnoreCase("iOS") && appType.equalsIgnoreCase("Native")) {
					this.appiumPort_Ios = getAppProperties("appiumPort_Ios");
					this.deviceVersion_Ios = getAppProperties("deviceVersion_Ios");
					this.device_UDID = getAppProperties("udid");
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://" + url + port + "/wd/hub";
					} else {
						this.appiumURL = "http://0.0.0.0:" + port + "/wd/hub";
					}
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("appium-version", "1.0");
					capabilities.setCapability("platformName", platformName);
					capabilities.setCapability("platformVersion", this.deviceVersion_Ios);
					capabilities.setCapability("deviceName", udid);
					capabilities.setCapability("app", this.applicationPath);
					if (PageBase.appiumDriver == null)
						PageBase.appiumDriver = null;
					this.remoteDriver = (RemoteWebDriver) new IOSDriver(new URL(this.appiumURL),
							(Capabilities) capabilities);
				} else if (platformName.equalsIgnoreCase("Android") && appType.equalsIgnoreCase("Native")) {
					System.out.println("Android Native");
					this.appName = getAppProperties("appName");
					this.deviceVersion = getAppProperties("deviceVersion");
					this.appPackage = getAppProperties("appPackage");
					this.appActivity = getAppProperties("appActivity");
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://" + url + port + "/wd/hub";
					} else {
						this.appiumURL = "http://0.0.0.0:" + port + "/wd/hub";
					}
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("appium-version", "1.0");
					capabilities.setCapability("app", this.appName);
					capabilities.setCapability("platformName", platformName);
					capabilities.setCapability("deviceName", udid);
					capabilities.setCapability("udid", udid);
					capabilities.setCapability("appPackage", this.appPackage);
					capabilities.setCapability("appActivity", this.appActivity);
					PageBase.appiumDriver = (AppiumDriver<WebElement>) new AndroidDriver<WebElement>(new URL(url),
							(Capabilities) capabilities);
					PageBase.appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
				} else if (platformName.equalsIgnoreCase("Android") && appType.equalsIgnoreCase("Web")) {
					this.deviceVersion = getAppProperties("deviceVersion");
					this.deviceName = getAppProperties("deviceName");
					this.appiumPort = getAppProperties("appiumPort");
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://" + url + port + "/wd/hub";
					} else {
						this.appiumURL = "http://0.0.0.0:" + port + "/wd/hub";
					}
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("browserName", "Chrome");
					capabilities.setCapability("newCommandTimeout", "300");
					capabilities.setCapability("appium-version", "1.0");
					capabilities.setCapability("platformName", platformName);
					capabilities.setCapability("deviceName", udid);
					capabilities.setCapability("udid", udid);
					PageBase.appiumDriver = (AppiumDriver<WebElement>) new AndroidDriver<WebElement>(new URL(url),
							(Capabilities) capabilities);
					PageBase.appiumDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
				} else if (platformName.equalsIgnoreCase("iOS") && appType.equalsIgnoreCase("Web")) {
					System.out.println("iOS Browser");
					this.deviceVersion = getAppProperties("deviceVersion_Ios");
					this.deviceName = getAppProperties("device_UDID");
					this.appiumPort = getAppProperties("appiumPort");
					if (System.getProperty("os.name").contains("Win")) {
						this.appiumURL = "http://" + url + port + "/wd/hub";
					} else {
						this.appiumURL = "http://0.0.0.0:" + port + "/wd/hub";
					}
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("deviceName", "iPhone");
					cap.setCapability("browserName", "Safari");
					cap.setCapability("platformVersion", this.deviceVersion);
					cap.setCapability("platformName", platformName);
					cap.setCapability("udid", this.deviceName);
					if (PageBase.appiumDriver == null)
						PageBase.appiumDriver = (AppiumDriver<WebElement>) new IOSDriver<WebElement>(
								new URL(this.appiumURL), (Capabilities) cap);
					PageBase.appiumDriver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
				}
		} else if (locality.equalsIgnoreCase("Cloud")) {
			Thread.sleep(20000L);
			System.out.println("Mobile Cloud Execution Started");
			System.out.println("Mobile Cloud URL --" + url);
			System.out.println("Device SN / UDID --" + udid);
			String accessKey = getAppProperties("password");
			if (platformName.equalsIgnoreCase("Android")) {
				System.out.println("Android Cloud Device");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				if (udid == "ANY") {
					capabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
				} else {
					capabilities.setCapability("deviceQuery", "@serialNumber='" + udid + "'");
				}
				if (this.installApp == "Y")
					capabilities.setCapability("app", this.appName);
				capabilities.setCapability("appPackage", this.appPackage);
				capabilities.setCapability("appActivity", this.appActivity);
				capabilities.setCapability("instrumentApp", false);
				capabilities.setCapability("autoAcceptAlerts", true);
				capabilities.setCapability("autoDismissAlerts", true);
				capabilities.setCapability("autoGrantPermissions", true);
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("resetKeyboard", true);
				capabilities.setCapability("testName", getAppProperties("projectName"));
				PageBase.appiumDriver = (AppiumDriver<WebElement>) new AndroidDriver<WebElement>(new URL(url),
						(Capabilities) capabilities);
				PageBase.appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
				Thread.sleep(3000L);
			} else if (platformName.equalsIgnoreCase("iOS")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				if (this.deviceSerialNumber == "ANY") {
					capabilities.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
				} else {
					capabilities.setCapability("deviceQuery", "@serialNumber='" + udid + "'");
				}
				if (this.installApp == "Y")
					capabilities.setCapability("app", this.appName);
				capabilities.setCapability("bundleId", bundleID);
				capabilities.setCapability("noReset", true);
				capabilities.setCapability("accessKey", accessKey);
				capabilities.setCapability("instrumentApp", false);
				capabilities.setCapability("autoAcceptAlerts", true);
				capabilities.setCapability("autoDismissAlerts", true);
				capabilities.setCapability("autoGrantPermissions", true);
				PageBase.appiumDriver = (AppiumDriver<WebElement>) new IOSDriver<WebElement>(new URL(url),
						(Capabilities) capabilities);
				Thread.sleep(10000L);
			}
		}
		return PageBase.appiumDriver;
	}



	public String getPort() throws Exception {
		ServerSocket socket = new ServerSocket(0);
		socket.setReuseAddress(true);
		String port = Integer.toString(socket.getLocalPort());
		socket.close();
		return port;
	}


	public void takeScreenshotVideo(String screenshotName, String videoPlayerPath) {
		try {
			WebElement ele = this.remoteDriver.findElement(By.xpath(videoPlayerPath));
			if (ele.isDisplayed()) {
				File screen = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				int ImageWidth = ele.getSize().getWidth();
				int ImageHeight = ele.getSize().getHeight();
				org.openqa.selenium.Point point = ele.getLocation();
				int xcord = point.getX();
				int ycord = point.getY();
				BufferedImage img = ImageIO.read(screen);
				BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
				ImageIO.write(dest, "png", screen);
				FileUtils.copyFile(screen, new File("VideoComparison\\" + screenshotName + ".png"));
			}
		} catch (Exception e) {
			try {
				System.out.println("e" + e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public ArrayList<Integer> getResolution(WebElement videoPlayerPathWE) {
		ArrayList<Integer> size = new ArrayList<>();
		try {
			if (videoPlayerPathWE.isDisplayed()) {
				int ImageWidth = videoPlayerPathWE.getSize().getWidth();
				int ImageHeight = videoPlayerPathWE.getSize().getHeight();
				size.add(Integer.valueOf(ImageWidth));
				size.add(Integer.valueOf(ImageHeight));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	@SuppressWarnings("rawtypes")
	public void waitForVisibilityOfElement(String xpath) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 120L, 500L);
				waitSelenium.until((Function) ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) PageBase.appiumDriver, 90L, 500L);
				wait.until((Function) ExpectedConditions.elementToBeClickable(this.appiumDriver.findElement(By.xpath(xpath))));
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void takeScreenshot(String screenshotName, String videoPlayerPath) {
		try {
			WebElement ele = this.remoteDriver.findElement(By.xpath(videoPlayerPath));
			if (ele.isDisplayed()) {
				File screen = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				int ImageWidth = ele.getSize().getWidth();
				int ImageHeight = ele.getSize().getHeight();
				org.openqa.selenium.Point point = ele.getLocation();
				int xcord = point.getX();
				int ycord = point.getY();
				BufferedImage img = ImageIO.read(screen);
				BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
				ImageIO.write(dest, "png", screen);
				FileUtils.copyFile(screen, new File("PhotoPassScreenshots/" + screenshotName + ".png"));
			}
		} catch (Exception e) {
			try {
				ExtentUtility.getTest().log(LogStatus.FAIL, e + " Taking Screenshots Fails ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
			}
		}
	}

	public void takeFullScreenshot(String screenshotName) {
		try {
			File screen = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("PhotoPassScreenshots/" + screenshotName + ".png"));
		} catch (Exception e) {
			try {
				ExtentUtility.getTest().log(LogStatus.FAIL, e + " Taking Screenshots Fails ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
			}
		}
	}

	public String takeScreenShot() throws IOException {
		Calendar cal = Calendar.getInstance();
		long s = cal.getTimeInMillis();
		File screen = null;
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				screen = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				screen = (File) PageBase.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(screen,
					new File("ReportGenerator/" + ExtentUtility.reportFolder + "/Screenshots/image" + s + ".png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return (new File("ReportGenerator//" + ExtentUtility.reportFolder + "//Screenshots//image" + s + ".png"))
				.getAbsolutePath();
	}

	public void saveImage(String screenshotName, String videoPlayerPath) throws Exception {
		WebDriverWait waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 120L, 250L);
		waitSelenium.until((Function) ExpectedConditions.visibilityOf(this.remoteDriver.findElement(By.xpath(videoPlayerPath))));
		String s1 = this.remoteDriver.findElement(By.xpath(videoPlayerPath)).getAttribute("src");
		URL url1 = new URL(s1);
		RenderedImage image1 = ImageIO.read(url1);
		ImageIO.write(image1, "png", new File("PhotoPassScreenshots/" + screenshotName + ".png"));
	}

	public void processImage(String file1, String file2) throws Exception {
		try {
			Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
			Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
			PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
			int[] data1 = null;
			if (grab1.grabPixels()) {
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}
			int[] data2 = null;
			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}
			boolean result = Arrays.equals(data1, data2);
			if (!result) {
				System.out.println("Result = Video is playing - PASS ");
			} else {
				System.out.println("Result = Video is not Playing - FALSE");
				ExtentUtility.getTest().log(LogStatus.FAIL, " Result = Video is not Playing - FALSE ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				throw new Exception(" Result = Video is not Playing - FALSE ");
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public void validateImage(String imageName1, String imageName2) throws Exception {
		try {
			String file1 = "PhotoPassScreenshots/" + imageName1 + ".png";
			String file2 = "PhotoPassScreenshots/" + imageName2 + ".png";
			Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
			Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
			PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
			int[] data1 = null;
			if (grab1.grabPixels()) {
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}
			int[] data2 = null;
			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}
			boolean result = Arrays.equals(data1, data2);
			if (result) {
				System.out.println("Result = Image validation - Pass ");
			} else {
				System.out.println("Result = Image validation - Fail ");
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public void validateSlideImage(String imageName1, String imageName2) throws Exception {
		try {
			String file1 = "PhotoPassScreenshots/" + imageName1 + ".png";
			String file2 = "PhotoPassScreenshots/" + imageName2 + ".png";
			Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
			Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
			PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
			int[] data1 = null;
			if (grab1.grabPixels()) {
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}
			int[] data2 = null;
			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}
			boolean result = Arrays.equals(data1, data2);
			if (result) {
				System.out.println("Result = Slide Show Image validation - Fail ");
			} else {
				System.out.println("Result = Slide Show Image validation - Pass ");
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public String getAppProperties(String key) throws IOException {
		String value = "";
		try {
			FileInputStream fileInputStream = new FileInputStream("data.properties");
			Properties property = new Properties();
			property.load(fileInputStream);
			value = property.getProperty(key);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void hideKeyboard() throws Exception {
		PageBase.appiumDriver.hideKeyboard();
		System.out.println("back over");
	}

	public void enterUrl(String url) throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.get(url);
				assertTrue("Application URL " + url + " has been launched", true);
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				PageBase.appiumDriver.get(url);
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void clickPoint(WebElement e, String elementName) throws Exception {
		int xx = (e.getLocation()).x;
		int yy = (e.getLocation()).y;
		System.out.println("X Position : " + xx);
		System.out.println("Y Position : " + yy);
		clickCoordinates(xx, yy);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void clickSave(WebElement e, String elementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.elementToBeClickable(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.elementToBeClickable(e));
				break;
			}
			Thread.sleep(3000L);
			e.click();
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, String.valueOf(elementName) + " not found",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(String.valueOf(elementName) + " not found");
		}
	}

	public void click(WebElement e, String elementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 80L, 500L);
				waitSelenium.until((Function) ExpectedConditions.elementToBeClickable(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 100L, 500L);
				wait.until((Function) ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(e)));
				break;
			}
			e.click();
			System.out.println("Clicked " + elementName);
			Thread.sleep(1000L);
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, String.valueOf(elementName) + " not found",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(String.valueOf(elementName) + " not found");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void verifyelementpresence(String ladderScreen) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 120L, 500L);
				((WebElement) waitSelenium
						.until((Function) ExpectedConditions.presenceOfElementLocated(By.cssSelector(ladderScreen))))
								.isDisplayed();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions
						.elementToBeClickable(PageBase.appiumDriver.findElement(By.cssSelector(ladderScreen))));
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickByJse(WebElement e, String elementName) throws Exception {
		try {
			AppiumDriver<WebElement> appiumDriver;
			RemoteWebDriver remoteWebDriver;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				remoteWebDriver = this.remoteDriver;
				remoteWebDriver.executeScript("arguments[0].click();", new Object[] { e });
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				appiumDriver = this.appiumDriver;
				appiumDriver.executeScript("arguments[0].click();", new Object[] { e });
				Thread.sleep(3000L);
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, String.valueOf(elementName) + " not found",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(String.valueOf(elementName) + " not found");
		}
	}

	public <T> void clickWithoutSS(WebElement e) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 250L);
				waitSelenium.until((Function) ExpectedConditions.elementToBeClickable(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) PageBase.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
			e.click();
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, e + " not found",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(e + " not found");
		}
	}

	public void click_verifyurl(WebElement e, String elementName, String url) throws Exception {
		try {
			while (!this.remoteDriver.getCurrentUrl().equalsIgnoreCase(url))
				e.click();
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, String.valueOf(elementName) + " not found",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(String.valueOf(elementName) + " not found");
		}
	}

	@SuppressWarnings("unchecked")
	public void clickHiddentElement(WebElement e, String elementName) throws Exception {
		try {
			AppiumDriver<WebElement> appiumDriver;
			RemoteWebDriver remoteWebDriver;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				remoteWebDriver = this.remoteDriver;
				remoteWebDriver.executeScript("arguments[0].click();", new Object[] { e });
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				appiumDriver = PageBase.appiumDriver;
				appiumDriver.executeScript("arguments[0].click();", new Object[] { e });
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + e + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, String.valueOf(elementName) + " not found",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(String.valueOf(elementName) + " not found");
		}
	}

	public void navigateToToC(String strToCLayer, String strToCItem) {
		try {
			WebElement testElement;
			WebElement testElement1;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				testElement = this.remoteDriver.findElement(By.cssSelector(
						"div[id='tocItemContainer" + strToCLayer + "'] > div > div > div[title='" + strToCItem + "']"));
				if (!testElement.isDisplayed())
					scrollTo((WebDriver) this.remoteDriver, testElement);
				testElement.click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				testElement1 = this.appiumDriver.findElement(By.cssSelector(
						"div[id='tocItemContainer" + strToCLayer + "'] > div > div > div[title='" + strToCItem + "']"));
				if (!testElement1.isDisplayed())
					scrollTo((WebDriver) this.appiumDriver, testElement1);
				testElement1.click();
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<WebElement> getList_ByClassName(WebElement element, String byValue) {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 250L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(element));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) PageBase.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(element));
				break;
			}
		} catch (Exception exception) {
		}
		try {
			if (element.isDisplayed()) {
				List<WebElement> getList = element.findElements(By.className(byValue));
				return getList;
			}
			return null;
		} catch (Exception exc) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> getList_ByXPath(WebElement element, String xPath) {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 250L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(element));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) PageBase.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(element));
				break;
			}
		} catch (Exception exception) {
		}
		try {
			if (element.isDisplayed()) {
				List<WebElement> getList = element.findElements(By.xpath(xPath));
				return getList;
			}
			return null;
		} catch (Exception exc) {
			return null;
		}
	}

	public void takeScreenshot_Native(WebElement ele, String screenshotName) throws IOException {
		if (ele.isDisplayed()) {
			File screen = (File) PageBase.appiumDriver.getScreenshotAs(OutputType.FILE);
			int ImageWidth = ele.getSize().getWidth();
			int ImageHeight = ele.getSize().getHeight();
			org.openqa.selenium.Point point = ele.getLocation();
			int xcord = point.getX();
			int ycord = point.getY();
			BufferedImage img = ImageIO.read(screen);
			BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
			ImageIO.write(dest, "png", screen);
			FileUtils.copyFile(screen, new File("NativeApp_Screenshots/" + screenshotName + ".png"));
		}
	}

	public void scrollTo(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('container id').scrollTop += 250;",
				new Object[] { "" });
	}

	public String getCurrentUrl() throws Exception {
		String url = null;
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				url = this.remoteDriver.getCurrentUrl();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				url = this.appiumDriver.getCurrentUrl();
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on getting Current Url ",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
		return url;
	}

	public String fetchContentFromWebUI(String strCss) throws Exception {
		WebElement element, testElement;
		WebElement element1, testElement1;
		String strText = "";
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			System.out.println("Fetch content from web page");
			element = this.remoteDriver.findElement(By.cssSelector(strCss));
			testElement = this.remoteDriver.findElement(By.cssSelector("p[id^='p26']>span[id='word1']"));
			System.out.println("Font face/family in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-family"));
			assertTrue("Font face/family in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-family"), true);
			System.out.println("Font size in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-size"));
			assertTrue("Font size in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-size"), true);
			strText = element.getText();
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			System.out.println("Fetch content from web page");
			element1 = PageBase.appiumDriver.findElement(By.cssSelector(strCss));
			testElement1 = PageBase.appiumDriver.findElement(By.cssSelector("p[id^='p26']>span[id='word1']"));
			System.out.println("Font face/family in eBook for the text - The Language of Reaching Out: "
					+ testElement1.getCssValue("font-family"));
			assertTrue("Font face/family in eBook for the text - The Language of Reaching Out: "
					+ testElement1.getCssValue("font-family"), true);
			System.out.println("Font size in eBook for the text - The Language of Reaching Out: "
					+ testElement1.getCssValue("font-size"));
			assertTrue("Font size in eBook for the text - The Language of Reaching Out: "
					+ testElement1.getCssValue("font-size"), true);
			strText = element1.getText();
			break;
		}
		return strText;
	}

	public void clickByCSS(String e, String text) throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.findElementByCssSelector(e).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + e + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void clickWithoutWait(WebElement e, String elementName) throws Exception {
		try {
			WebDriverWait wait;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					;
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
			e.click();
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + e + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	@SuppressWarnings("unchecked")
	public void clickWithoutWait(String xpath, String elementName) throws Exception {
		String screenShot = getAppProperties("screenShotRequiredForSuccess");
		try {
			WebDriverWait wait;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				Thread.sleep(3000L);
				this.remoteDriver.findElementByXPath(xpath).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) PageBase.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
				PageBase.appiumDriver.findElementByXPath(xpath).click();
				break;
			}
			System.out.println("Clicking on Element Successful : " + elementName);
			if (screenShot.contains("Y")) {
				ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful");
			}
		} catch (Exception exc) {
			System.out.println("Clicking on Element Failed : " + elementName);
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void clickWithWait(String xpath, String elementName, int seconds) throws Exception {
		this.appiumDriver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
		String screenShot = getAppProperties("screenShotRequiredForSuccess");
		try {
			WebDriverWait wait;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				Thread.sleep(3000L);
				this.remoteDriver.findElementByXPath(xpath).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				Thread.sleep(1000L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
				this.appiumDriver.findElementByXPath(xpath).click();
				Thread.sleep(3000L);
				break;
			}
			System.out.println("Clicking on Element Successful : " + elementName);
			if (screenShot.contains("Y")) {
				ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful");
			}
		} catch (Exception exc) {
			System.out.println("Clicking on Element Failed : " + elementName);
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void clickLinkTest(String xpath, String elementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				this.remoteDriver.findElementByLinkText(xpath).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				appiumDriver.findElementByXPath(xpath).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void click(String xpath, String elementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				this.remoteDriver.findElementByXPath(xpath).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				this.appiumDriver.findElementByXPath(xpath).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void clickbyid(String id, String elementName) throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.findElementById(id).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				PageBase.appiumDriver.findElementById(id).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void clickbyClassName(String className, String elementName) throws Exception {
		try {
			WebDriverWait wait;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.findElementByClassName(className).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) PageBase.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOfElementLocated(By.className(className)));
				PageBase.appiumDriver.findElementByClassName(className).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void clickByElementName(String name, String elementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.elementToBeClickable(By.name(name)));
				this.remoteDriver.findElementByName(name).click();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.elementToBeClickable(By.name(name)));
				appiumDriver.findElementByName(name).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void clickAlert() throws Exception {
		try {
			Alert a2;
			Alert a1;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				a1 = this.remoteDriver.switchTo().alert();
				a1.accept();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				a2 = this.remoteDriver.switchTo().alert();
				a2.accept();
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void dragAndDrop(WebElement e1, WebElement e2) throws Exception {
		try {
			Actions action;
			Actions action1;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				action1 = new Actions((WebDriver) this.remoteDriver);
				action1.dragAndDrop(e1, e2).perform();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				action = new Actions((WebDriver) this.appiumDriver);
				action.dragAndDrop(e1, e2).perform();
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on Drag element",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public String getPageTitle() throws Exception {
		String pageTitle = "";
		if (this.toolName.equalsIgnoreCase("Selenium")) {
			pageTitle = this.remoteDriver.getTitle();
		} else {
			Thread.sleep(5000L);
			pageTitle = this.appiumDriver.getTitle();
		}
		return pageTitle;
	}

	public String getText(WebElement e, String elementName) throws Exception {
		WebDriverWait wait, waitSelenium;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
			waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
			wait.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		}
		String text = e.getText();
		ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return text;
	}

	@SuppressWarnings("rawtypes")
	public String getValue(WebElement e, String elementName) throws Exception {
		WebDriverWait wait, waitSelenium;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
			waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			wait = new WebDriverWait((WebDriver) PageBase.appiumDriver, 60L, 500L);
			wait.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		}
		String text = e.getAttribute("value");
		ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return text;
	}

	public String getText(WebElement e) throws Exception {
		WebDriverWait wait, waitSelenium;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
			waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
			wait.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		}
		String text = e.getText().trim();
		return text;
	}

	@SuppressWarnings("rawtypes")
	public String getText(String xpath) throws Exception {
		WebDriverWait wait;
		RemoteWebDriver remoteWebDriver;
		WebElement element;
		String text = null;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			remoteWebDriver = this.remoteDriver;
			element = this.remoteDriver.findElement(By.xpath(xpath));
			text = remoteWebDriver.executeScript("return arguments[0].text", new Object[] { element }).toString();
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
			wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
			text = this.appiumDriver.findElementByXPath(xpath).getText();
			break;
		}
		return text;
	}

	public String getAttributeValue(WebElement e, String attribute) throws Exception {
		WebDriverWait wait, waitSelenium;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
			waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
			wait.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		}
		String text = e.getAttribute(attribute);
		return text;
	}

	public void clickMultipleButtons(WebElement tab, WebElement pause, String elementName) throws Exception {
		try {
			Thread.sleep(20000L);
			if (elementIsDisplayed(pause, "pausebutton")) {
				pause.click();
			} else {
				tab.click();
				pause.click();
			}
			Thread.sleep(10000L);
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void switchToCurrentWindowTitle() throws InterruptedException {
		try {
			int size;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				for (String winHandle : this.remoteDriver.getWindowHandles()) {
					this.remoteDriver.switchTo().window(winHandle);
					Thread.sleep(5000L);
				}
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				Thread.sleep(10000L);
				size = this.appiumDriver.getWindowHandles().size();
				for (String winHandle : this.appiumDriver.getWindowHandles())
					this.appiumDriver.switchTo().window(winHandle);
				break;
			}
		} catch (NoSuchWindowException exc) {
			exc.printStackTrace();
		}
	}

	public String sendPostRequest(String apiName, String cookie, String payload) {
		StringBuffer jsonString = new StringBuffer();
		try {
			URL url = new URL(
					"https://disneydev7.service-now.com/api/x_wadm_wdpr_cast_c/v1/wdpr_cp_svc_castchoir/" + apiName);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Cookie", cookie);
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null)
				jsonString.append(line);
			br.close();
			connection.disconnect();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return jsonString.toString();
	}

	public StringBuffer getServiceResponse(String serviceUrl) throws Exception {
		String output = null;
		StringBuffer outputResponse = null;
		try {
			Thread.sleep(5000L);
			URL url = new URL(serviceUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("source-appl-id", "6");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Accept-Resolution", "thumb, medium, high");
			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			System.out.println("Response from Server .... \n");
			PrintWriter out = new PrintWriter("Response/response.txt");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				output.contains("mediaThumb");
				output.contains("width");
				output.contains("height");
				out.println(output);
			}
			conn.disconnect();
		} catch (Exception exception) {
		}
		return outputResponse;
	}

	public void switchToWindowTitle() throws Exception {
		try {
			int size;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.ParentWinhadle = this.remoteDriver.getWindowHandle();
				for (String winHandle : this.remoteDriver.getWindowHandles())
					this.remoteDriver.switchTo().window(winHandle);
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				Thread.sleep(10000L);
				size = this.appiumDriver.getWindowHandles().size();
				this.ParentWinhadleMob = this.appiumDriver.getWindowHandle();
				for (String winHandle : this.appiumDriver.getWindowHandles())
					this.appiumDriver.switchTo().window(winHandle);
				break;
			}
		} catch (NoSuchWindowException exc) {
			exc.printStackTrace();
		}
	}

	public void switchToParentWindowTitle() throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.close();
				this.remoteDriver.switchTo().window(this.ParentWinhadle);
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				Thread.sleep(10000L);
				this.appiumDriver.close();
				this.appiumDriver.switchTo().window(this.ParentWinhadleMob);
				break;
			}
		} catch (NoSuchWindowException exc) {
			exc.printStackTrace();
		}
	}

	public void selectOPtionByVisibleText(WebElement e, String text) throws InterruptedException {
		Thread.sleep(5000L);
		e.click();
		Select sl = new Select(e);
		sl.selectByVisibleText(text);
	}

	public void selectOPtionByIndex(WebElement e, int value) throws InterruptedException {
		Thread.sleep(3000L);
		Select sl = new Select(e);
		sl.selectByIndex(value);
	}

	public void switchToFrame(String frameId) throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.switchTo().frame(frameId);
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				Thread.sleep(5000L);
				this.appiumDriver.switchTo().frame(frameId);
				break;
			}
		} catch (NoSuchWindowException exc) {
			exc.printStackTrace();
		}
	}

	public void switchToFrame(int frameId) throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.switchTo().frame(frameId);
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				Thread.sleep(5000L);
				this.appiumDriver.switchTo().frame(frameId);
				break;
			}
		} catch (NoSuchWindowException exc) {
			exc.printStackTrace();
		}
	}

	public void switchToParentFrame() throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.switchTo().parentFrame();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				Thread.sleep(5000L);
				this.appiumDriver.switchTo().parentFrame();
				break;
			}
		} catch (NoSuchWindowException exc) {
			exc.printStackTrace();
		}
	}

	public String getParentWindow() throws Exception {
		String parentWindow = null;
		if (this.toolName.equalsIgnoreCase("Appium")) {
			parentWindow = this.appiumDriver.getWindowHandle();
		} else if (this.toolName.equalsIgnoreCase("Selenium")) {
			parentWindow = this.remoteDriver.getWindowHandle();
		}
		return parentWindow;
	}

	public void switchToParentWindow(String parentWindow) throws Exception {
		if (this.toolName.equalsIgnoreCase("Appium")) {
			this.appiumDriver.close();
			this.appiumDriver.switchTo().window(parentWindow);
		} else if (this.toolName.equalsIgnoreCase("Selenium")) {
			this.remoteDriver.close();
			this.remoteDriver.switchTo().window(parentWindow);
		}
	}

	public WebElement getElement(String xpath) throws Exception {
		try {
			WebElement we;
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			WebElement weSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium
						.until((Function) ExpectedConditions.visibilityOf(this.remoteDriver.findElementByXPath(xpath)));
				weSelenium = this.remoteDriver.findElementByXPath(xpath);
				return weSelenium;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
				we = this.appiumDriver.findElementByXPath(xpath);
				return we;
			}
		} catch (Exception exception) {
		}
		ExtentUtility.getTest().log(LogStatus.FAIL, " Get text on webelement successful",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return null;
	}

	public List<WebElement> getElements(String xpath) throws Exception {
		try {
			List<WebElement> elements;
			WebDriverWait wait;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
				elements = this.appiumDriver.findElementsByXPath(xpath);
				return elements;
			}
		} catch (Exception exception) {
		}
		ExtentUtility.getTest().log(LogStatus.FAIL, " Get text on webelement successful",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return null;
	}

	public boolean verifyText(WebElement e, String value) throws Exception {
		WebDriverWait wait, waitSelenium;
		String str;
		switch ((str = this.toolName).hashCode()) {
		case 1256533886:
			if (!str.equals("Selenium"))
				break;
			waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
			waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		case 1967770400:
			if (!str.equals("Appium"))
				break;
			wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
			wait.until((Function) ExpectedConditions.visibilityOf(e));
			break;
		}
		if (e.getText().contains(value)) {
			ExtentUtility.getTest().log(LogStatus.PASS, "  Verified Element successful ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return true;
		}
		ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Verified webelement",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return false;
	}

	public void enterText(WebElement element, String cred, String elementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(element));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
				break;
			}
			element.clear();
			element.sendKeys(new CharSequence[] { cred });
			ExtentUtility.getTest().log(LogStatus.PASS, " Enter text in " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Enter text failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + " Exception on Verified webelement");
		}
	}

	public void assertTrue(String message) throws Exception {
		String screenShot = getAppProperties("screenShotRequiredForSuccess");
		if (screenShot.contains("Y")) {
			ExtentUtility.getTest().log(LogStatus.PASS, message,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			ExtentUtility.getTest().log(LogStatus.PASS, message);
		}
	}

	public void assertFalse(String message) throws Exception {
		ExtentUtility.getTest().log(LogStatus.FAIL, message,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception(message);
	}

	public boolean navToSubMenu(String subMenu) throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				System.out.println("Navigate to" + subMenu + "menu.");
				this.remoteDriver.findElement(By.cssSelector("div[title='" + subMenu + "']")).click();
				System.out.println("Navigated to sub-menu '" + subMenu + "'");
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				System.out.println("Navigate to" + subMenu + "menu.");
				this.appiumDriver.findElement(By.cssSelector("div[title='" + subMenu + "']")).click();
				System.out.println("Navigated to sub-menu '" + subMenu + "'");
				break;
			}
		} catch (Exception exc) {
			System.out.println("Unable to navigate to the sub menu, due to - " + exc.getMessage());
			exc.printStackTrace();
			return false;
		}
		return true;
	}

	public void switchFrame() {
		if (this.remoteDriver.toString().contains("chrome")) {
			this.remoteDriver.switchTo().frame(2);
		} else {
			this.remoteDriver.switchTo().frame(0);
		}
	}

	public void switchToFrame() {
		System.out.println("remoteDriver.toString()" + this.remoteDriver.toString());
		if (this.remoteDriver.toString().contains("ie")) {
			this.remoteDriver.switchTo().frame(2);
		} else {
			this.remoteDriver.switchTo().frame(0);
		}
	}

	public void clearSystemCache() throws Exception {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.manage().deleteAllCookies();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				this.appiumDriver.manage().deleteAllCookies();
				break;
			}
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Clear Cookies ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + " Clear Cookies ");
		}
	}

	public boolean elementIsDisplayed(WebElement e, String ElementName) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 250L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
			return true;
		} catch (Exception exc) {
			return false;
		}
	}

	public void isDisplayed(WebElement e, String ElementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 30L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, String.valueOf(ElementName) + " is displayed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, exc.toString(),
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public boolean elementIsDisplayed(WebElement e) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 5L, 50L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 5L, 50L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
		} catch (Exception exc) {
			return false;
		}
		return true;
	}

	public boolean elementIsEnabled(WebElement e) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
			return true;
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Get element visibilty failed ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return false;
		}
	}

	public WebElement getElement(String xpath, String ElementName) throws Exception {
		WebElement element = null;
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 30L, 500L);
				waitSelenium
						.until((Function) ExpectedConditions.visibilityOf(this.remoteDriver.findElementByXPath(xpath)));
				if (this.remoteDriver.findElementByXPath(xpath).isDisplayed()) {
					element = this.remoteDriver.findElementByXPath(xpath);
					ExtentUtility.getTest().log(LogStatus.PASS, String.valueOf(ElementName) + " is displayed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
				if (this.appiumDriver.findElementByXPath(xpath).isDisplayed()) {
					element = this.appiumDriver.findElementByXPath(xpath);
					ExtentUtility.getTest().log(LogStatus.PASS, String.valueOf(ElementName) + " is displayed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}
				break;
			}
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Element visibilty failed ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return element;
	}

	public boolean elementIsDisplayed(String xpath, String ElementName) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 30L, 500L);
				waitSelenium
						.until((Function) ExpectedConditions.visibilityOf(this.remoteDriver.findElementByXPath(xpath)));
				if (this.remoteDriver.findElementByXPath(xpath).isDisplayed())
					ExtentUtility.getTest().log(LogStatus.PASS, String.valueOf(ElementName) + " is displayed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
				if (this.appiumDriver.findElementByXPath(xpath).isDisplayed())
					ExtentUtility.getTest().log(LogStatus.PASS, String.valueOf(ElementName) + " is displayed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				break;
			}
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Element visibilty failed ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return false;
		}
		return true;
	}

	public boolean elementIsDisplayed(String xpath) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 30L, 500L);
				waitSelenium
						.until((Function) ExpectedConditions.visibilityOf(this.remoteDriver.findElementByXPath(xpath)));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByXPath(xpath)));
				break;
			}
		} catch (Exception exc) {
			return false;
		}
		return true;
	}

	public boolean elementIsDisplayedByName(String name) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium
						.until((Function) ExpectedConditions.visibilityOf(this.remoteDriver.findElementByName(name)));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 30L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(this.appiumDriver.findElementByName(name)));
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
		return true;
	}

	public void scroll(String key) {
		// Byte code:
		// 0: aload_0
		// 1: getfield toolName : Ljava/lang/String;
		// 4: dup
		// 5: astore_2
		// 6: invokevirtual hashCode : ()I
		// 9: lookupswitch default -> 298, 1256533886 -> 36, 1967770400 -> 48
		// 36: aload_2
		// 37: ldc 'Selenium'
		// 39: invokevirtual equals : (Ljava/lang/Object;)Z
		// 42: ifne -> 179
		// 45: goto -> 298
		// 48: aload_2
		// 49: ldc 'Appium'
		// 51: invokevirtual equals : (Ljava/lang/Object;)Z
		// 54: ifne -> 60
		// 57: goto -> 298
		// 60: iconst_0
		// 61: istore_3
		// 62: iconst_0
		// 63: istore #4
		// 65: aload_0
		// 66: getfield appiumDriver : Lio/appium/java_client/AppiumDriver;
		// 69: new java/lang/StringBuilder
		// 72: dup
		// 73: ldc_w 'dropdownViewCell_'
		// 76: invokespecial <init> : (Ljava/lang/String;)V
		// 79: iload_3
		// 80: invokevirtual append : (I)Ljava/lang/StringBuilder;
		// 83: invokevirtual toString : ()Ljava/lang/String;
		// 86: invokestatic name : (Ljava/lang/String;)Lorg/openqa/selenium/By;
		// 89: invokevirtual findElements : (Lorg/openqa/selenium/By;)Ljava/util/List;
		// 92: astore #5
		// 94: aload #5
		// 96: invokeinterface size : ()I
		// 101: ifne -> 104
		// 104: aload #5
		// 106: invokeinterface iterator : ()Ljava/util/Iterator;
		// 111: astore #7
		// 113: goto -> 155
		// 116: aload #7
		// 118: invokeinterface next : ()Ljava/lang/Object;
		// 123: checkcast org/openqa/selenium/WebElement
		// 126: astore #6
		// 128: aload #6
		// 130: invokeinterface getText : ()Ljava/lang/String;
		// 135: aload_1
		// 136: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
		// 139: ifeq -> 155
		// 142: aload #6
		// 144: invokeinterface click : ()V
		// 149: iconst_1
		// 150: istore #4
		// 152: goto -> 165
		// 155: aload #7
		// 157: invokeinterface hasNext : ()Z
		// 162: ifne -> 116
		// 165: iload #4
		// 167: ifeq -> 173
		// 170: goto -> 179
		// 173: iinc #3, 1
		// 176: goto -> 62
		// 179: iconst_0
		// 180: istore_3
		// 181: iconst_0
		// 182: istore #4
		// 184: aload_0
		// 185: getfield remoteDriver : Lorg/openqa/selenium/remote/RemoteWebDriver;
		// 188: new java/lang/StringBuilder
		// 191: dup
		// 192: ldc_w 'dropdownViewCell_'
		// 195: invokespecial <init> : (Ljava/lang/String;)V
		// 198: iload_3
		// 199: invokevirtual append : (I)Ljava/lang/StringBuilder;
		// 202: invokevirtual toString : ()Ljava/lang/String;
		// 205: invokestatic name : (Ljava/lang/String;)Lorg/openqa/selenium/By;
		// 208: invokevirtual findElements : (Lorg/openqa/selenium/By;)Ljava/util/List;
		// 211: astore #5
		// 213: aload #5
		// 215: invokeinterface size : ()I
		// 220: ifne -> 223
		// 223: aload #5
		// 225: invokeinterface iterator : ()Ljava/util/Iterator;
		// 230: astore #7
		// 232: goto -> 274
		// 235: aload #7
		// 237: invokeinterface next : ()Ljava/lang/Object;
		// 242: checkcast org/openqa/selenium/WebElement
		// 245: astore #6
		// 247: aload #6
		// 249: invokeinterface getText : ()Ljava/lang/String;
		// 254: aload_1
		// 255: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
		// 258: ifeq -> 274
		// 261: aload #6
		// 263: invokeinterface click : ()V
		// 268: iconst_1
		// 269: istore #4
		// 271: goto -> 284
		// 274: aload #7
		// 276: invokeinterface hasNext : ()Z
		// 281: ifne -> 235
		// 284: iload #4
		// 286: ifeq -> 292
		// 289: goto -> 298
		// 292: iinc #3, 1
		// 295: goto -> 181
		// 298: return
		// Line number table:
		// Java source line number -> byte code offset
		// #2484 -> 0
		// #2486 -> 60
		// #2487 -> 62
		// #2489 -> 65
		// #2490 -> 94
		// #2493 -> 104
		// #2495 -> 128
		// #2496 -> 142
		// #2497 -> 149
		// #2498 -> 152
		// #2493 -> 155
		// #2502 -> 165
		// #2503 -> 170
		// #2486 -> 173
		// #2508 -> 179
		// #2509 -> 181
		// #2511 -> 184
		// #2512 -> 213
		// #2515 -> 223
		// #2517 -> 247
		// #2518 -> 261
		// #2519 -> 268
		// #2520 -> 271
		// #2515 -> 274
		// #2524 -> 284
		// #2525 -> 289
		// #2508 -> 292
		// #2531 -> 298
		// Local variable table:
		// start length slot name descriptor
		// 0 299 0 this Lcom/mop/qa/testbase/PageBase;
		// 0 299 1 key Ljava/lang/String;
		// 62 117 3 i I
		// 65 108 4 shouldBreak Z
		// 94 79 5 listObject Ljava/util/List;
		// 128 27 6 wb Lorg/openqa/selenium/WebElement;
		// 181 117 3 i I
		// 184 108 4 shouldBreak Z
		// 213 79 5 listObject Ljava/util/List;
		// 247 27 6 wb Lorg/openqa/selenium/WebElement;
		// Local variable type table:
		// start length slot name signature
		// 94 79 5 listObject Ljava/util/List<Lorg/openqa/selenium/WebElement;>;
		// 213 79 5 listObject Ljava/util/List<Lorg/openqa/selenium/WebElement;>;
	}

	public static void tapBack(AppiumDriver driver) {
		driver.navigate().back();
	}

	public void clickCoordinates(int x, int y) {
		String str;
		switch ((str = this.toolName).hashCode()) {
		case 1256533886:
			if (!str.equals("Selenium"))
				break;
			this.remoteDriver.executeScript("mobile: tap", new Object[] { new HashMap<String, Integer>(x, y) {

			} });
			break;
		case 1967770400:
			if (!str.equals("Appium"))
				break;
			this.appiumDriver.executeScript("mobile: tap", new Object[] { new HashMap<String, Integer>(x, y) {

			} });
			break;
		}

	}

	public void keyBoardActions(String text) {
		// Byte code:
		// 0: aload_0
		// 1: getfield toolName : Ljava/lang/String;
		// 4: dup
		// 5: astore_2
		// 6: invokevirtual hashCode : ()I
		// 9: lookupswitch default -> 192, 1256533886 -> 36, 1967770400 -> 48
		// 36: aload_2
		// 37: ldc 'Selenium'
		// 39: invokevirtual equals : (Ljava/lang/Object;)Z
		// 42: ifne -> 126
		// 45: goto -> 192
		// 48: aload_2
		// 49: ldc 'Appium'
		// 51: invokevirtual equals : (Ljava/lang/Object;)Z
		// 54: ifne -> 60
		// 57: goto -> 192
		// 60: aload_1
		// 61: ldc_w 'return'
		// 64: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
		// 67: ifeq -> 86
		// 70: aload_0
		// 71: getfield appiumDriver : Lio/appium/java_client/AppiumDriver;
		// 74: aload_1
		// 75: invokevirtual findElementByName :
		// (Ljava/lang/String;)Lorg/openqa/selenium/WebElement;
		// 78: invokeinterface click : ()V
		// 83: goto -> 126
		// 86: iconst_0
		// 87: istore_3
		// 88: goto -> 118
		// 91: aload_1
		// 92: iload_3
		// 93: iload_3
		// 94: iconst_1
		// 95: iadd
		// 96: invokevirtual substring : (II)Ljava/lang/String;
		// 99: astore #4
		// 101: aload_0
		// 102: getfield appiumDriver : Lio/appium/java_client/AppiumDriver;
		// 105: aload #4
		// 107: invokevirtual findElementByName :
		// (Ljava/lang/String;)Lorg/openqa/selenium/WebElement;
		// 110: invokeinterface click : ()V
		// 115: iinc #3, 1
		// 118: iload_3
		// 119: aload_1
		// 120: invokevirtual length : ()I
		// 123: if_icmplt -> 91
		// 126: aload_1
		// 127: ldc_w 'return'
		// 130: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
		// 133: ifeq -> 152
		// 136: aload_0
		// 137: getfield remoteDriver : Lorg/openqa/selenium/remote/RemoteWebDriver;
		// 140: aload_1
		// 141: invokevirtual findElementByName :
		// (Ljava/lang/String;)Lorg/openqa/selenium/WebElement;
		// 144: invokeinterface click : ()V
		// 149: goto -> 192
		// 152: iconst_0
		// 153: istore_3
		// 154: goto -> 184
		// 157: aload_1
		// 158: iload_3
		// 159: iload_3
		// 160: iconst_1
		// 161: iadd
		// 162: invokevirtual substring : (II)Ljava/lang/String;
		// 165: astore #4
		// 167: aload_0
		// 168: getfield remoteDriver : Lorg/openqa/selenium/remote/RemoteWebDriver;
		// 171: aload #4
		// 173: invokevirtual findElementByName :
		// (Ljava/lang/String;)Lorg/openqa/selenium/WebElement;
		// 176: invokeinterface click : ()V
		// 181: iinc #3, 1
		// 184: iload_3
		// 185: aload_1
		// 186: invokevirtual length : ()I
		// 189: if_icmplt -> 157
		// 192: return
		// Line number table:
		// Java source line number -> byte code offset
		// #2566 -> 0
		// #2568 -> 60
		// #2569 -> 70
		// #2571 -> 86
		// #2572 -> 91
		// #2573 -> 101
		// #2571 -> 115
		// #2577 -> 126
		// #2578 -> 136
		// #2580 -> 152
		// #2581 -> 157
		// #2582 -> 167
		// #2580 -> 181
		// #2587 -> 192
		// Local variable table:
		// start length slot name descriptor
		// 0 193 0 this Lcom/mop/qa/testbase/PageBase;
		// 0 193 1 text Ljava/lang/String;
		// 88 38 3 i I
		// 101 14 4 alp Ljava/lang/String;
		// 154 38 3 i I
		// 167 14 4 alp Ljava/lang/String;
	}

	public void scrollDown(WebElement key) throws Exception {
		Map<String, Object> args = new HashMap<>();
		args.put("direction", "down");
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
		args.put("direction", "down");
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	public void singleScrollDown() throws Exception {
		boolean flag = false;
		while (!flag) {
			Map<String, Object> args = new HashMap<>();
			args.put("direction", "down");
			this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
		}
	}

	public static void swipeDown() throws Exception {
		Map<String, Object> args = new HashMap<>();
		args.put("direction", "down");
		appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	public void swipeUp() throws Exception {
		Map<String, Object> args = new HashMap<>();
		args.put("direction", "up");
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	public void swipeLeft(WebElement key) throws Exception {
		Map<String, Object> args = new HashMap<>();
		args.put("direction", "left");
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
		args.put("direction", "left");
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	public static void swipeLeft() throws Exception {
		Map<String, Object> args = new HashMap<>();
		args.put("direction", "left");
		appiumDriver.executeScript("mobile: swipe", new Object[] { args });
		args.put("direction", "left");
		appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	public void singleSwipeLeft() throws Exception {
		Map<String, Object> args = new HashMap<>();
		/*if (locality_value.equalsIgnoreCase("Cloud")) {
			args.put("direction", "right");
		} else*/ {
			args.put("direction", "left");
		}
		appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	public void swipeRight(WebElement key) throws Exception {
		Map<String, Object> args = new HashMap<>();
		args.put("direction", "right");
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
		args.put("direction", "right");
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	public void singleSwipeRight() throws Exception {
		Map<String, Object> args = new HashMap<>();
		/*if (locality_value.equalsIgnoreCase("Cloud")) {
			args.put("direction", "left");
		} else */{
			args.put("direction", "right");
		}
		this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
	}

	

	public void swipeDownNVerify(String elementToBeDisplayed) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int startPos = 600;
		int endPos = -10000;
		for (int i = 0; i <= 20; i++) {
			/*
			 * if (locality_value.equalsIgnoreCase("Cloud")) { swipeUp(); } else {
			 */ action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
					.moveTo(PointOption.point(0, endPos)).release().perform();

			if (isElementDisplayed(2, elementToBeDisplayed, "Swipe down : " + elementToBeDisplayed) && i >= 1)
				break;
		}
	}

	public void swipeDownForNTimesVerify(String elementToBeDisplayed, int noOfSwipe) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int startPos = 600;
		int endPos = -10000;
		for (int i = 0; i <= 20; i++) {
			/*
			 * if (locality_value.equalsIgnoreCase("Cloud")) { swipeUp(); } else {
			 */ action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
					.moveTo(PointOption.point(0, endPos)).release().perform();
			// }
			if (isElementDisplayed(2, elementToBeDisplayed, "Swipe down : " + elementToBeDisplayed) && i >= noOfSwipe)
				break;
		}

	}

	public void swipeDownForNTimes(int noOfSwipe) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int startPos = 600;
		int endPos = -10000;
		for (int i = 0; i < noOfSwipe; i++) {
			action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
					.moveTo(PointOption.point(0, endPos)).release().perform();
		}
	}

	public static void swipeMobile(AppiumDriver driver) {
		Dimension size = driver.manage().window().getSize();
		System.out.println(String.valueOf(size.height) + "height");
		System.out.println(String.valueOf(size.width) + "width");
		System.out.println(size);
		int startPoint = size.width / 2;
		int endPoint = (int) (size.width * 0.13D);
		int ScreenPlace = (int) (size.height * 0.4D);
		int y = (int) (size.height * 0.7D);
		TouchAction ts = new TouchAction((PerformsTouchActions) driver);
		ts.longPress(PointOption.point(40, 96)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000L)))
				.moveTo(PointOption.point(64, 1317)).release().perform();
	}

	public void scrollToExact(WebElement key) throws Exception {
		try {
			Map<String, Object> args;
			boolean flag = false;
			int count = 0;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					;
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				args = new HashMap<>();
				while (!flag && count <= 6) {
					args.put("direction", "down");
					this.appiumDriver.executeScript("mobile: swipe", new Object[] { args });
					count++;
					if (elementIsDisplayed(key)) {
						flag = true;
						break;
					}
				}
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Scroll to Element Successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on scroll to element" + key);
		}
	}

	public void scrollPage(WebElement key) throws Exception {
		try {
			Actions action;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					;
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				action = new Actions((WebDriver) this.appiumDriver);
				action.moveToElement(key).build().perform();
				break;
			}
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Exception on scroll to element ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Get element visibilty failed ");
		}
	}

	public void accessNotification() {
		AndroidDriver android = (AndroidDriver) this.appiumDriver;
		android.openNotifications();
	}

	public void keyboardActions(WebElement e, Keys key) {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 60L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				waitSelenium.until((Function) ExpectedConditions.elementToBeClickable(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
			e.sendKeys(new CharSequence[] { (CharSequence) key });
		} catch (Exception exception) {
		}
	}

	public void dragAndDropElement(String dragFromXpath, String dragToXpath, int xOffset, int yOffset)
			throws Exception {
		WebElement dragFrom = this.remoteDriver.findElementByXPath(dragFromXpath);
		WebElement dragTo = this.remoteDriver.findElementByXPath(dragToXpath);
		System.out.println(
				"dragFrom =" + dragFrom + " dragTo = " + dragTo + "xOffset = " + xOffset + " yOffset =" + yOffset);
		Robot robot = new Robot();
		robot.setAutoDelay(500);
		robot.mouseMove(200, 200);
		robot.mousePress(16);
		Dimension fromSize = dragFrom.getSize();
		Dimension toSize = dragTo.getSize();
		int xCentreFrom = fromSize.width / 2;
		int yCentreFrom = fromSize.height / 2;
		int xCentreTo = toSize.width / 2;
		int yCentreTo = toSize.height / 2;
		org.openqa.selenium.Point toLocation = dragTo.getLocation();
		org.openqa.selenium.Point fromLocation = dragFrom.getLocation();
		System.out.println(fromLocation.toString());
		toLocation.x += xOffset + xCentreTo;
		toLocation.y += yOffset + yCentreTo;
		fromLocation.x += xOffset + xCentreFrom;
		fromLocation.y += yOffset + yCentreFrom;
		System.out.println(fromLocation.toString());
		robot.mouseMove(fromLocation.x, fromLocation.y);
		robot.mousePress(16);
		robot.mouseMove((toLocation.x - fromLocation.x) / 2 + fromLocation.x,
				(toLocation.y - fromLocation.y) / 2 + fromLocation.y);
		for (double i = (toLocation.x / 2); i < toLocation.x;) {
			robot.mouseMove((int) i, toLocation.y);
			i += 10.0D;
		}
		robot.mouseRelease(16);
		ExtentUtility.getTest().log(LogStatus.PASS, " Drag element successful",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	}

	public void scrollTo(String xpath, String element) throws Exception {
		try {
			this.remoteDriver.executeScript("arguments[0].scrollIntoView();",
					new Object[] { this.remoteDriver.findElement(By.xpath(xpath)) });
			ExtentUtility.getTest().log(LogStatus.PASS, "Scroll to element " + element + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element" + element,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on scroll to element" + element);
		}
	}

	public void scrollTo(WebElement e, String element) throws Exception {
		try {
			this.remoteDriver.executeScript("arguments[0].scrollIntoView();", new Object[] { e });
			ExtentUtility.getTest().log(LogStatus.PASS, "Scroll to element " + element + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element" + element,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on scroll to element" + element);
		}
	}

	public void moveToElement(String xpath1, String xpath2, String elementName) throws Exception {
		try {
			Actions actions;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				actions = new Actions((WebDriver) this.remoteDriver);
				actions.moveToElement(this.remoteDriver.findElementByXPath(xpath1))
						.moveToElement(this.remoteDriver.findElementByXPath(xpath2)).build().perform();
				actions.click().build().perform();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				actions = new Actions((WebDriver) this.appiumDriver);
				actions.moveToElement(this.appiumDriver.findElementByXPath(xpath1)).build().perform();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Move to element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Move to element" + elementName,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on Move to element" + elementName);
		}
	}

	public void moveToElement(WebElement element, String elementName) throws Exception {
		try {
			Actions actions;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				actions = new Actions((WebDriver) this.remoteDriver);
				actions.moveToElement(element).build().perform();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				actions = new Actions((WebDriver) this.appiumDriver);
				actions.moveToElement(element).build().perform();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Move to element " + element + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Move to element" + elementName,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on Move to element" + elementName);
		}
	}

	public void assertTrue(String msg, boolean cond) throws Exception {
		String screenShot = getAppProperties("screenShotRequiredForSuccess");
		System.out.println(msg);
		if (cond) {
			if (screenShot.contains("Y")) {
				ExtentUtility.getTest().log(LogStatus.PASS, msg,
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				ExtentUtility.getTest().log(LogStatus.PASS, msg);
			}
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, msg,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(msg);
		}
	}

	public void assertTrue(boolean condition, String message) throws Exception {
		String screenShot = getAppProperties("screenShotRequiredForSuccess");
		System.out.println(message);
		if (condition) {
			if (screenShot.contains("Y")) {
				ExtentUtility.getTest().log(LogStatus.PASS, message,
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				ExtentUtility.getTest().log(LogStatus.PASS, message);
			}
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, message,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void assertFalse(boolean condition, String message) throws Exception {
		String screenShot = getAppProperties("screenShotRequiredForSuccess");
		System.out.println(message);
		if (!condition) {
			if (screenShot.contains("Y")) {
				ExtentUtility.getTest().log(LogStatus.PASS, message,
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				ExtentUtility.getTest().log(LogStatus.PASS, message);
			}
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, message,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}

	public void assertEquals(String message, Object expected, Object actual) throws Exception {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual))
			return;
		ExtentUtility.getTest().log(LogStatus.FAIL,
				"Strings are not matched...Excepted is :" + expected + " but actual is :" + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception("Strings are not matched...Excepted is :" + expected + " but actual is :" + actual);
	}

	public void assertEquals(String expected, String actual) throws Exception {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual))
			return;
		ExtentUtility.getTest().log(LogStatus.FAIL,
				"Strings are not matched...Excepted is :" + expected + " but actual is :" + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception("Strings are not matched...Excepted is :" + expected + " but actual is :" + actual);
	}

	public void assertEquals(String message, String expected, String actual) throws Exception {
		if (expected == null && actual == null) {
			ExtentUtility
					.getTest().log(
							LogStatus.PASS, String.valueOf(message) + "...Excepted is :" + expected + " and actual is :"
									+ actual + " is displayed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return;
		}
		if (expected != null && expected.equals(actual)) {
			ExtentUtility
					.getTest().log(
							LogStatus.PASS, String.valueOf(message) + "...Excepted is :" + expected + " and actual is :"
									+ actual + " is displayed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return;
		}
		ExtentUtility.getTest().log(LogStatus.FAIL,
				"Strings are not matched...Excepted is :" + expected + " but actual is :" + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception("Strings are not matched...Excepted is :" + expected + " but actual is :" + actual);
	}

	public void assertEquals(String message, double expected, double actual, double delta) throws Exception {
		if (Double.compare(expected, actual) == 0)
			return;
		if (Math.abs(expected - actual) > delta) {
			ExtentUtility.getTest().log(LogStatus.FAIL, String.valueOf(message) + actual,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}

	public void clickEscape() {
		Actions action = new Actions((WebDriver) this.remoteDriver);
		action.sendKeys(new CharSequence[] { (CharSequence) Keys.ESCAPE });
	}

	public void assertEquals(String message, long expected, long actual) throws Exception {
		if (new Long(expected) != null && (new Long(expected)).equals(new Long(actual)))
			return;
		ExtentUtility.getTest().log(LogStatus.FAIL, String.valueOf(message) + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception(message);
	}

	public void waitForPageLoad() {
		WebDriverWait wait;
		WebDriverWait wait1;
		String str;
		switch ((str = this.toolName).hashCode()) {
		case 1256533886:
			if (!str.equals("Selenium"))
				break;
			wait1 = new WebDriverWait((WebDriver) this.remoteDriver, 900L);
			wait1.until((Function) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					return Boolean.valueOf(PageBase.this.remoteDriver
							.executeScript("return document.readyState", new Object[0]).equals("complete"));
				}
			});
			break;
		case 1967770400:
			if (!str.equals("Appium"))
				break;
			wait = new WebDriverWait((WebDriver) this.appiumDriver, 900L);
			wait.until((Function) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					return Boolean.valueOf(PageBase.this.appiumDriver
							.executeScript("return document.readyState", new Object[0]).equals("complete"));
				}
			});
			break;
		}
	}

	public void waitFor(int wait_time) throws InterruptedException {
		Thread.sleep((wait_time * 1000));
	}

	public void waitForVisibilityOfElement(WebElement e) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 100L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on waiting for webelement",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on waiting for webelement");
		}
	}

	public void waitForInvisibilityOfElement(String xpath) throws Exception {
		try {
			WebDriverWait wait;
			WebDriverWait waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 100L, 500L);
				waitSelenium.until((Function) ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 60L, 500L);
				wait.until((Function) ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on waiting for webelement",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on waiting for webelement");
		}
	}

	public void doubleClickOnString(WebElement element, String strNextWord) throws AWTException {
		RemoteWebDriver remoteWebDriver;
		AppiumDriver appiumDriver = null;
		JavascriptExecutor js = null;
		String JS_GET_WORD_RECT = "var ele=arguments[0], word=arguments[1], rg=document.createRange();   for(var c=ele.firstChild, i; c; c=c.nextSibling){                       if(c.nodeType != 3 || (i=c.nodeValue.indexOf(word)) < 0) continue;    rg.setStart(c, i); rg.setEnd(c, i + word.length);                     var r = ele.getBoundingClientRect(), rr = rg.getClientRects()[0];     return { left: (rr.left-r.left) | 0, top: (rr.top-r.top) | 0,                  width: rr.width | 0, height: rr.height | 0 };              };";
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			remoteWebDriver = this.remoteDriver;
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			appiumDriver = this.appiumDriver;
			break;
		}
		Map rect = (Map) appiumDriver.executeScript(
				"var ele=arguments[0], word=arguments[1], rg=document.createRange();   for(var c=ele.firstChild, i; c; c=c.nextSibling){                       if(c.nodeType != 3 || (i=c.nodeValue.indexOf(word)) < 0) continue;    rg.setStart(c, i); rg.setEnd(c, i + word.length);                     var r = ele.getBoundingClientRect(), rr = rg.getClientRects()[0];     return { left: (rr.left-r.left) | 0, top: (rr.top-r.top) | 0,                  width: rr.width | 0, height: rr.height | 0 };              };",
				new Object[] { element, strNextWord });
		Long offset_x = Long
				.valueOf(((Long) rect.get("left")).longValue() - ((Long) rect.get("width")).longValue() / 2L);
		Long offset_y = Long
				.valueOf(((Long) rect.get("top")).longValue() + ((Long) rect.get("height")).longValue() / 2L);
		System.out.println(offset_x.intValue());
		System.out.println(offset_y.intValue());
		String str2;
		switch ((str2 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str2.equals("Selenium"))
				break;
			(new Actions((WebDriver) this.remoteDriver))
					.moveToElement(element, offset_x.intValue(), offset_y.intValue()).doubleClick().perform();
			break;
		case 1967770400:
			if (!str2.equals("Appium"))
				break;
			System.out.println("before press");
			(new Actions((WebDriver) this.appiumDriver))
					.moveToElement(element, offset_x.intValue(), offset_y.intValue()).doubleClick().build().perform();
			System.out.println("after press");
			break;
		}
	}

	public void waitForAjax(int timeoutInSeconds) {
		try {
			if (this.remoteDriver instanceof JavascriptExecutor) {
				RemoteWebDriver remoteWebDriver = this.remoteDriver;
				Boolean ajaxCondtn = Boolean.valueOf(false);
				for (int i = 0; i < timeoutInSeconds; i++) {
					for (int j = 0; j < 20; j++) {
						try {
							ajaxCondtn = (Boolean) remoteWebDriver.executeScript("return window.jQuery != undefined",
									new Object[0]);
							if (ajaxCondtn.booleanValue())
								break;
							Thread.sleep(1000L);
						} catch (Exception exception) {
						}
					}
					if (ajaxCondtn.booleanValue()) {
						Object numberOfAjaxConnections = remoteWebDriver.executeScript("return jQuery.active",
								new Object[0]);
						if (numberOfAjaxConnections instanceof Long) {
							Long n = (Long) numberOfAjaxConnections;
							if (n.longValue() == 0L)
								break;
						}
						Thread.sleep(1000L);
					}
				}
			} else {
				System.out.println("Web driver: " + this.remoteDriver + " cannot execute javascript");
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public void WaitForAjax() throws InterruptedException {
		Thread.sleep(3000L);
		RemoteWebDriver remoteWebDriver = this.remoteDriver;
		if (((Boolean) remoteWebDriver.executeScript("return window.jQuery != undefined", new Object[0]))
				.booleanValue())
			while (!((Boolean) remoteWebDriver.executeScript("return jQuery.active == 0", new Object[0]))
					.booleanValue())
				Thread.sleep(1000L);
	}

	public void scrollToAnElementByText(AppiumDriver<WebElement> driver, String text) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
	}

	private boolean isElementPresent(WebElement text) {
		return false;
	}

	public void clickBackButton() {
		((AndroidDriver) this.appiumDriver).pressKeyCode(4);
	}

	public void scroll(int fromX, int fromY, int toX, int toY) {
		TouchAction touchAction = new TouchAction((PerformsTouchActions) this.appiumDriver);
	}

	public void scrollUp(WebElement element) throws Exception {
		boolean flag = false;
		int i = 0;
		int pressX = (this.appiumDriver.manage().window().getSize()).width / 2;
		int bottomY = (this.appiumDriver.manage().window().getSize()).height * 4 / 5;
		int topY = (this.appiumDriver.manage().window().getSize()).height / 8;
		while (!flag && i <= 5) {
			scroll(pressX, bottomY, pressX, topY);
			i = i++;
			if (elementIsDisplayed(element))
				flag = true;
		}
	}

	public void scroll1(int fromX, int fromY, int toX, int toY) {
		TouchAction touchAction = new TouchAction((PerformsTouchActions) this.appiumDriver);
	}

	public void scrollDownAndroid(int durationInMs) throws Exception {
		Dimension size = this.appiumDriver.manage().window().getSize();
		System.out.println(size);
		int starty = (int) (size.height * 0.5D);
		int endy = (int) (size.height * 0.2D);
		int startx = size.width / 2;
		scroll(startx, endy, startx, starty);
		scroll(startx, endy, startx, starty);
		scroll(startx, endy, startx, starty);
	}

	public void rightLeftSwipe(int durationInMs) throws Exception {
		Dimension size = this.appiumDriver.manage().window().getSize();
		System.out.println(size);
		int startx = (int) (size.width * 0.9D);
		int endx = (int) (size.width * 0.3D);
		int starty = size.height / 2;
		scroll(startx, starty, endx, starty);
		scroll(startx, starty, endx, starty);
		scroll(startx, starty, endx, starty);
		scroll(startx, starty, endx, starty);
		scroll(startx, starty, endx, starty);
		scroll(startx, starty, endx, starty);
	}

	public void leftRightSwipe(int durationInMs) throws Exception {
		Dimension size = this.appiumDriver.manage().window().getSize();
		System.out.println(size);
		int startx = (int) (size.width * 0.7D);
		int endx = (int) (size.width * 0.3D);
		int starty = size.height / 2;
		scroll(endx, starty, startx, starty);
	}

	public static void swipeHorizontal(AppiumDriver<WebElement> driver) throws Exception {
		AppiumDriver<WebElement> appiumDriver = driver;
		appiumDriver.executeScript("window.scrollBy(0,50)", new Object[] { "" });
		appiumDriver.executeScript("window.scrollBy(0,-50)", new Object[] { "" });
		appiumDriver.executeScript("window.scrollBy(50,0)", new Object[] { "" });
		appiumDriver.executeScript("window.scrollBy(-50,0)", new Object[] { "" });
	}

	public static void swipeLeftOrRight(AppiumDriver driver, String someDirection, int numberOfSwipes) {
		Dimension windowSize = driver.manage().window().getSize();
		System.out.println("Window dimensions: " + windowSize);
		int widthX = windowSize.getWidth();
		System.out.println("Width: " + widthX);
		int heightY = windowSize.getHeight();
		System.out.println("Height: " + heightY);
		Float percentage = null;
		percentage = Float.valueOf((9000 / widthX));
		System.out.println("90% of screen width equals: " + percentage + " in X pixel coordinate");
		float fromX = (widthX - 30);
		float toX = percentage.floatValue();
		if (someDirection.contains("left")) {
			fromX = widthX;
			toX = percentage.floatValue();
		}
		if (someDirection.contains("right")) {
			fromX = percentage.floatValue();
			toX = widthX;
		}
		AppiumDriver appiumDriver = driver;
		System.out.println("Trying to swipe " + someDirection);
		for (int i = 0; i < numberOfSwipes; i++) {
			Map<String, Object> params = new HashMap<>();
			params.put("duration", Double.valueOf(0.25D));
			params.put("fromX", Float.valueOf(fromX));
			params.put("fromY", Integer.valueOf(heightY / 2));
			params.put("toX", Float.valueOf(toX));
			params.put("toY", Integer.valueOf(heightY / 2));
			appiumDriver.executeScript("mobile: dragFromToForDuration", new Object[] { params });
			System.out.println("We think we swiped " + someDirection + " " + i + " of " + numberOfSwipes + " times.");
		}
	}

	public WebElement check_AccessibilityElementPresent(String strElement, String updateLog) throws IOException {
		try {
			if (this.appiumDriver.findElementByAccessibilityId(strElement) != null)
				return this.appiumDriver.findElementByAccessibilityId(strElement);
			return null;
		} catch (Exception E) {
			System.out.println(E.toString());
			return null;
		}
	}

	public void click_mobiletap_coordinates(int x, int y) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
	}

	public void click_mobiletap_coordinates1(int x, int y) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
	}

	public void Page(WebElement e, String elementName) throws Exception {
		try {
			WebDriverWait wait, waitSelenium;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				waitSelenium = new WebDriverWait((WebDriver) this.remoteDriver, 80L, 500L);
				waitSelenium.until((Function) ExpectedConditions.visibilityOf(e));
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				wait = new WebDriverWait((WebDriver) this.appiumDriver, 80L, 500L);
				wait.until((Function) ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(e)));
				break;
			}
			e.getText();
			System.out.println("-----" + e.getText());
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Verify AFL App -" + elementName + " : " + e.getText() + " is displayed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			System.out.println("Page is not displayed");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Verify AFL App -" + elementName + " not found",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(String.valueOf(elementName) + " not found");
		}
	}

	public boolean waitUntilAccessiblityID_InVisible(String element, int Milliseconds) {
		boolean present = false;
		for (int i = 0; isAccessibilityElementPresent(element); i++) {
			if (i >= Milliseconds) {
				present = true;
				return present;
			}
		}
		return present;
	}

	public boolean isAccessibilityElementPresent(String strElement) {
		try {
			return this.appiumDriver.findElementByAccessibilityId(strElement).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public WebElement waitUntil_AccessibilityIdVisible(String strElement, int Milliseconds, String elementName)
			throws Exception {
		WebElement element = null;
		for (int i = 0; element == null; i++) {
			element = chkisAccessibilityElementPresent(strElement);
			if (i > Milliseconds) {
				element = null;
				if (!elementName.equals(""))
					;
				break;
			}
		}
		return element;
	}

	public WebElement chkisAccessibilityElementPresent(String strElement) {
		try {
			WebElement element = this.appiumDriver.findElementByAccessibilityId(strElement);
			if (element.isDisplayed())
				return element;
			return null;
		} catch (Exception E) {
			return null;
		}
	}

	public WebElement chkElement_ByAccessibilityId(String accId, int accId_Index) {
		try {
			List<WebElement> getaccId_List = this.appiumDriver.findElementsByAccessibilityId(accId);
			if (getaccId_List != null) {
				if (getaccId_List.size() >= 0)
					return getaccId_List.get(accId_Index);
				ExtentUtility.getTest().log(LogStatus.FAIL, "Trying to access Out of Index " + accId,
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				return null;
			}
			ExtentUtility.getTest().log(LogStatus.FAIL, "No items available in the list" + accId,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public static Mat image = null;

	public static Mat image1 = null;

	public static Mat image2 = null;

	public void Match(Mat img2, Point location, Dimension size) throws IOException, InterruptedException {
		int l = 0, k = 0;
		int match = 0;
		img2 = Imgcodecs.imread("Errors/Black.png", 1);
		for (k = 0; k < 10; k++) {
			System.out.println("the function");
			String filename = "Errors/error1.png";
			File src = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			System.out.println(filename);
			Thread.sleep(2000L);
			Mat img1 = Imgcodecs.imread(filename, 1);
			System.out.println("face detect");
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 100);
			double right = (location.x + size.getWidth() - 130);
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img = new Mat(img1, faceDetections);
			filename = "Errors/match1.png";
			Imgcodecs.imwrite("Errors/match1.png", img);
			Mat img3 = Imgcodecs.imread("Errors/error.png", 1);
			FeatureDetector fd = FeatureDetector.create(11);
			MatOfKeyPoint keyPointsLarge = new MatOfKeyPoint();
			MatOfKeyPoint keyPointsSmall = new MatOfKeyPoint();
			fd.detect(img3, keyPointsLarge);
			fd.detect(img2, keyPointsSmall);
			Mat descriptorsLarge = new Mat();
			Mat descriptorsSmall = new Mat();
			DescriptorExtractor extractor = DescriptorExtractor.create(5);
			extractor.compute(img3, keyPointsLarge, descriptorsLarge);
			extractor.compute(img2, keyPointsSmall, descriptorsSmall);
			MatOfDMatch matches = new MatOfDMatch();
			DescriptorMatcher matcher = DescriptorMatcher.create(5);
			matcher.match(descriptorsLarge, descriptorsSmall, matches);
			MatOfDMatch matchesFiltered = new MatOfDMatch();
			List<DMatch> matchesList = matches.toList();
			List<DMatch> bestMatches = new ArrayList<>();
			Double max_dist = Double.valueOf(0.0D);
			Double min_dist = Double.valueOf(100.0D);
			for (int j = 0; j < matchesList.size(); j++) {
				Double dist = Double.valueOf(((DMatch) matchesList.get(j)).distance);
				if (dist.doubleValue() < min_dist.doubleValue() && dist.doubleValue() != 0.0D)
					min_dist = dist;
				if (dist.doubleValue() > max_dist.doubleValue())
					max_dist = dist;
			}
			if (min_dist.doubleValue() > 50.0D)
				System.out.println("No match found");
			double threshold = 3.0D * min_dist.doubleValue();
			double threshold2 = 2.0D * min_dist.doubleValue();
			if (threshold > 75.0D) {
				threshold = 75.0D;
			} else if (threshold2 >= max_dist.doubleValue()) {
				threshold = min_dist.doubleValue() * 1.1D;
			} else if (threshold >= max_dist.doubleValue()) {
				threshold = threshold2 * 1.4D;
			}
			System.out.println("Threshold : " + threshold);
			for (int i = 0; i < matchesList.size(); i++) {
				Double dist = Double.valueOf(((DMatch) matchesList.get(i)).distance);
				if (dist.doubleValue() < threshold)
					bestMatches.add(matches.toList().get(i));
			}
			matchesFiltered.fromList(bestMatches);
			System.out.println("matchesFiltered.size() : " + matchesFiltered.size());
			if (matchesFiltered.rows() >= 1) {
				System.out.println("match found");
				match = 1;
				break;
			}
			System.out.println("no match found");
		}
		if (match == 0)
			l++;
	}

	public void AppDetect_VideoPlayDesktop(Point location, Dimension size) throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 7; i++) {
			String filename = "Errors/error.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight());
			double right = (location.x + size.getWidth());
			Rect faceDetections = new Rect(480, 350, 196, 170);
			Mat img = new Mat(img1, faceDetections);
			Imgcodecs.imwrite("Errors/error5.png", img);
			ret = checkmotion(img);
		}
		if (ret == 0) {
			System.out.println("Video is not playing");
			ExtentUtility.getTest().log(LogStatus.FAIL, " Verify the Video motion when played - Video is not Playing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Video is playing");
			ExtentUtility.getTest().log(LogStatus.PASS, "Verify the Video motion when played - Video is Playing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public void AppDetect_VideoPause_Desktop(Point location, Dimension size) throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 6; i++) {
			String filename = "Errors/error.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 100);
			double right = (location.x + size.getWidth() - 130);
			Rect faceDetections = new Rect(480, 350, 196, 170);
			Mat img = new Mat(img1, faceDetections);
			ret = checkmotion(img);
		}
		if (ret == 0) {
			System.out.println("Video is not playing");
			ExtentUtility.getTest().log(LogStatus.PASS,
					" Verify the Video motion when paused - Video is not Playing After clicking on the Pause button",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Video is playing");
			ExtentUtility.getTest().log(LogStatus.FAIL,
					" Verify the Video motion when paused -  Video is  Playing After clicking on the Pause button ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public void AppDetect_VideoPause_Mobile(Point location, Dimension size) throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 6; i++) {
			String filename = "Errors/pause.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 100);
			double right = (location.x + size.getWidth() - 130);
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img = new Mat(img1, faceDetections);
			Imgcodecs.imwrite("Errors/pause.png", img);
			ret = checkmotion(img);
		}
		if (ret == 0) {
			System.out.println("Video is not playing");
			ExtentUtility.getTest().log(LogStatus.PASS, " Video is not Playing After clicking on the Pause button",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Video is playing");
			ExtentUtility.getTest().log(LogStatus.FAIL, "  Video is  Playing After clicking on the Pause button ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public ArrayList<String> getimageloc(Mat templ) throws IOException {
		int match = 0;
		ArrayList<String> list = new ArrayList<>();
		Point loc = null;
		for (int k = 0; k < 20; k++) {
			Point matchLoc;
			String filename = "Errors/error1.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			CascadeClassifier faceDetector = new CascadeClassifier();
			System.out.println("Running Template Matching");
			int result_cols = img1.cols() - templ.cols() + 1;
			int result_rows = img1.rows() - templ.rows() + 1;
			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			Imgcodecs.imwrite("Errors/templatewe" + k + ".png", img1);
			String match_method = "Imgproc.TM_CCOEFF_NORMED";
			Imgproc.matchTemplate(img1, templ, result, 5);
			Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
			Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
			if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
				matchLoc = mmr.minLoc;
			} else {
				matchLoc = mmr.maxLoc;
			}
			System.out.println(matchLoc);
			System.out.println(mmr.maxVal);
			double threashhold = 0.7D;
			if (mmr.maxVal > threashhold) {
				System.out.println(mmr.maxVal);
				System.out.println("match Found");
				loc = mmr.maxLoc;
				// list = getPoints(loc);
				break;
			}
		}
		return list;
	}

	public boolean CheckImageinVideo(Mat templ, double d) throws IOException {
		boolean status = false;
		Point loc = null;
		for (int k = 0; k < d * 10.0D; k++) {
			String filename = "Errors/error1.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 0);
			int result_cols = img1.cols() - templ.cols() + 1;
			int result_rows = img1.rows() - templ.rows() + 1;
			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			String match_method = "Imgproc.TM_CCOEFF_NORMED";
			Imgproc.matchTemplate(img1, templ, result, 5);
			Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
			Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
			if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
				Point matchLoc = mmr.minLoc;
			} else {
				Point matchLoc = mmr.maxLoc;
			}
			double threashhold = 0.9D;
			if (mmr.maxVal >= threashhold) {
				System.out.println("match Found");
				loc = mmr.maxLoc;
				status = true;
				break;
			}
		}
		return status;
	}

	public boolean CheckImageInPage(Mat templ) throws IOException {
		boolean status = false;
		Point loc = null;
		String filename = "Errors/error1.png";
		File file1 = null;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
			break;
		}
		FileUtils.copyFile(file1, new File(filename));
		Mat img1 = Imgcodecs.imread(filename, 1);
		int result_cols = img1.cols() - templ.cols() + 1;
		int result_rows = img1.rows() - templ.rows() + 1;
		Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
		String match_method = "Imgproc.TM_CCOEFF_NORMED";
		Imgproc.matchTemplate(img1, templ, result, 5);
		Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
		Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
		if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
			Point matchLoc = mmr.minLoc;
		} else {
			Point matchLoc = mmr.maxLoc;
		}
		double threashhold = 0.9D;
		if (mmr.maxVal >= threashhold) {
			System.out.println("match Found");
			loc = mmr.maxLoc;
			status = true;
		}
		return status;
	}

	public void CheckImageInPage_click(Mat templ, WebElement e) throws Exception {
		int a;
		e.click();
		int height = this.appiumDriver.manage().window().getSize().getHeight();
		if (height == 1536 || height == 2048) {
			a = 1;
		} else {
			a = 2;
			Thread.sleep(4000L);
		}
		boolean status = false;
		Point loc = null;
		String filename = String.valueOf(System.getProperty("user.dir")) + "/ReportGenerator/"
				+ ExtentUtility.reportFolder + "/Screenshots/videoAd" + a + ".png";
		File file1 = null;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
			break;
		}
		FileUtils.copyFile(file1, new File(filename));
		Mat img1 = Imgcodecs.imread(filename, 1);
		int result_cols = img1.cols() - templ.cols() + 1;
		int result_rows = img1.rows() - templ.rows() + 1;
		Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
		String match_method = "Imgproc.TM_CCOEFF_NORMED";
		Imgproc.matchTemplate(img1, templ, result, 5);
		Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
		Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
		if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
			Point matchLoc = mmr.minLoc;
		} else {
			Point matchLoc = mmr.maxLoc;
		}
		double threashhold = 0.9D;
		if (mmr.maxVal >= threashhold) {
			System.out.println("match Found");
			loc = mmr.maxLoc;
			status = true;
		}
		if (status) {
			ExtentUtility.getTest().log(LogStatus.INFO,
					"Verify Video Sponsor Ad - Video Sponsor Ad is displayed in the video",
					ExtentUtility.getTest().addScreenCapture(filename));
		} else {
			ExtentUtility.getTest().log(LogStatus.INFO,
					"Verify Video Sponsor Ad - Video Sponsor Ad is not displayed in the video",
					ExtentUtility.getTest().addScreenCapture(filename));
		}
	}

	public void CheckImageInPage_click1(Mat templ, WebElement e) throws Exception {
		clickCoordinates(120, 450);
		Thread.sleep(3000L);
		boolean status = false;
		Point loc = null;
		String filename = String.valueOf(System.getProperty("user.dir")) + "/ReportGenerator/"
				+ ExtentUtility.reportFolder + "/Screenshots/videoAd.png";
		File file1 = null;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
			break;
		}
		FileUtils.copyFile(file1, new File(filename));
		Mat img1 = Imgcodecs.imread(filename, 1);
		int result_cols = img1.cols() - templ.cols() + 1;
		int result_rows = img1.rows() - templ.rows() + 1;
		Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
		String match_method = "Imgproc.TM_CCOEFF_NORMED";
		Imgproc.matchTemplate(img1, templ, result, 5);
		Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
		Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
		if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
			Point matchLoc = mmr.minLoc;
		} else {
			Point matchLoc = mmr.maxLoc;
		}
		double threashhold = 0.9D;
		if (mmr.maxVal >= threashhold) {
			System.out.println("match Found");
			loc = mmr.maxLoc;
			status = true;
		}
		if (status) {
			ExtentUtility.getTest().log(LogStatus.INFO,
					"Verify Video Sponsor Ad - Video Sponsor Ad is displayed in the video",
					ExtentUtility.getTest().addScreenCapture(filename));
		} else {
			ExtentUtility.getTest().log(LogStatus.INFO,
					"Verify Video Sponsor Ad - Video Sponsor Ad is not displayed in the video",
					ExtentUtility.getTest().addScreenCapture(filename));
		}
	}

	public void CheckBlackScreen_mobile(Mat templ) throws Exception {
		boolean status = false;
		Point loc = null;
		String filename = String.valueOf(System.getProperty("user.dir")) + "/ReportGenerator/"
				+ ExtentUtility.reportFolder + "/Screenshots/blackScreenImage.png";
		File file1 = null;
		String str1;
		switch ((str1 = this.toolName).hashCode()) {
		case 1256533886:
			if (!str1.equals("Selenium"))
				break;
			file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
			break;
		case 1967770400:
			if (!str1.equals("Appium"))
				break;
			file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
			break;
		}
		FileUtils.copyFile(file1, new File(filename));
		Mat img1 = Imgcodecs.imread(filename, 1);
		int result_cols = img1.cols() - templ.cols() + 1;
		int result_rows = img1.rows() - templ.rows() + 1;
		Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
		String match_method = "Imgproc.TM_CCOEFF_NORMED";
		Imgproc.matchTemplate(img1, templ, result, 5);
		Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
		Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
		if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
			Point matchLoc = mmr.minLoc;
		} else {
			Point matchLoc = mmr.maxLoc;
		}
		double threashhold = 0.9D;
		if (mmr.maxVal >= threashhold) {
			System.out.println("match Found");
			loc = mmr.maxLoc;
			status = true;
		}
		if (status) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Verify Black Screen - Black Screen is displayed",
					ExtentUtility.getTest().addScreenCapture(filename));
		} else {
			ExtentUtility.getTest().log(LogStatus.INFO, "Verify Black Screen - Black Screen is not displayed",
					ExtentUtility.getTest().addScreenCapture(filename));
		}
	}

	public String extract_Text(Point location, Dimension size) throws IOException, TesseractException {
		StringBuffer result = new StringBuffer();
		for (int k = 0; k < 3; k++) {
			String filename = "Errors/error1.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() + 500);
			double right = (location.x + size.getWidth() + 700);
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img2 = new Mat(img1, faceDetections);
			System.out.println(img2.height() + img2.width());
			Mat imgGray = new Mat();
			Imgproc.cvtColor(img2, imgGray, 6);
			Mat imgGaussianBlur = new Mat();
			Imgproc.GaussianBlur(imgGray, imgGaussianBlur, new Size(3.0D, 3.0D), 0.0D);
			Mat imgAdaptiveThreshold = new Mat();
			Imgcodecs.imwrite("preprocess/adaptive_threshold.png", img2);
			File imageFile = new File("preprocess/adaptive_threshold.png");
			Tesseract tesseract = new Tesseract();
			tesseract.setLanguage("eng");
			result.append(tesseract.doOCR(imageFile));
		}
		String Text = result.toString();
		return Text;
	}

	public void clickCoordinates(int x, int y, String element) throws IOException {
		try {
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				this.remoteDriver.executeScript("mobile: tap", new Object[] { new HashMap<String, Integer>(x, y) {

				} });
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				this.appiumDriver.executeScript("mobile: tap", new Object[] { new HashMap<String, Integer>(x, y) {

				} });
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked successfully on " + element,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (

		Exception e) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on clciking on element" + element,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public String extract_Text_with_coordinates(int left, int top, int bottom, int right, int timeout)
			throws IOException, TesseractException {
		StringBuffer result = new StringBuffer();
		for (int k = 0; k < 1 * timeout; k++) {
			String filename = "preprocess/subtitle.png";
			File file1 = new File("preprocess/subtitle.png");
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 0);
			Rect faceDetections = new Rect(left, top, bottom, right);
			Mat img2 = new Mat(img1, faceDetections);
			Mat imgGaussianBlur = new Mat();
			Imgproc.GaussianBlur(img2, imgGaussianBlur, new Size(3.0D, 3.0D), 0.0D);
			Imgcodecs.imwrite("preprocess/adaptive_threshold.png", imgGaussianBlur);
			File imageFile = new File("preprocess/adaptive_threshold.png");
			Tesseract instance = new Tesseract();
			instance.setLanguage("eng");
			result.append(instance.doOCR(imageFile));
		}
		String Text = result.toString();
		return Text;
	}

	public String extract_Text_Desktop(Point location, Dimension size) throws IOException, TesseractException {
		StringBuffer result = new StringBuffer();
		int ret = 0;
		for (int k = 0; k < 3; k++) {
			String filename = "Errors/subtitles.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 0);
			double left = (location.x + 100);
			double top = (location.y + 100);
			double bottom = (location.y + size.getHeight() - 50);
			double right = (location.x + size.getWidth() - 130);
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img2 = new Mat(img1, faceDetections);
			Imgcodecs.imwrite("Errors/error.png", img2);
			Mat imgGaussianBlur = new Mat();
			Imgproc.GaussianBlur(img2, imgGaussianBlur, new Size(3.0D, 3.0D), 0.0D);
			Imgcodecs.imwrite("preprocess/subtitle.png", imgGaussianBlur);
			File imageFile = new File("preprocess/subtitle.png");
			Tesseract tesseract = new Tesseract();
			tesseract.setLanguage("eng");
			try {
				System.out.println(tesseract.doOCR(imageFile));
				result.append(tesseract.doOCR(imageFile));
				System.out.println("Result appended");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		String Text = result.toString();
		return Text;
	}

	public boolean isElementEnabled(String xpath, String element) throws Exception {
		boolean result = false;
		System.out.println("Verify is Element Enabled : " + element);
		this.appiumDriver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		try {
			return result = this.appiumDriver.findElementByXPath(xpath).isEnabled();
		} catch (Exception exception) {
			return result;
		}
	}

	public boolean isElementDisplayed(int sec, String xpath, String element) throws Exception {
		boolean result = false;
		System.out.println("Verify is Element Displayed : " + element);
		appiumDriver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		try {
			return result = appiumDriver.findElementByXPath(xpath).isDisplayed();
		} catch (Exception exception) {
			return result;
		}
	}
	
	/*@ author Banumathy Sankaran
method to wait for element display as a web element
*/	
	public boolean isElementDisplayed(int sec, WebElement ele) throws Exception {
		boolean result = false;
		System.out.println("Verify is Element Displayed : ");
		appiumDriver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		try {
			return result = ele.isDisplayed();
		} catch (Exception exception) {
			return result;
		}
	}
	
	
	public boolean isElementSelected(String xpath, String element) throws Exception {
		boolean result = false;
		System.out.println("Verify is Element Selected : " + element);
		try {
			return result = this.appiumDriver.findElementByXPath(xpath).isSelected();
		} catch (Exception exception) {
			return result;
		}
	}

	public boolean CheckImageinVideo(Mat templ, double d, Point location, Dimension size) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		boolean status = false;
		Point loc = null;
		for (int k = 0; k < d * 10.0D; k++) {
			String filename = "Errors/errorss.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			System.out.println("Running Template Matching");
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 100);
			double right = (location.x + size.getWidth() - 130);
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			img1 = new Mat(img1, faceDetections);
			int result_cols = img1.cols() - templ.cols() + 1;
			int result_rows = img1.rows() - templ.rows() + 1;
			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			String match_method = "Imgproc.TM_CCOEFF_NORMED";
			Imgproc.matchTemplate(img1, templ, result, 5);
			Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
			Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
			if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
				Point matchLoc = mmr.minLoc;
			} else {
				Point matchLoc = mmr.maxLoc;
			}
			double threashhold = 0.8D;
			if (mmr.maxVal > threashhold) {
				loc = mmr.maxLoc;
				// list = getPoints(loc);
				status = true;
				break;
			}
		}
		if (status) {
			ExtentUtility.getTest().log(LogStatus.INFO, " Video is Buffering ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot((WebDriver) this.remoteDriver)));
		} else {
			System.out.println(" No match Found");
			ExtentUtility.getTest().log(LogStatus.INFO, "No Buffering of Video",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot((WebDriver) this.remoteDriver)));
		}
		return status;
	}

	public void dragAndDropThumb(WebElement e1, int n) throws Exception {
		try {
			Actions action;
			Actions action1;
			String str;
			switch ((str = this.toolName).hashCode()) {
			case 1256533886:
				if (!str.equals("Selenium"))
					break;
				action1 = new Actions((WebDriver) this.remoteDriver);
				action1.dragAndDropBy(e1, n, 0).perform();
				break;
			case 1967770400:
				if (!str.equals("Appium"))
					break;
				action = new Actions((WebDriver) this.appiumDriver);
				action.dragAndDropBy(e1, n, 0).perform();
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on Drag element",
					String.valueOf(exc.toString()) + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void dragAndDropSeekBar(WebElement element, double i, String fw_rw) throws Exception {
		try {
			int start = element.getLocation().getX();
			int end = element.getSize().getWidth();
			int y = element.getLocation().getY();
			TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
			if (fw_rw.equalsIgnoreCase("fw")) {
				int j = (int) (end * i);
			} else {
				int j = (int) (end * i);
			}
		} catch (Exception exception) {
		}
	}

	public int checkmotion(Mat img) {
		int retVal = 0;
		int mistakes = 0;
		if (image == null) {
			image = img;
		} else if (image1 == null) {
			image1 = img;
		} else if (image2 == null) {
			image2 = img;
		}
		if (image != null && image1 != null && image2 != null) {
			Mat t_minus = image;
			Mat t = image1;
			Mat t_plus = image2;
			Mat dst = new Mat();
			Mat dst1 = new Mat();
			Core.absdiff(t_minus, t, dst);
			Core.absdiff(t, t_plus, dst1);
			Mat reshaped = dst.reshape(1);
			Mat reshaped1 = dst1.reshape(1);
			mistakes = Core.countNonZero(reshaped) + Core.countNonZero(reshaped1);
			reshaped.release();
			dst.release();
			dst1.release();
		}
		return mistakes;
	}

	public void AppDetect_VideoPlay(Point location, Dimension size) throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 4; i++) {
			String imageFolder;
			Thread.sleep(1000L);
			int height = this.appiumDriver.manage().window().getSize().getHeight();
			if (height == 1536 || height == 2048) {
				imageFolder = "Error";
			} else {
				imageFolder = "Error1";
			}
			String filename = String.valueOf(imageFolder) + "/error.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			Rect faceDetections = new Rect(40, 200, 2000, 800);
			Mat img = new Mat(img1, faceDetections);
			Imgcodecs.imwrite(String.valueOf(imageFolder) + "/error3" + i + ".png", img);
			ret = checkmotion(img);
		}
		if (ret == 0) {
			System.out.println("Verify the Video motion when playing - Video is not playing");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Verify the Video motion when played - Video is not Playing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Verify the Video motion when playing - Video is Playing in Full Screen");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Verify the Video motion when playing - Video is Playing in Full Screen",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public void AppDetect_VideoPlay_iOS(Dimension size) throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 3; i++) {
			String filename = "Errors/error.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			Rect faceDetections = new Rect(30, 30, 900, 1400);
			Mat img = new Mat(img1, faceDetections);
			Imgcodecs.imwrite("Errors/error3.png", img);
			ret = checkmotion(img);
		}
		if (ret == 0) {
			System.out.println("Verify the Video motion when playing - Video is not playing");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Verify the Video motion when played - Video is not Playing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Verify the Video motion when playing - Video is playing");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Verify the Video motion when played - Video is Playing in Full Screen",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public void AppDetect_VideoPause(Point location, Dimension size) throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 4; i++) {
			String imageFolder;
			Thread.sleep(1000L);
			int height = this.appiumDriver.manage().window().getSize().getHeight();
			if (height == 1536 || height == 2048) {
				imageFolder = "Error";
			} else {
				imageFolder = "Error1";
			}
			String filename = String.valueOf(imageFolder) + "/error.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			Rect faceDetections = new Rect(40, 200, 2000, 800);
			Mat img = new Mat(img1, faceDetections);
			Imgcodecs.imwrite(String.valueOf(imageFolder) + "/error2" + i + ".png", img);
			ret = checkmotion(img);
		}
		if (ret == 0) {
			System.out
					.println("Verify the Video motion when paused - Video is not Playing After tapping the Pause icon");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Verify the Video motion when paused - Video is not Playing After tapping the Pause icon",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Verify the Video motion when paused - Video is Playing After tapping the Pause icon");
			ExtentUtility.getTest().log(LogStatus.FAIL,
					"Verify the Video motion when paused - Video is Playing After tapping the Pause icon",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public void matchimage(AppiumDriver driver, Mat templ, Point location, Dimension size) throws IOException {
		try {
			int match = 0;
			for (int k = 0; k < 20; k++) {
				String filename = "Errors/error1.png";
				File src = (File) driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File(filename));
				Mat img1 = Imgcodecs.imread(filename, 1);
				double left = location.x;
				double top = location.y;
				double bottom = (location.y + size.getHeight() - 60);
				double right = (location.x + size.getWidth() - 140);
				CascadeClassifier faceDetector = new CascadeClassifier();
				System.out.println("Running Template Matching");
				int result_cols = img1.cols() - templ.cols() + 1;
				int result_rows = img1.rows() - templ.rows() + 1;
				Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
				String match_method = "Imgproc.TM_CCOEFF_NORMED";
				Imgproc.matchTemplate(img1, templ, result, 5);
				Imgcodecs.imwrite("Errors/templatewe" + k + ".png", img1);
				Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
				Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
				if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
					Point matchLoc = mmr.minLoc;
				} else {
					Point matchLoc = mmr.maxLoc;
				}
				System.out.println(mmr.minLoc);
				System.out.println(mmr.maxLoc);
				System.out.println(mmr.maxVal);
				double threashhold = 0.7D;
				if (mmr.maxVal > threashhold) {
					System.out.println(mmr.maxVal);
					System.out.println("match Found");
					match++;
					break;
				}
			}
			if (match == 1) {
				ExtentUtility.getTest().log(LogStatus.PASS, " Result = Match Is Found ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot((WebDriver) driver)));
			} else {
				System.out.println(" NO match Found");
				ExtentUtility.getTest().log(LogStatus.FAIL, " Result = No Match Is Found ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot((WebDriver) driver)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void AppDetect_floatingVideoPlay() throws IOException, InterruptedException {
		try {
			int ret = 0;
			for (int i = 0; i < 3; i++) {
				String imageFolder;
				int height = this.appiumDriver.manage().window().getSize().getHeight();
				if (height == 1536 || height == 2048) {
					imageFolder = "Error";
				} else {
					imageFolder = "Error1";
				}
				String filename = String.valueOf(imageFolder) + "/error.png";
				File file1 = null;
				String str1;
				switch ((str1 = this.toolName).hashCode()) {
				case 1256533886:
					if (!str1.equals("Selenium"))
						break;
					file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
					break;
				case 1967770400:
					if (!str1.equals("Appium"))
						break;
					file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
					break;
				}
				FileUtils.copyFile(file1, new File(filename));
				Mat img1 = Imgcodecs.imread(filename, 1);
				Rect faceDetections = null;
				if (height == 1536 || height == 2048) {
					faceDetections = new Rect(800, 1600, 600, 400);
				} else {
					faceDetections = new Rect(600, 1900, 600, 400);
				}
				Mat img = new Mat(img1, faceDetections);
				Imgcodecs.imwrite(String.valueOf(imageFolder) + "/error3.png", img);
				ret = checkmotion(img);
			}
			if (ret == 0) {
				System.out.println(
						"Verify the Video motion in Screen View Mode - Video is not playing in Screen View Mode");
				ExtentUtility.getTest().log(LogStatus.FAIL,
						"Verify the Video motion in Screen View Mode - Video is not playing in Screen View Mode",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out
						.println("Verify the Video motion in Screen View Mode - Video is playing in Screen View Mode");
				ExtentUtility.getTest().log(LogStatus.PASS,
						"Verify the Video motion in Screen View Mode - Video is playing in Screen View Mode",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			image = null;
			image1 = null;
			image2 = null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Appmatchimage(WebDriver driver, Mat templ, Point location, Dimension size) throws IOException {
		int match = 0;
		for (int k = 0; k < 5; k++) {
			Point matchLoc;
			String filename = "Errors/match2.png";
			File src = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			CascadeClassifier faceDetector = new CascadeClassifier();
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.out.println("Running Template Matching__");
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 100);
			double right = (location.x + size.getWidth() - 130);
			System.out.println("face detedffffff");
			int result_cols = img1.cols() - templ.cols() + 1;
			int result_rows = img1.rows() - templ.rows() + 1;
			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			System.out.println("face deted");
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img2 = new Mat(img1, faceDetections);
			System.out.println("face deted");
			String match_method = "Imgproc.TM_CCOEFF_NORMED";
			Imgproc.matchTemplate(img2, templ, result, 5);
			Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
			Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
			System.out.println("face deted111");
			if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
				matchLoc = mmr.minLoc;
			} else {
				matchLoc = mmr.maxLoc;
			}
			System.out.println(matchLoc);
			System.out.println(mmr.maxVal);
			double threashhold = 0.7D;
			if (mmr.maxVal > threashhold) {
				System.out.println(mmr.maxVal);
				System.out.println("match Found");
				match = 1;
				break;
			}
		}
		if (match == 1) {
			ExtentUtility.getTest().log(LogStatus.PASS, " Result = Match Is Found ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		} else {
			System.out.println(" NO match Found");
			ExtentUtility.getTest().log(LogStatus.FAIL, " Result = No Match Is Found ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		}
	}

	public void Appmatchimage(WebDriver driver, Mat templ, Mat temp2, Point location, Dimension size)
			throws IOException {
		int match = 0;
		for (int k = 0; k < 5; k++) {
			Point matchLoc;
			String filename = "Errors/match2.png";
			File src = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			CascadeClassifier faceDetector = new CascadeClassifier();
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.out.println("Running Template Matching__");
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 100);
			double right = (location.x + size.getWidth() - 130);
			System.out.println("face detedffffff");
			int result_cols = img1.cols() - templ.cols() + 1;
			int result_rows = img1.rows() - templ.rows() + 1;
			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			System.out.println("face deted");
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img2 = new Mat(img1, faceDetections);
			System.out.println("face deted");
			String match_method = "Imgproc.TM_CCOEFF_NORMED";
			Imgproc.matchTemplate(img2, templ, result, 5);
			Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
			Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
			System.out.println("face deted111");
			if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
				matchLoc = mmr.minLoc;
			} else {
				matchLoc = mmr.maxLoc;
			}
			System.out.println(matchLoc);
			System.out.println(mmr.maxVal);
			double threashhold = 0.7D;
			if (mmr.maxVal > threashhold) {
				System.out.println(mmr.maxVal);
				System.out.println("match Found");
				match = 1;
				break;
			}
		}
		if (match == 1) {
			ExtentUtility.getTest().log(LogStatus.PASS, " Result = Match Is Found ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		} else {
			System.out.println(" NO match Found");
			ExtentUtility.getTest().log(LogStatus.FAIL, " Result = No Match Is Found ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		}
	}

	public void BlackScreen_Match(Point location, Dimension size) throws IOException {
		String imageFolder;
		int imageNum, height = this.appiumDriver.manage().window().getSize().getHeight();
		if (height == 1536 || height == 2048) {
			imageFolder = "images_tablet";
			imageNum = 1;
		} else {
			imageFolder = "images_phone";
			imageNum = 2;
		}
		Mat templ = Imgcodecs.imread(String.valueOf(imageFolder) + "/blackScreen.png", 1);
		int match = 0;
		String filename = String.valueOf(System.getProperty("user.dir")) + "/ReportGenerator/"
				+ ExtentUtility.reportFolder + "/Screenshots/match" + imageNum + ".png";
		for (int k = 0; k < 3; k++) {
			String imageFolder1;
			File src = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			CascadeClassifier faceDetector = new CascadeClassifier();
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.out.println("Running Template Matching");
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight());
			double right = (location.x + size.getWidth());
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			System.out.println("left" + left + " top" + top + " right" + right + " bottom" + bottom);
			Mat img2 = new Mat(img1, faceDetections);
			if (height == 1536 || height == 2048) {
				imageFolder1 = "Error";
			} else {
				imageFolder1 = "Error1";
			}
			Imgcodecs.imwrite(String.valueOf(imageFolder1) + "/screen" + k + ".png", img2);
			int result_cols = img2.cols() - templ.cols() + 1;
			int result_rows = img2.rows() - templ.rows() + 1;
			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			String match_method = "Imgproc.TM_CCOEFF_NORMED";
			Imgproc.matchTemplate(img2, templ, result, 5);
			Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
			Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
			if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
				Point matchLoc = mmr.minLoc;
			} else {
				Point matchLoc = mmr.maxLoc;
			}
			double threashhold = 0.7D;
			if (mmr.maxVal > threashhold) {
				System.out.println(mmr.maxVal);
				System.out.println("BlackScreen Found");
				match = 1;
				break;
			}
		}
		if (match == 1) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Verify Black Screen - Black Screen is displayed",
					ExtentUtility.getTest().addScreenCapture(filename));
		} else {
			System.out.println("No match Found");
			ExtentUtility.getTest().log(LogStatus.INFO, "Verify Black Screen - Black Screen is not displayed",
					ExtentUtility.getTest().addScreenCapture(filename));
		}
	}

	public void BlackScreen_Match_ios(Point location, Dimension size) throws IOException {
		Mat templ = Imgcodecs.imread("images_ios/blackScreen1.png", 1);
		int match = 0;
		String filename = String.valueOf(System.getProperty("user.dir")) + "/ReportGenerator/"
				+ ExtentUtility.reportFolder + "/Screenshots/match2.png";
		for (int k = 0; k < 3; k++) {
			File src = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			CascadeClassifier faceDetector = new CascadeClassifier();
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.out.println("Running Template Matching");
			Rect faceDetections = new Rect(30, 30, 900, 1400);
			Mat img2 = new Mat(img1, faceDetections);
			Imgcodecs.imwrite("Errors/screen" + k + ".png", img2);
			int result_cols = img2.cols() - templ.cols() + 1;
			int result_rows = img2.rows() - templ.rows() + 1;
			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			String match_method = "Imgproc.TM_CCOEFF_NORMED";
			Imgproc.matchTemplate(img2, templ, result, 5);
			Imgproc.threshold(result, result, 0.5D, 1.0D, 3);
			Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
			if (match_method == "Imgproc.TM_SQDIFF" || match_method == "Imgproc.TM_SQDIFF_NORMED") {
				Point matchLoc = mmr.minLoc;
			} else {
				Point matchLoc = mmr.maxLoc;
			}
			double threashhold = 0.7D;
			if (mmr.maxVal > threashhold) {
				System.out.println(mmr.maxVal);
				System.out.println("BlackScreen Found");
				match = 1;
				break;
			}
		}
		if (match == 1) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Verify Black Screen - Black Screen is displayed",
					ExtentUtility.getTest().addScreenCapture(filename));
		} else {
			System.out.println("No match Found");
			ExtentUtility.getTest().log(LogStatus.INFO, "Verify Black Screen - Black Screen is not displayed",
					ExtentUtility.getTest().addScreenCapture(filename));
		}
	}

	public void getScreenShot(AppiumDriver driver) throws IOException {
		String filename = "Errors/error1.png";
		File src = (File) driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filename));
		Mat img1 = Imgcodecs.imread(filename, 1);
	}

	public void Detect_VideoPlay(WebDriver driver, Point location, Dimension size)
			throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 6; i++) {
			String filename = "Errors/error.png";
			File src = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 60);
			double right = (location.x + size.getWidth() - 140);
			CascadeClassifier faceDetector = new CascadeClassifier();
			faceDetector.load("C:/opencv-2.4.10/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml");
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img = new Mat(img1, faceDetections);
			filename = "Errors/player" + i + ".png";
			Imgcodecs.imwrite("Errors/player" + i + ".png", img);
			Thread.sleep(3000L);
			Mat img2 = Imgcodecs.imread(filename, 1);
			ret = checkmotion(img2);
		}
		if (ret == 0) {
			System.out.println("Video is not playing");
			ExtentUtility.getTest().log(LogStatus.FAIL, " Result = Video is not Playing - FALSE ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		} else {
			System.out.println("Video is playing");
			ExtentUtility.getTest().log(LogStatus.PASS, " Result = Video is  Playing - TRUE ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public void Detect_VideoPause(WebDriver driver, Point location, Dimension size)
			throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 6; i++) {
			String filename = "Errors/error.png";
			File src = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight() - 60);
			double right = (location.x + size.getWidth() - 140);
			CascadeClassifier faceDetector = new CascadeClassifier();
			faceDetector.load("C:/opencv-2.4.10/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml");
			Rect faceDetections = new Rect((int) left, (int) top, (int) right, (int) bottom);
			Mat img = new Mat(img1, faceDetections);
			filename = "Errors/player" + i + ".png";
			Imgcodecs.imwrite("Errors/player" + i + ".png", img);
			Thread.sleep(3000L);
			Mat img2 = Imgcodecs.imread(filename, 1);
			ret = checkmotion(img2);
		}
		if (ret == 0) {
			System.out.println("Video is not playing");
			ExtentUtility.getTest().log(LogStatus.PASS, " Result = Video is not Playing - FALSE ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		} else {
			System.out.println("Video is playing");
			ExtentUtility.getTest().log(LogStatus.FAIL, " Result = Video is  Playing - TRUE ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot(driver)));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public String takeScreenShot(WebDriver driver) throws IOException {
		Calendar cal = Calendar.getInstance();
		long s = cal.getTimeInMillis();
		File screen = null;
		screen = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("D:/" + ExtentUtility.reportFolder + "/Screenshots/image" + s + ".png"));
		return (new File("D://" + ExtentUtility.reportFolder + "//Screenshots//image" + s + ".png")).getAbsolutePath();
	}

	public void AppMatch(WebElement element, AppiumDriver driver, Mat img2, Point location, Dimension size)
			throws IOException, InterruptedException {
		int l = 0, k = 0;
		int match = 0;
		for (k = 0; k < 10; k++) {
			String filename = "Errors/error1.png";
			File src = (File) driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			double left = location.x;
			double top = location.y;
			double bottom = (location.y + size.getHeight());
			double right = (location.x + size.getWidth());
			Rect faceDetections = new Rect(46, 650, 50, 50);
			Mat img = new Mat(img1, faceDetections);
			filename = "Errors/match1.png";
			Imgcodecs.imwrite("Errors/match1.png", img);
			Thread.sleep(1000L);
			Mat img3 = Imgcodecs.imread(filename, 1);
			FeatureDetector fd = FeatureDetector.create(11);
			MatOfKeyPoint keyPointsLarge = new MatOfKeyPoint();
			MatOfKeyPoint keyPointsSmall = new MatOfKeyPoint();
			fd.detect(img3, keyPointsLarge);
			fd.detect(img2, keyPointsSmall);
			Mat descriptorsLarge = new Mat();
			Mat descriptorsSmall = new Mat();
			DescriptorExtractor extractor = DescriptorExtractor.create(5);
			extractor.compute(img3, keyPointsLarge, descriptorsLarge);
			extractor.compute(img2, keyPointsSmall, descriptorsSmall);
			MatOfDMatch matches = new MatOfDMatch();
			DescriptorMatcher matcher = DescriptorMatcher.create(5);
			matcher.match(descriptorsLarge, descriptorsSmall, matches);
			MatOfDMatch matchesFiltered = new MatOfDMatch();
			List<DMatch> matchesList = matches.toList();
			List<DMatch> bestMatches = new ArrayList<>();
			Double max_dist = Double.valueOf(0.0D);
			Double min_dist = Double.valueOf(100.0D);
			for (int j = 0; j < matchesList.size(); j++) {
				Double dist = Double.valueOf(((DMatch) matchesList.get(j)).distance);
				if (dist.doubleValue() < min_dist.doubleValue() && dist.doubleValue() != 0.0D)
					min_dist = dist;
				if (dist.doubleValue() > max_dist.doubleValue())
					max_dist = dist;
			}
			if (min_dist.doubleValue() > 50.0D)
				System.out.println("No match found");
			double threshold = 3.0D * min_dist.doubleValue();
			double threshold2 = 2.0D * min_dist.doubleValue();
			if (threshold > 75.0D) {
				threshold = 75.0D;
			} else if (threshold2 >= max_dist.doubleValue()) {
				threshold = min_dist.doubleValue() * 1.1D;
			} else if (threshold >= max_dist.doubleValue()) {
				threshold = threshold2 * 1.4D;
			}
			System.out.println("Threshold : " + threshold);
			for (int i = 0; i < matchesList.size(); i++) {
				Double dist = Double.valueOf(((DMatch) matchesList.get(i)).distance);
				if (dist.doubleValue() < threshold)
					bestMatches.add(matches.toList().get(i));
			}
			matchesFiltered.fromList(bestMatches);
			System.out.println("matchesFiltered.size() : " + matchesFiltered.size());
			if (matchesFiltered.rows() >= 1) {
				System.out.println("match found");
				match = 1;
				ExtentUtility.getTest().log(LogStatus.PASS, " Result =  Match Is Found ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot((WebDriver) driver)));
				break;
			}
			System.out.println("no match found");
		}
	}

	public String getresponse() {
		String BaseURl = "http://10.242.193.101:3000/";
		String url = "posts";
		HttpResponse response = null;
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		get.addHeader("Content-Type", "application/json");
		try {
			response = defaultHttpClient.execute((HttpUriRequest) get);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("HTTP RESPONSE : " + response);
		System.out.println(response.getStatusLine());
		HttpEntity entity = response.getEntity();
		String text = "";
		try {
			text = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("text--" + text);
		String responses = response.toString();
		System.out.println(responses);
		return responses;
	}

	public void AppDetect_VideoPause(int left, int top, int right, int bottom)
			throws IOException, InterruptedException {
		int ret = 0;
		for (int i = 0; i < 3; i++) {
			String filename = "Errors/error.png";
			File file1 = null;
			String str1;
			switch ((str1 = this.toolName).hashCode()) {
			case 1256533886:
				if (!str1.equals("Selenium"))
					break;
				file1 = (File) this.remoteDriver.getScreenshotAs(OutputType.FILE);
				break;
			case 1967770400:
				if (!str1.equals("Appium"))
					break;
				file1 = (File) this.appiumDriver.getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(file1, new File(filename));
			Mat img1 = Imgcodecs.imread(filename, 1);
			Rect faceDetections = new Rect(left, top, right, bottom);
			Mat img = new Mat(img1, faceDetections);
			Imgcodecs.imwrite("Errors/error2.png", img);
			ret = checkmotion(img);
		}
		if (ret == 0) {
			System.out.println("Verify the Video motion when paused - Video is not playing");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Verify the Video motion when paused - Video is not Playing After tapping the Pause icon",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Verify the Video motion when paused - Video is playing");
			ExtentUtility.getTest().log(LogStatus.FAIL,
					"Verify the Video motion when paused - Video is Playing After tapping the Pause icon",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		image = null;
		image1 = null;
		image2 = null;
	}

	public void dragAndDroplocation(double i, String fw_rw) throws Exception {
		try {
			TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
			fw_rw.equalsIgnoreCase("fw");
		} catch (Exception exception) {
		}
	}

	public static void swipeDowntoXPath(String xPath, AppiumDriver driver) {
		boolean flag = true;
		int count = 1;
		while (flag) {
			try {
				driver.findElement(By.xpath(xPath));
				flag = false;
				break;
			} catch (Exception NoSuchElementException) {
				count = count + 1;
				Map<String, Object> params = new HashMap<>();
				params.put("start", "40%,90%");
				params.put("end", "40%,20%");
				params.put("duration", "2");
				Object res = driver.executeScript("mobile:touch:swipe", params);
				if (count == 5) {
					break;
				}
			}
		}
	}

	public static void scrollToTextiOS(String text) {
		JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
		HashMap scrollObject = new HashMap<>();
		scrollObject.put("direction", "down");
		scrollObject.put("predicateString", "value == '" + text + "'");
		js.executeScript("mobile: scroll", scrollObject);
	}


	public void scrollToXpath(String xpath) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
		HashMap scrollObject = new HashMap<>();
		while(!isElementPresent(3, xpath)) 
		{
		scrollObject.put("direction", "down");
		scrollObject.put("xpath", xpath);
		js.executeScript("mobile: scroll", scrollObject);
		}
	}

	public static boolean isElementPresent(int sec, String xpath) throws Exception {
		boolean result = false;
		System.out.println("Verify is Element Displayed : ");
		appiumDriver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		try {
			return result = appiumDriver.findElementByXPath(xpath).isDisplayed();
		} catch (Exception exception) {
			return result;
		}
	}


	public void swipeUp(String elementToBeDisplayed) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int startPos = 10000;
		int endPos = -600;
		for (int i = 0; i <= 10; i++) {

			/*
			 * if (locality_value.equalsIgnoreCase("Cloud")) { swipeUp(); } else {
			 */ action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
					.moveTo(PointOption.point(0, endPos)).release().perform();
			if (!isElementDisplayed(5, elementToBeDisplayed, "Swipe up : ")) {
				swipeUp(elementToBeDisplayed);
			}
			break;
		}
	}

	public void scrollDownMethod2(String elementToBeDisplayed) throws Exception {
		while (!isElementDisplayed(2, elementToBeDisplayed, "Scroll down further")) {
			appiumDriver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
			Thread.sleep(3000);
		} 
	}

	
	
	public void swipeDownWithWhile(String elementToBeDisplayed) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int startPos = 900;
		int endPos = -10000;
			int counter=0;
	do {
				action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
							.moveTo(PointOption.point(0, endPos)).release().perform();
				counter++;
				if(counter>15) {
				System.out.println("element not found");
					break;
				}
			}	while (!isElementDisplayed(5, elementToBeDisplayed, "Swipe down : "));
		}
		
	
	public void scrollToTextiOSinRight(String text) {
		JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
		HashMap scrollObject = new HashMap<>();
		scrollObject.put("direction", "right");
		scrollObject.put("predicateString", "value == '" + text + "'");
		js.executeScript("mobile: scroll", scrollObject);
	}
	
	public void byLocatorClick(By locator, String elementName) throws Exception {
		WebDriverWait wait, waitSelenium;
		String str;
	
		 		wait = new WebDriverWait((WebDriver) this.appiumDriver, 0L);
		 		wait.until((Function) ExpectedConditions.visibilityOfElementLocated(locator));
		 		this.appiumDriver.findElement(locator).click();
				System.out.println("Clicking on Element Successful : " + elementName);
		 	}

public void swipeDownWithIf(String elementToBeDisplayed,int startPos,int endPos) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int counter=0;
		for (int i = 0; i <= 10; i++) {			
			if (isElementDisplayed(5, elementToBeDisplayed, "Checking for element:")) {
				System.out.println("Element is seen: " + getText(elementToBeDisplayed));
		        break;  
			} else {
				action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
						.moveTo(PointOption.point(0, endPos)).release().perform();
				counter++;
			}
			if(counter>16) {
				System.out.println("The limit of swiping has exceeded, element is not found.");
				break;
			}
		}
	}
	
public void scrollUpMethod2(String elementToBeDisplayed) throws Exception {
	appiumDriver.executeScript("mobile: scroll", ImmutableMap.of("direction", "up"));
	int counter=0;
	while ((!isElementDisplayed(2, elementToBeDisplayed, "Scroll up further"))&&(counter<6)) {
		appiumDriver.executeScript("mobile: scroll", ImmutableMap.of("direction", "up"));
		Thread.sleep(3000);	
		counter++;
	} 
}
	
	public boolean isElementDisplayedByLoc(By locator) throws Exception {
		boolean result = false;
		System.out.println("Verify is Element Displayed : ");
			return result = appiumDriver.findElement(locator).isDisplayed();
	}
	
	public void swipeDownWithIfByLoc(By elementToBeDisplayed,int startPos,int endPos) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		for (int i = 0; i <= 5; i++) {
			if (isElementDisplayedByLoc(elementToBeDisplayed)) {
				System.out.println("Element is seen: " + appiumDriver.findElement(elementToBeDisplayed).getText());
				takeScreenShot();
		        break;  
			} else {
				action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
						.moveTo(PointOption.point(0, endPos)).release().perform();
			}

		}
	}
	
	
	public void scrollUpNnoOfTimes(int noOfSwipes) throws Exception {
		for (int i = 0; i < noOfSwipes; i++) {
			appiumDriver.executeScript("mobile: scroll", ImmutableMap.of("direction", "up"));
		}
	}
	
	public void scrollDownNnoOfTimes(int noOfSwipes) throws Exception {
		for (int i = 0; i < noOfSwipes; i++) {
			appiumDriver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
		}
	}
	
	public void softWait(int sec) {
		System.out.println("make the script wait for few seconds: ");
		appiumDriver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	
	public void swipeDownLargeForNTimes(int noOfSwipe) throws Exception {
		TouchAction action = new TouchAction((PerformsTouchActions) this.appiumDriver);
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int startPos = 850;
		int endPos = -12000;
		for (int i = 0; i < noOfSwipe; i++) {
			action.press(PointOption.point(0, startPos)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1L)))
					.moveTo(PointOption.point(0, endPos)).release().perform();
		}
	}
	
	
	
	public void scrollDownOrUpForNTimes(int noOfTimes,int coor,String direction) throws Exception {
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int topY = 0;
		for (int i = 0; i < noOfTimes; i++) {
				TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
				int pressX = appiumDriver.manage().window().getSize().width / 2;
				int bottomY = appiumDriver.manage().window().getSize().height / 2;
				topY = bottomY - coor;
				System.out.println("pressX : " + pressX);
				System.out.println("bottomY : " + bottomY);
				System.out.println("topY : " + topY);
				if(direction.equalsIgnoreCase("Down")) {
				action.press(new PointOption().withCoordinates(pressX, bottomY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
						.moveTo(new PointOption().withCoordinates(pressX, topY)).release().perform();
				
				}else if(direction.equalsIgnoreCase("Up")) {
					action.press(new PointOption().withCoordinates(pressX, topY))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
					.moveTo(new PointOption().withCoordinates(pressX, bottomY)).release().perform();
				}
			}

		}
	

	
	public void scrollDownOrUpWithIfNew(String elementToBeDisplayed, int coor,String direction) throws Exception {
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int counter = 0;
		int topY = 0;
		for (int i = 0; i <= 10; i++) {

			if (isElementDisplayed(5, elementToBeDisplayed, "Checking for element:")) {
				System.out.println("Element is seen: " + getText(elementToBeDisplayed));
				scrollDownOrUpForNTimes(1, 100, direction);
				break;
			} else {
				TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
				int pressX = appiumDriver.manage().window().getSize().width / 2;
				int bottomY = appiumDriver.manage().window().getSize().height / 2;
				topY = bottomY - coor;
				System.out.println("pressX : " + pressX);
				System.out.println("bottomY : " + bottomY);
				System.out.println("topY : " + topY);
				if(direction.equalsIgnoreCase("Down")) {
				action.press(new PointOption().withCoordinates(pressX, bottomY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
						.moveTo(new PointOption().withCoordinates(pressX, topY)).release().perform();
				
				}else if(direction.equalsIgnoreCase("Up")) {
					action.press(new PointOption().withCoordinates(pressX, topY))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
					.moveTo(new PointOption().withCoordinates(pressX, bottomY)).release().perform();
				}
				counter++;
			}
			if (counter > 23) {
				System.out.println("The limit of swiping has exceeded, element is not found.");
				break;
			}
		}
	}
	
	
	public void swipeLeftOrRightNew(String elementToBeDisplayed, int coor,String direction) throws Exception {
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int counter = 0;
		int topX = 0;
		for (int i = 0; i <= 10; i++) {

			if (isElementDisplayed(5, elementToBeDisplayed, "Checking for element:")) {
				System.out.println("Element is seen: " + getText(elementToBeDisplayed));
				break;
			} else {
				TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
				int pressX = appiumDriver.manage().window().getSize().width / 2;
				int bottomY = appiumDriver.manage().window().getSize().height / 2;
				if (coor == 100) {
					topX = pressX - 100;
				} else if (coor == 500) {
					topX = pressX - 500;
				}
				System.out.println("pressX : " + pressX);
				System.out.println("bottomY : " + bottomY);
				System.out.println("topX : " + topX);
				if(direction.equalsIgnoreCase("Right")) {
				action.press(new PointOption().withCoordinates(pressX, bottomY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
						.moveTo(new PointOption().withCoordinates(topX, bottomY)).release().perform();
				}else if(direction.equalsIgnoreCase("Left")) {
					action.press(new PointOption().withCoordinates(topX, bottomY))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
					.moveTo(new PointOption().withCoordinates(pressX, bottomY)).release().perform();	
				}
				counter++;
			}
			if (counter > 10) {
				System.out.println("The limit of swiping has exceeded, element is not found.");
				break;
			}
		}
		}		
	
	
	public void scrollLeftOrRightForNTimes(int noOfTimes,int coor,String direction) throws Exception {
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int topX = 0;
		for (int i = 0; i < noOfTimes; i++) {
				TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
				int pressX = (int) (appiumDriver.manage().window().getSize().width  / 2);
				int bottomY = (int) (appiumDriver.manage().window().getSize().height / 2);
				topX = pressX - coor;
				System.out.println("pressX : " + pressX);
				System.out.println("bottomY : " + bottomY);
				System.out.println("topX : " + topX);
				if(direction.equalsIgnoreCase("Right")) {
					action.press(new PointOption().withCoordinates(pressX, bottomY))
							.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
							.moveTo(new PointOption().withCoordinates(topX, bottomY)).release().perform();
					}else if(direction.equalsIgnoreCase("Left")) {
						action.press(new PointOption().withCoordinates(topX, bottomY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
						.moveTo(new PointOption().withCoordinates(pressX, bottomY)).release().perform();	
					}
			}

		}
	
	public void scrollLeftOrRightForNTimesAtTop(int noOfTimes,int coor,String direction) throws Exception {
		PointOption p1 = new PointOption();
		PointOption p2 = new PointOption();
		int topX = 0;
		for (int i = 0; i < noOfTimes; i++) {
				TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
				int pressX = (int) (appiumDriver.manage().window().getSize().width  / 2);
				int bottomY = (int) (appiumDriver.manage().window().getSize().height / 4);
				topX = pressX - coor;
				System.out.println("pressX : " + pressX);
				System.out.println("bottomY : " + bottomY);
				System.out.println("topX : " + topX);
				if(direction.equalsIgnoreCase("Right")) {
					action.press(new PointOption().withCoordinates(pressX, bottomY))
							.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
							.moveTo(new PointOption().withCoordinates(topX, bottomY)).release().perform();
					}else if(direction.equalsIgnoreCase("Left")) {
						action.press(new PointOption().withCoordinates(topX, bottomY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
						.moveTo(new PointOption().withCoordinates(pressX, bottomY)).release().perform();	
					}
			}

		}
	
	
	}
