package com.mop.qa.test.regression;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.FFA_HomePage;
import com.mop.qa.pageobject.FFA_Initialize_Native_App;
import com.mop.qa.test.testBase1.APIClient;
import com.mop.qa.test.testBase1.TestBase;

public class FFA_ValidateAllMatches extends TestBase {
	@Test
	public void FFA_ValidateAllMatches_TestCase() throws Exception {
		System.out.println("TestCase Title : Validate FFA All Matches : Started .....");
		FFA_Initialize_Native_App initApplication  = new FFA_Initialize_Native_App(appiumDriver);
		FFA_HomePage homePage = new FFA_HomePage(appiumDriver);	
		ArrayList<String> listOfNamesAPI = new ArrayList<>();
		ArrayList<String> listOfNamesUI = new ArrayList<>();
		ArrayList<String> listOfNamesToAppendToAPIurl = new ArrayList<>();
		ArrayList<String> listOfcompIDToAppendToAPIurl = new ArrayList<>();
		ArrayList<String> roundValuesFromAPI = new ArrayList<>();

		
		try {
			initApplication.initializeSetup();
			homePage.tapOnAllMatches();
			homePage.addTheMatchesToFav(3,"fixturesAndResults");
			listOfNamesUI = homePage.getTheFavTeamNamesFromUI();
			String roundValFromUI = homePage.clickOnOneLeagueAndCheckRoundNo(listOfNamesUI);
			listOfNamesToAppendToAPIurl = homePage.formAPIurl(listOfNamesUI);			
			APIClient apiClient = new APIClient();
			String favEndPoint = apiClient.replaceValInEndPointURL("fixturesAndResultsEndPtFFA",listOfNamesToAppendToAPIurl,"fixturesAndResults");
			String responseFromHomePgAPI = apiClient.getRequestByUnirestAsString(favEndPoint, "", "");
			apiClient.getResponseCode(favEndPoint);
			listOfNamesAPI = apiClient.formatStringAndgetValues(responseFromHomePgAPI,"name:");
			String endPt1 = apiClient.fetchTheEndPoint("generalEndPtFixAndResults");
			listOfcompIDToAppendToAPIurl = apiClient.getRequestByUnirestAndParseJson(endPt1,"general");
			FFA_HomePage homePage1 = new FFA_HomePage(appiumDriver);
			homePage1.compareUIFavValuesWithAPI(listOfNamesUI, listOfNamesAPI);
			String sumOrFixEndPt = homePage1.buildURLForFixtures(listOfNamesUI,listOfcompIDToAppendToAPIurl);
			apiClient.getResponseCode(sumOrFixEndPt);	
			roundValuesFromAPI = apiClient.getRequestByUnirestAndParseJson(sumOrFixEndPt, "summaryOrFixEndPt");
			FFA_HomePage homePage2 = new FFA_HomePage(appiumDriver);
			homePage2.compareUIFavValWithAPIForStringFromUI(roundValFromUI,roundValuesFromAPI);
		}catch (Exception e) {

		}
}
}
