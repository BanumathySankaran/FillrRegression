package com.mop.qa.test.regression;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.FFA_HomePage;
import com.mop.qa.pageobject.FFA_Initialize_Native_App;
import com.mop.qa.test.testBase1.APIClient;
import com.mop.qa.test.testBase1.TestBase;

public class FFA_ValidateHomePageAPI extends TestBase{

	@Test
	public void FFA_ValidateHomePageAPI_TestCase() throws Exception {
		
		FFA_Initialize_Native_App initApplication  = new FFA_Initialize_Native_App(appiumDriver);
		FFA_HomePage homePage = new FFA_HomePage(appiumDriver);	
		ArrayList<String> listOfNamesAPI = new ArrayList<>();
		ArrayList<String> listOfNamesUI = new ArrayList<>();
		ArrayList<String> listOfNamesToAppendToAPIurl = new ArrayList<>();
		
		try {
			initApplication.initializeSetup();
			homePage.addNewLeagues(2,"FavoritesEndpt");
			listOfNamesUI = homePage.getTheFavTeamNamesFromUI();
			listOfNamesToAppendToAPIurl = homePage.formAPIurl(listOfNamesUI);
			APIClient apiClient = new APIClient();
			String favEndPoint = apiClient.replaceValInEndPointURL("FavoritesEndptFFA",listOfNamesToAppendToAPIurl,"HomePage");
			String responseFromHomePgAPI = apiClient.getRequestByUnirestAsString(favEndPoint, "", "");
			listOfNamesAPI = apiClient.formatStringAndgetValues(responseFromHomePgAPI,"name:");
			FFA_HomePage homePage1 = new FFA_HomePage(appiumDriver);
			homePage1.compareUIFavValuesWithAPI(listOfNamesUI, listOfNamesAPI);
			String oneEndPtVal = homePage1.selectOnlyOneLeague("FavoritesEndptFFA");		
			String endPtAfterRem = homePage1.removeOneOFFavLeaguesAndgetEndPt("FavoritesEndptFFA");
			apiClient.getResponseCode(oneEndPtVal);
			apiClient.getResponseCode(endPtAfterRem);
		}
		
		catch (Exception e) {

		}
	}

}
