package com.mop.qa.test.Utilities;

import com.mop.qa.test.testBase1.PageBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ExtentUtility {
  public static ExtentTest test;
  
  public static ExtentReports extent;
  
  public static String reportFolder = "";
  
  static Map extentTestMap = new HashMap<>();
  
  @SuppressWarnings("resource")
public static synchronized ExtentReports getReporter() throws IOException {
    PageBase pageBase = new PageBase();
    String os = "", udid = "", deviceName = "", build = "";
    String platfrmDet = null;
	  String ctPath = System.getProperty("user.dir");
	  String filePath = String.valueOf(ctPath) + "\\extentRepData\\dataForRep.txt";
    BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
    String line = buffReader.readLine(); 
    while (line != null) {
          System.out.println(line);
          platfrmDet = line;
          break;
    }
    String[] deviceDet = platfrmDet.split(",");
    if(deviceDet[0].equalsIgnoreCase("iOS")) {
        os = pageBase.getAppProperties("report_Environment");
        udid = deviceDet[1].replace("udid", "");
        deviceName = deviceDet[2].replace("deviceName", "");
        build = pageBase.getAppProperties("report_BuildiOS");
    }
    else if(deviceDet[0].equalsIgnoreCase("Android")) {
      os = pageBase.getAppProperties("report_EnvironmentAndr");
      udid = deviceDet[1].replace("udid", "");
      deviceName = deviceDet[2].replace("deviceName", "");
      build = pageBase.getAppProperties("report_Build");
    }

    if (extent == null) {
/*      SimpleDateFormat sdfDateReport = new SimpleDateFormat(
          "yyyy-MM-dd-HH-mm-ss");*/
      reportFolder = "HtmlReport";
      String s = (new File("ReportGenerator/" + reportFolder + "/TestReport.html")).getPath();
      extent = new ExtentReports(s, Boolean.valueOf(true), Locale.ENGLISH);
      extent.addSystemInfo("Execution Environment", os);
      extent.addSystemInfo("Device Name", deviceName);
      extent.addSystemInfo("Device UDID", udid);
      extent.addSystemInfo("Application Build", build);
      extent.assignProject("AFL Automation Project");
    }
    return extent;
    }

  
  public static synchronized ExtentTest getTest() {
    return (ExtentTest)extentTestMap.get(Integer.valueOf((int)Thread.currentThread().getId()));
  }
  
  public static synchronized void endTest() {
    extent.endTest((ExtentTest)extentTestMap.get(Integer.valueOf((int)Thread.currentThread().getId())));
  }
  
  public static synchronized ExtentTest startTest(String testName) {
    return startTest(testName, "");
  }
  
  public static synchronized ExtentTest startTest(String testName, String desc) {
    ExtentTest test = extent.startTest(testName, desc);
    extentTestMap.put(Integer.valueOf((int)Thread.currentThread().getId()), test);
    return test;
  }
}
