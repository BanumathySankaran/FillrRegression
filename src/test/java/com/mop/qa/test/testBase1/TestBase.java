package com.mop.qa.test.testBase1;

import com.mop.qa.test.Utilities.ExtentUtility;
import com.mop.qa.test.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteResultHandler;
import org.opencv.core.Core;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
  public static long startTime;
  
  public static String startTimeUpdate;
  
  public static long endTime;
  
  public static long totalTime;
  
  public static String totalTimeTaken;
  
  public static String osType = System.getProperty("os.name");
  
  public static String deviceType = System.getProperty("device.name");
  
  public String toolName = "";
  
  public String appType = "";
  
  public String RemoteUrl = "";
  
  public AppiumDriver<WebElement> appiumDriver;
  
  public RemoteWebDriver remoteDriver;
  
  public String udid = null;
  
  public String appium_port = null;
  
  public String currentTest = "";
  
  public String platform_name = null;
  
  public ReadDataSheet rds = new ReadDataSheet();
  
 @BeforeSuite
  public void executeSuite(ITestContext ctx) {
    try {
      System.out.println("@ Before Suite");
      ExtentUtility.extent = ExtentUtility.getReporter();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void getSuiteName(ISuite ist) {
    try {
      System.out.println(ist.getName());
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  @BeforeTest
  public void startTestReport(ITestContext ctx) {
    try {
      if (getPropertyValue("Video_solution").equalsIgnoreCase("Yes"))
        try {
          System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        } catch (Exception e) {
          System.out.println("In Loading Video Library " + e.getMessage());
        }  
      String browser = ctx.getCurrentXmlTest().getParameter("browser");
      this.toolName = ctx.getCurrentXmlTest().getParameter("toolName");
      this.udid = ctx.getCurrentXmlTest().getParameter("udid");
      this.platform_name = ctx.getCurrentXmlTest().getParameter("platformName");
      this.appType = ctx.getCurrentXmlTest().getParameter("appType");
      String exeType = ctx.getCurrentXmlTest().getParameter("ExecutionType");
      String localityType = ctx.getCurrentXmlTest().getParameter("Locality");
      this.RemoteUrl = ctx.getCurrentXmlTest().getParameter("RemoteUrl");
      System.out.println("toolname is " + ctx.getCurrentXmlTest().getParameter("toolName"));
      String startURL = this.rds.getValue("DATA", this.currentTest, "URL");
      if (!this.toolName.equalsIgnoreCase("Services"))
        if (this.toolName.equalsIgnoreCase("Appium")) {
          this.appium_port = getPort();
          if (exeType.equalsIgnoreCase("Parallel")) {
            this.appType = ctx.getCurrentXmlTest().getParameter("appType");
            System.out.println("App type is " + ctx.getCurrentXmlTest().getParameter("appType"));
            if (System.getProperty("os.name").contains("Win")) {
              System.out.println("appium parallel");
              this.udid = ctx.getCurrentXmlTest().getParameter("udid");
              this.platform_name = ctx.getCurrentXmlTest().getParameter("platformName");
              Thread.sleep(5000L);
              initiateDriver(localityType, this.appium_port, browser, this.RemoteUrl, this.platform_name, this.toolName, this.appType, startURL);
            } else if (ctx.getCurrentXmlTest().getParameter("platformName").equalsIgnoreCase("Android")) {
              this.udid = ctx.getCurrentXmlTest().getParameter("udid");
              this.platform_name = ctx.getCurrentXmlTest().getParameter("platformName");
              this.appType = ctx.getCurrentXmlTest().getParameter("appType");
              if (!localityType.equalsIgnoreCase("Cloud"))
                startIOSServerForiOSDevice(this.udid, this.appium_port); 
              initiateDriver(localityType, this.appium_port, browser, this.RemoteUrl, this.platform_name, this.toolName, 
                  this.appType, startURL);
            } else {
              if (!localityType.equalsIgnoreCase("Cloud"))
                startIOSServerForiOSDevice(this.udid, this.appium_port); 
              initiateDriver(localityType, this.appium_port, browser, this.RemoteUrl, this.platform_name, this.toolName, 
                  this.appType, startURL);
            } 
          } else if (this.toolName.equalsIgnoreCase("Appium")) {
            if (System.getProperty("os.name").contains("Win")) {
              this.appType = ctx.getCurrentXmlTest().getParameter("appType");
              this.udid = ctx.getCurrentXmlTest().getParameter("udid");
              this.platform_name = ctx.getCurrentXmlTest().getParameter("platformName");
              localityType.equalsIgnoreCase("Cloud");
              this.appium_port = "4723";
              Thread.sleep(5000L);
              initiateDriver(localityType, this.appium_port, browser, this.RemoteUrl, this.platform_name, this.toolName, 
                  this.appType, startURL);
            } else {
              this.appType = ctx.getCurrentXmlTest().getParameter("appType");
              this.udid = ctx.getCurrentXmlTest().getParameter("udid");
              this.platform_name = ctx.getCurrentXmlTest().getParameter("platformName");
              System.out.println("platformName " + ctx.getCurrentXmlTest().getParameter("platformName"));
              localityType.equalsIgnoreCase("Cloud");
              this.appium_port = "4723";
              Thread.sleep(5000L);
              initiateDriver(localityType, this.appium_port, browser, this.RemoteUrl, this.platform_name, this.toolName, 
                  this.appType, startURL);
            } 
          } 
        } else {
          System.out.println("browser is selenium" + ctx.getCurrentXmlTest().getParameter("browser"));
          initiateDriver(localityType, this.appium_port, browser, this.RemoteUrl, this.platform_name, this.toolName, this.appType, startURL);
        }  
      System.out.println("test name is " + ctx.getCurrentXmlTest().getParameter("testname1"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
  
  @BeforeMethod
  public void beforeMethod(Method method) throws IOException {
    ExtentUtility.startTest(method.getName());
    System.out.println("Test Method " + method.getName() + "  is Starting ");
  }
  
  @AfterMethod
  protected void afterMethod(ITestResult result) throws IOException {
    System.out.println("@ After Method");
    if (result.getStatus() == 2) {
      ExtentUtility.getTest().log(LogStatus.FAIL, result.getThrowable());
    } else if (result.getStatus() == 3) {
      ExtentUtility.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
    } else {
      result.getStatus();
    } 
    ExtentUtility.getReporter().endTest(ExtentUtility.getTest());
    ExtentUtility.getReporter().flush();
    this.appiumDriver.closeApp();
  }
  
  @AfterSuite
  public void afterTest() throws Exception {
    if (this.toolName.equalsIgnoreCase("Appium")) {
      if (this.appiumDriver != null) {
        ExtentUtility.extent.endTest(ExtentUtility.getTest());
        System.out.println("report generation completed");
        System.out.println(String.valueOf(System.getProperty("user.dir")) + "/ReportGenerator/" + ExtentUtility.reportFolder + "/TestReport.html");
        Thread.sleep(5000L);
        this.appiumDriver.closeApp();
        this.appiumDriver.close();
      } 
    } else if (this.toolName.equalsIgnoreCase("selenium")) {
      if (this.remoteDriver != null) {
        ExtentUtility.extent.endTest(ExtentUtility.getTest());
        Thread.sleep(5000L);
      } 
    } 
  }
  
  @AfterSuite
  public void finishExecution() throws Exception {
    System.out.println("\t@AfterSuite ...after suite----------------------");
    try {
      if (this.toolName.equalsIgnoreCase("Appium")) {
        if (this.appiumDriver != null) {
          this.appiumDriver.closeApp();
          this.appiumDriver.close();
          this.appiumDriver.quit();
        } 
      } else if (this.remoteDriver != null) {
        this.remoteDriver.quit();
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      ExtentUtility.getReporter().flush();
    } 
  }
  
  public void startIOSServerForAndroidDevice() throws IOException, InterruptedException {
    System.out.println("generate report");
  }
  
  public void startAppium(String port) throws Exception {
    String chromePort = getPort();
    String bootstrapPort = getPort();
    String command = "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js --session-override -p " + 
      port + " --chromedriver-port " + chromePort + " -bp " + bootstrapPort;
    System.out.println(command);
    String output = runCommand(command);
    System.out.println("output" + output);
  }
  
  public void startAppiumServerIos(String udid, String port) {
    try {
      String chromePort = getPort();
      String bootstrapPort = getPort();
      CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
      command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
      command.addArgument("--address", false);
      command.addArgument("127.0.0.1");
      command.addArgument("--port", false);
      command.addArgument(port);
      command.addArgument("--session-override", false);
      command.addArgument("--bootstrap-port", false);
      command.addArgument(bootstrapPort);
      command.addArgument("--chromedriver-port", false);
      command.addArgument(chromePort);
      command.addArgument("-U", false);
      command.addArgument(udid);
      DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
      DefaultExecutor executor = new DefaultExecutor();
      executor.setExitValue(1);
      executor.execute(command, (ExecuteResultHandler)resultHandler);
      Thread.sleep(5000L);
      System.out.println("Appium server started.");
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public String runCommand(String command) throws InterruptedException, IOException {
    Process proc = null;
    proc = Runtime.getRuntime().exec("/bin/bash " + command);
    BufferedReader r = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    String line = "";
    String allLine = "";
    while ((line = r.readLine()) != null) {
      allLine = String.valueOf(allLine) + line + "\n";
      if (line.contains("started on"))
        break; 
    } 
    return allLine;
  }
  
  public String getPort() throws Exception {
    ServerSocket socket = new ServerSocket(0);
    socket.setReuseAddress(true);
    String port = Integer.toString(socket.getLocalPort());
    socket.close();
    return port;
  }
  
  public void startIOSServerForiOSDevice(String udid, String port) throws IOException, InterruptedException {
    try {
      String bootstrapPort = getPort();
      Thread.sleep(3000L);
      CommandLine command = new CommandLine("/usr/local/bin/node");
      command.addArgument("/usr/local/bin/appium", 
          false);
      command.addArgument("--address", false);
      command.addArgument("127.0.0.1");
      command.addArgument("--port", false);
      command.addArgument(port);
      command.addArgument("--session-override", false);
      command.addArgument("--bootstrap", false);
      command.addArgument(bootstrapPort);
      command.addArgument("--udid", false);
      command.addArgument(udid);
      DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
      DefaultExecutor executor = new DefaultExecutor();
      executor.setExitValue(1);
      executor.execute(command, (ExecuteResultHandler)resultHandler);
      Thread.sleep(20000L);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    Thread.sleep(10000L);
  }
  
  public void initiateDriver(String localityType, String port, String browser, String RemoteUrl, String platform_name, String toolname, String appType, String startURL) {
    try {
      if (this.toolName.equalsIgnoreCase("Appium")) {
        System.out.println("driver start");
        PageBase pagebaseclass = new PageBase(this.appiumDriver);
        this.appiumDriver = pagebaseclass.launchApp(this.udid, localityType, RemoteUrl, toolname, appType, port, 
            platform_name, startURL);
      } 
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
  
  public void startWindowsServer(String udid, String port, String platform_name, String localityType) throws Exception {
    String chromePort = getPort();
    String bootStrapPort = getPort();
    try {
      if (localityType.equalsIgnoreCase("Grid")) {
        String nodePath_windows = getPropertyValue("nodePath_windows");
        String appiumJSPath_windows = getPropertyValue("appiumJSPath_windows");
        System.out.println("nodePath_windows" + nodePath_windows);
        System.out.println("appiumJSPath_windows" + appiumJSPath_windows);
        CommandLine command = new CommandLine(nodePath_windows);
        command.addArgument(appiumJSPath_windows, false);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        if (platform_name.equalsIgnoreCase("android")) {
          executor.setExitValue(1);
          executor.execute(command, (ExecuteResultHandler)resultHandler);
          Thread.sleep(10000L);
        } else {
          command.addArgument("--udid", false);
          ProcessBuilder pb = new ProcessBuilder(new String[0]);
          Map<String, String> env = pb.environment();
          env.put("ANDROID_HOME", "C:\\Users\\426205\\AppData\\Local\\Android\\sdk");
          env.put("PATH", 
              "/Users/mspiosteam/.rvm/gems/ruby-2.2.0/bin:/Users/mspiosteam/.rvm/gems/ruby-2.2.0@global/bin:/Users/mspiosteam/.rvm/rubies/ruby-2.2.0/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Applications/android-sdk-macosx:/usr/local/git/bin:/usr/local/Cellar/libimobiledevice/1.2.0/bin:/Users/mspiosteam/.rvm/gems/ruby-2.2.0/bin:/Users/mspiosteam/.rvm/gems/ruby-2.2.0@global/bin:/Users/mspiosteam/.rvm/rubies/ruby-2.2.0/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/git/bin:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin:/Applications/android-sdk-macosx/tools:/Applications/android-sdk-macosx/platform-tools:/Users/mspiosteam/.rvm/bin:/Users/mspiosteam/libimobiledevice-macosx:/Applications/android-sdk-macosx:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin:/Applications/android-sdk-macosx/tools:/Applications/android-sdk-macosx/platform-tools:/Users/mspiosteam/.rvm/bin");
          executor.setExitValue(1);
          executor.execute(command, env, (ExecuteResultHandler)resultHandler);
        } 
      } else if (localityType.equalsIgnoreCase("Hub")) {
        String nodePath_windows = getPropertyValue("nodePath_windows");
        String appiumJSPath_windows = getPropertyValue("appiumJSPath_windows");
        System.out.println("nodePath_windows" + nodePath_windows);
        System.out.println("appiumJSPath_windows" + appiumJSPath_windows);
        CommandLine command = new CommandLine(nodePath_windows);
        command.addArgument(appiumJSPath_windows, false);
        command.addArgument("--address", false);
        command.addArgument("127.0.0.1");
        command.addArgument("--port", false);
        command.addArgument(port);
        command.addArgument("--no-reset", false);
        command.addArgument("--session-override", false);
        command.addArgument("-U", false);
        command.addArgument(udid);
        command.addArgument("--bootstrap-port", false);
        command.addArgument(bootStrapPort);
        command.addArgument("--chromedriver-port", false);
        command.addArgument(chromePort);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        if (platform_name.equalsIgnoreCase("android")) {
          executor.setExitValue(1);
          System.out.println("appium server" + appiumJSPath_windows);
          Thread.sleep(10000L);
          executor.execute(command, (ExecuteResultHandler)resultHandler);
          Thread.sleep(10000L);
        } else {
          command.addArgument("--udid", false);
          ProcessBuilder pb = new ProcessBuilder(new String[0]);
          Map<String, String> env = pb.environment();
          env.put("ANDROID_HOME", "C:\\Users\\426205\\AppData\\Local\\Android\\sdk");
          env.put("PATH", 
              "/Users/mspiosteam/.rvm/gems/ruby-2.2.0/bin:/Users/mspiosteam/.rvm/gems/ruby-2.2.0@global/bin:/Users/mspiosteam/.rvm/rubies/ruby-2.2.0/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Applications/android-sdk-macosx:/usr/local/git/bin:/usr/local/Cellar/libimobiledevice/1.2.0/bin:/Users/mspiosteam/.rvm/gems/ruby-2.2.0/bin:/Users/mspiosteam/.rvm/gems/ruby-2.2.0@global/bin:/Users/mspiosteam/.rvm/rubies/ruby-2.2.0/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/git/bin:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin:/Applications/android-sdk-macosx/tools:/Applications/android-sdk-macosx/platform-tools:/Users/mspiosteam/.rvm/bin:/Users/mspiosteam/libimobiledevice-macosx:/Applications/android-sdk-macosx:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin:/Applications/android-sdk-macosx/tools:/Applications/android-sdk-macosx/platform-tools:/Users/mspiosteam/.rvm/bin");
          executor.setExitValue(1);
          executor.execute(command, env, (ExecuteResultHandler)resultHandler);
        } 
      } 
      Thread.sleep(30000L);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static void stopServer() {
    try {
      System.out.println("Stop server");
      String filePath = "";
      String filePath1 = "";
      if (System.getProperty("os.name").contains("Win")) {
        filePath = "taskkill /F /IM node.exe";
        Runtime.getRuntime().exec(filePath);
        filePath1 = "taskkill /F /IM chromedriver.exe ";
        Runtime.getRuntime().exec(filePath1);
      } else {
        Runtime.getRuntime().exec(new String[] { "bash", "-c", "killall node" });
        Runtime.getRuntime().exec(new String[] { "bash", "-c", "killall chrome" });
        Runtime.getRuntime().exec(new String[] { "bash", "-c", "killall safari" });
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static String getPropertyValue(String key) throws IOException {
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
  
  public static void updateProperty(String updateTime, String startTime) {
    try {
      FileInputStream in = new FileInputStream("report.properties");
      Properties props = new Properties();
      props.load(in);
      in.close();
      FileOutputStream out = new FileOutputStream("report.properties");
      props.setProperty("TOTAL_TIME", totalTimeTaken.toString());
      props.setProperty("RUN_STARTED", startTime.toString());
      props.store(out, (String)null);
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}
