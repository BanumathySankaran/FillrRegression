package com.mop.qa.test.Utilities;

public class TestParameter {
	  private String toolName;
	  
	  private String testName;
	  
	  private String browser;
	  
	  private String appType;
	  
	  private String locality;
	  
	  private String remoteUrl;
	  
	  private String executionType;
	  
	  private String platformName;
	  
	  private String udid;
	  
	  private String deviceName;
	  
	  private String port;
	  
	  private String no_of_devices;
	  
	  private String bootstrap_port;
	  
	  private String No_of_Instances;
	  
	  private String chrome_port;
	  
	  private String testClass;
	  
	  private String ExcetionFlag;
	  
	  private String OriName;
	  
	  public String getTestName() {
	    return this.testName;
	  }
	  
	  public void setTestName(String testName1) {
	    this.testName = testName1;
	  }
	  
	  public String getTestClass() {
	    return this.testClass;
	  }
	  
	  public void setAppType(String appType) {
	    this.appType = appType;
	  }
	  
	  public String getAppType() {
	    return this.appType;
	  }
	  
	  public void setTestClass(String testClass1) {
	    this.testClass = testClass1;
	  }
	  
	  public String getExcetionFlag() {
	    return this.ExcetionFlag;
	  }
	  
	  public void setExcetionFlag(String excetionFlag) {
	    this.ExcetionFlag = excetionFlag;
	  }
	  
	  public String getPlatformName() {
	    return this.platformName;
	  }
	  
	  public void setPlatformName(String platformName) {
	    this.platformName = platformName;
	  }
	  
	  public String getUdid() {
	    return this.udid;
	  }
	  
	  public void setUdid(String udid) {
	    this.udid = udid;
	  }
	  
	  public String getDeviceName() {
	    return this.deviceName;
	  }
	  
	  public void setDeviceName(String deviceName) {
	    this.deviceName = deviceName;
	  }
	  
	  public void setRemoteUrl(String remoteUrl) {
	    this.remoteUrl = remoteUrl;
	  }
	  
	  public String getPort() {
	    return this.port;
	  }
	  
	  public void setPort(String port) {
	    this.port = port;
	  }
	  
	  public String getNo_Of_Instances() {
	    String NoOfInstances = "";
	    if (this.No_of_Instances.equalsIgnoreCase("One")) {
	      NoOfInstances = "1";
	    } else if (this.No_of_Instances.equalsIgnoreCase("Two")) {
	      NoOfInstances = "2";
	    } else if (this.No_of_Instances.equalsIgnoreCase("Three")) {
	      NoOfInstances = "3";
	    } 
	    return NoOfInstances;
	  }
	  
	  public void setNo_Of_Instances(String no_of_Instances) {
	    this.No_of_Instances = no_of_Instances;
	  }
	  
	  public String getBootstrap_port() {
	    return this.bootstrap_port;
	  }
	  
	  public void setBootstrap_port(String bootstrap_port) {
	    this.bootstrap_port = bootstrap_port;
	  }
	  
	  public String getRemoteUrl() {
	    return this.remoteUrl;
	  }
	  
	  public String getChrome_port() {
	    return this.chrome_port;
	  }
	  
	  public void setChrome_port(String chrome_port) {
	    this.chrome_port = chrome_port;
	  }
	  
	  public String getNo_of_devices() {
	    return this.no_of_devices;
	  }
	  
	  public void setNo_of_devices(String no_of_devices) {
	    this.no_of_devices = no_of_devices;
	  }
	  
	  public String getExecutionType() {
	    return this.executionType;
	  }
	  
	  public void setExecutionType(String executionType) {
	    this.executionType = executionType;
	  }
	  
	  public String getBrowser() {
	    return this.browser;
	  }
	  
	  public void setBrowser(String browser) {
	    this.browser = browser;
	  }
	  
	  public String getToolName() {
	    return this.toolName;
	  }
	  
	  public void setToolName(String toolName) {
	    this.toolName = toolName;
	  }
	  
	  public String getLocality() {
	    return this.locality;
	  }
	  
	  public void setLocality(String locality) {
	    this.locality = locality;
	  }
	  
	  public void TestParameter1(String testName1, String testClass1) {
	    this.testName = testName1;
	    this.testClass = testClass1;
	  }
	  
	  public void setTestName1(String oriName) {
	    this.OriName = oriName;
	  }
	  
	  public String getTestName1() {
	    return this.OriName;
	  }
	}
