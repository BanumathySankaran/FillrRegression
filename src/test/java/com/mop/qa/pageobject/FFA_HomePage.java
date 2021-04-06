package com.mop.qa.pageobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mop.qa.test.testBase1.*;
import io.appium.java_client.AppiumDriver;

public class FFA_HomePage extends PageBase 
{

	public FFA_HomePage(AppiumDriver<?> appiumDriver) 
	{
		super(appiumDriver);
		init_elementsXpath();		
	}

	/*  ******************************************************************** */
	/*          Elements XPath Values                                        */
	/*  ******************************************************************** */
	
	String logoXpath1 = "//*[@text='MY FOOTBALL LIVE']";
	String logoXpath2 = null;
	String favoriteBar = null;
	String watchLiveVideoCont = null;
	String latestMatches = "//*[@text='LATEST MATCHES']";
	String latestMatchDet = null;
	String latestNews = "//*[@text='LATEST NEWS']";
	String latestNewsCont = null;
	String andrHeroNewsCont  = "//*[@id='content_hero_title']";
	String stats = "//*[@text='LEAGUE LEADERS']  | //*[@text='TOP GOAL SCORERS']";
	String statsCont = null;
	String featured = "//*[@text='FEATURED']";
	String featCont = "(//*[@text='FEATURED']/parent::*/following-sibling::*/child::*)[1]";
	String latestVideos = "//*[@text='LATEST VIDEOS']";
	String latestVidCont = null;
	String adMsgBanner = null;
	String editButton = null;
	String displayedLeague = null;
	String backButton = null;
	String addButton = null;
	String watchLive = "//*[@text='WATCH LIVE']";
	String clickOnVideoCont = null;
	String closeVideo = null;
	String allMatches = "//*[@text='ALL MATCHES']";
	String favourites = "//*[@text='Favourites']";
	String doneBtn = "//*[@text='Done']";
		
	/*  ******************************************************************** */
	/*  Methods to initialize Web element's Xpath based on the device OS     */
	/*  ******************************************************************** */	
    public void init_elementsXpath()
    {
    	if (platform_Name.equalsIgnoreCase("iOS"))
    	{
    		logoXpath2 = "//*[@text='magenta livePassLockupSignedIn']";
	    	favoriteBar = "//*[@class='UIACollectionView' and ./*[./*[./*[@class='UIAView']]]]";
	    	watchLiveVideoCont = "//*[@class='UIAView' and ./*[@text='WATCH LIVE']]";
	    	latestMatchDet = "(//*[@text='LATEST MATCHES']/parent::*/following-sibling::*)[1]";
	    	latestNewsCont = "//*[@text='LATEST NEWS']/parent::*/following-sibling::*//*[@text]";
	    	latestVidCont = "(//*[@text='LATEST VIDEOS']/parent::*/following-sibling::*/following-sibling::*/following-sibling::*)[1]";
			adMsgBanner = "";
			editButton = "//*[@text='Edit']";
			displayedLeague = "(//*[@text and (./preceding-sibling::* | ./following-sibling::*)[@class='UIAView']])[2]";
			backButton = "//*[@text='Back']";
			clickOnVideoCont = "//*[@text='FREE FOR TELSTRA MOBILE CUSTOMERS']";
			closeVideo = "//*[@text='Close video']";
			addButton = "(//*[@text='Add']/parent::*/child::*)[1]";
    	}
    	else if(platform_Name.equalsIgnoreCase("Android"))
    	{
    		logoXpath2 = "//*[@id='btn_live_pass']"; 
    		favoriteBar = "//*[@id='list']";
    		watchLiveVideoCont = "//*[@id='thumbnail']";
     		latestMatchDet = "//*[@text='LATEST MATCHES']/parent::*/following-sibling::*";
     		latestNewsCont = "//*[@id='content_title']";
     		statsCont = "//*[@text='LEAGUE LEADERS']/parent::*/following-sibling::*";
     		latestVidCont = "//*[@id='video_widget_imageview']";
			adMsgBanner = "//*[@id='add_team_favourites_banner']";
			editButton = "//*[@class='android.view.ViewGroup' and ./*[@id='logo'] and ./*[@text='Edit']]";
			displayedLeague = "(//*[@id='name'])[1]";
			backButton = "//*[@contentDescription='Back']";
			clickOnVideoCont = "//*[@class='android.widget.LinearLayout' and ./*[./*[@id='action_bar_root']]]";
			closeVideo = "//*[@id='close']";
			addButton = "//*[@text='Add']";
    	}
    }
	/*  ******************************************************************** */
	/*  Methods to to verify that the Home page is displayed                 */
	/*  ******************************************************************** */
	public void onHomePage() throws Exception 
	{	
		this.softWait(10);   
		try
		{	
			this.assertTrue(isElementDisplayed(4,logoXpath1,"FFA Home Page Logo"), "FFA Home Page Logo is displayed");
			this.assertTrue(isElementDisplayed(4,logoXpath2,"Telstra Logo"), "Telstra Logo is displayed");
			
		}catch (Exception e){System.out.println("exception  "+e.getMessage());}
		
	}
	
	public void checkIffavBarLiveStreamExists() throws Exception {
		try {
			this.softWait(10);
			this.assertTrue(isElementDisplayed(4,favoriteBar,"Favorite Bar"), "Favorite Bar is displayed");
			this.assertTrue(isElementDisplayed(4,watchLiveVideoCont,"Ad Hoc Live Video"), "Ad Hoc Live Video is displayed");
		} 
		
		catch (Exception e) {

		}
	}

	
	@SuppressWarnings({"unchecked" })
	public void homePgSections() throws Exception {
			this.swipeDownWithIf(latestMatches, 700, -15000);
			this.swipeDownForNTimes(1);
			this.assertTrue(isElementDisplayed(4,latestMatches,"Latest Matches"), "Latest Matches is displayed");
			this.assertTrue(isElementDisplayed(4,latestMatchDet,"Latest Match Details"), "Latest Match Details is displayed");
			this.scrollDownOrUpWithIfNew(latestNews, 500, "Down");
			this.assertTrue(isElementDisplayed(4,latestNews,"Latest News"), "Latest News is displayed");
			this.swipeDownForNTimes(1);
			if(platform_Name.equalsIgnoreCase("iOS")) {
			List<WebElement> newsContents = appiumDriver.findElements(By.xpath(latestNewsCont));
			assertTrue(newsContents.size()>3,"The latest news Contents are present");
			}
			else if(platform_Name.equalsIgnoreCase("Android")) {
				this.assertTrue(isElementDisplayed(4,andrHeroNewsCont,"Latest News Hero Content"), "Latest News Hero Content is displayed");
				this.swipeDownForNTimes(2);
				List<WebElement> newsContents = appiumDriver.findElements(By.xpath(latestNewsCont));
				assertTrue(newsContents.size()>1,"The latest news Contents are present");
				/*this.scrollDownOrUpWithIfNew(stats, 600, "Down");
				this.swipeDownForNTimes(1);
				this.assertTrue(isElementDisplayed(4,statsCont,"Stats Content"), "Stats Content is displayed");*/	
			}
			this.swipeDownWithIf(featured, 700, -15000);
			this.assertTrue(isElementDisplayed(4,featured,"Featured"), "Featured is displayed");
			this.swipeDownForNTimes(1);
			this.assertTrue(isElementDisplayed(4,featCont,"Featured Content"), "Featured Content is displayed");
			this.swipeDownWithIf(latestVideos, 700, -15000);
			this.assertTrue(isElementDisplayed(4,latestVideos,"latest Videos"), "latest Videos is displayed");
			this.swipeDownForNTimes(2);
			this.assertTrue(isElementDisplayed(4,latestVidCont,"latest Videos Content"), "latest Videos Content is displayed");
			this.scrollUpNnoOfTimes(2);
	}

	
	public void admessageBannerCheck() throws Exception {
		if(platform_Name.equalsIgnoreCase("Android")) {
			if(isElementDisplayed(4, adMsgBanner, "Message Baner")) {
		this.assertTrue(isElementDisplayed(4,adMsgBanner,"Message Banner"), "Message Banner is displayed");	
			}else {
				System.out.println("Message banner not found");
			}
		}	
	}

	@SuppressWarnings("unchecked")
	public void removeLeagues() throws Exception {
		String leagueXpth = null;
		ArrayList<String> favLeagueNames = new ArrayList<>();
		if (isElementDisplayed(4, addButton, "add button")) {
			System.out.println("No leagues to remove");
		} 

		if (platform_Name.equalsIgnoreCase("iOS")) {
			
			if (isElementDisplayed(5, editButton, "Edit Button"))
			{
				this.clickWithoutWait(editButton, "Edit Button");
				leagueXpth = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*/child::*/child::*[@text]";
				List<WebElement> activeLeagues = appiumDriver.findElements(By.xpath(leagueXpth));
				System.out.println("The size of favourites is: "+ activeLeagues.size());
				for(WebElement ele: activeLeagues) {
					favLeagueNames.add(ele.getText());
				}
				System.out.println("The size of the array is: "+ favLeagueNames.size());
				for(int i=0;i<favLeagueNames.size();i++) {
					String xpath = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*/child::*/child::*[@text='"+favLeagueNames.get(i)+"']/preceding-sibling::*/child::*[@class='UIAImage']";
					this.clickWithoutWait(xpath, "click on active leagues");
		}
				this.clickWithoutWait(doneBtn, "Done,back to home page");
		}
		}
		
		else if (platform_Name.equalsIgnoreCase("Android")) {
			this.softWait(5);
			this.scrollLeftOrRightForNTimesAtTop(1, 500, "Right");
			if (isElementDisplayed(5, editButton, "Edit Button"))
			{	
				this.clickWithoutWait(editButton, "Edit Button");
				leagueXpth = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*[@text]";
				List<WebElement> favLeaguesAndr = appiumDriver.findElements(By.xpath(leagueXpth));
				System.out.println("The size of favourites is: "+ favLeaguesAndr.size());
				for(WebElement ele: favLeaguesAndr) {
					if(!ele.getText().contains("REORDER") && !ele.getText().contains("Your Favourites")) {
					favLeagueNames.add(ele.getText());
					}
				}
				System.out.println("The size of the array is: "+ favLeagueNames.size());
				for(int i=0;i<favLeagueNames.size();i++) {
					String xpath = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*[@text='"+favLeagueNames.get(i)+"']";
					this.clickWithoutWait(xpath, "click on active leagues");
				}	
				this.clickWithoutWait(backButton, "back to home page");
			}

		System.out.println("all active leagues removed");
	}
	}
	
		

	
	
	
	@SuppressWarnings("unchecked")
	public void selLeagiOSWithoutCupOfNation() throws Exception {
		ArrayList<String> favListWithoutCupOfN = new ArrayList<>();
		String leagueXpth1 = "//*[@id='icon favouriteInactive']";
		List<WebElement> leagueListToAdd = appiumDriver.findElementsByXPath(leagueXpth1);
		for(WebElement textFromLeag:leagueListToAdd) {
			String text = textFromLeag.getText();
			if(text.equalsIgnoreCase("Cup of Nations")) {
				favListWithoutCupOfN.add(text);
			}
		}
		Random rand = new Random();	
		int n = rand.nextInt(favListWithoutCupOfN.size());
		for(int i=0; i<=favListWithoutCupOfN.size();i++) {
			if(n==i) {
				String nameOfLeag = "//*[@text='"+favListWithoutCupOfN.get(i)+"']/preceding-sibling::*";
				this.clickWithoutWait(nameOfLeag, "League name: "+nameOfLeag);
			}
			}		

	}
	

	public void addNewLeagues(int noOfLeag,String endPtType) throws Exception {
		ArrayList<String> listOfLeagues = new ArrayList<>();
		ArrayList<String> getTextFromListOfLeag = new ArrayList<>();
		Random rand = new Random();
		removeLeagues();
		this.clickWithoutWait(addButton, "click on Add");
		if (platform_Name.equalsIgnoreCase("iOS")) {
			List<WebElement> webElementList = new ArrayList<>();
			for (int i = 1; i < 7; i++) {
				String favToAddiOS = "((//*[@text='Competitions']/parent::*/following-sibling::*/child::*/child::*/child::*[@text])["+ i +"]/preceding-sibling::*/child::*[@class='UIAImage'])[1]";
				String onlyText = "(//*[@text='Competitions']/parent::*/following-sibling::*/child::*/child::*/child::*[@text])["+ i +"]";
				WebElement list = appiumDriver.findElement(By.xpath(favToAddiOS));
				if(!getText(list).equalsIgnoreCase("Cup of Nations") && endPtType.equalsIgnoreCase("fixturesAndResults")) {
				webElementList.add(list);
				getTextFromListOfLeag.add(getText(onlyText));
				}else {
					webElementList.add(list);
					getTextFromListOfLeag.add(getText(onlyText));
				}
			}
			System.out.println("size of list is: " + webElementList.size());
			int n = rand.nextInt(webElementList.size());
			String favToAddiOS = "((//*[@text='Competitions']/parent::*/following-sibling::*/child::*/child::*/child::*[@text])[" + n + "]/preceding-sibling::*/child::*[@class='UIAImage'])[1]";
			 String prevAddedLeagues = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*/child::*/child::*[@text]";
			 for (int count = 1; count <= noOfLeag; count++) {
			 switch (count) {
			 case 1:		
					if(n==0)  {		
						n = rand.nextInt(webElementList.size());
						Assert.assertTrue(n!=0,"The random value is not zero");
					}
					this.clickWithoutWait(favToAddiOS, "League is selected");
					break;
			 case 2:
				selLeague(getTextFromListOfLeag, prevAddedLeagues);
				 	break;
				 	
			 case 3:
				 selLeague(getTextFromListOfLeag, prevAddedLeagues);
			 } 
			 }

			this.clickWithoutWait(doneBtn, "Done,back to home page");
		}

		else if (platform_Name.equalsIgnoreCase("Android")) {
			ArrayList<String> addedElementsFound = new ArrayList<>();
			String favToAddAndr = null;
			for (int i = 1; i < 7; i++) {
				favToAddAndr = "(//*[@text='Competitions']/parent::*/following-sibling::*/child::*[@id='name'])[" + i + "]";
				String textFromLeague = getText(favToAddAndr);
				if (!textFromLeague.equalsIgnoreCase("Cup of Nations")
						&& endPtType.equalsIgnoreCase("fixturesAndResults")) {
					listOfLeagues.add(textFromLeague);
				}
			}
			for (int count = 1; count <= noOfLeag; count++) {
				switch (count) {
				case 1:
					 String alreadySel1 = selectLeagueAndroid(listOfLeagues);
					 addedElementsFound.add(alreadySel1);
					break;
				case 2:
					String selected2 = selLeagueAndr2(addedElementsFound);
					addedElementsFound.add(selected2);
					break;				
				case 3:
					selLeagueAndr2(addedElementsFound);	
				}
			}
			this.clickWithoutWait(backButton, "back to home page");
		}

	}
	
	
	
	

	private String selLeagueAndr2(ArrayList<String> addedElementsFound) throws Exception {
		String toRetSel2 = null;
		for (int i = 1; i <= 7; i++) {
			String favToAddAndr = "(//*[@text='Competitions']/parent::*/following-sibling::*/child::*[@id='name'])["+ i + "]";
			if(addedElementsFound.size()==1) {
			if(!getText(favToAddAndr).equalsIgnoreCase(addedElementsFound.get(0)) && !getText(favToAddAndr).equalsIgnoreCase("Cup of Nations")) {
				toRetSel2 = getText(favToAddAndr);
				this.clickWithoutWait(favToAddAndr, "Another Ele");
				break;
			}
			}else if(!addedElementsFound.contains(getText(favToAddAndr))){
				this.clickWithoutWait(favToAddAndr, "Another Ele");
				break;
			}
		}
		return toRetSel2;
	}

	
	
	
	@SuppressWarnings("unchecked")
	private void selLeague(ArrayList<String> getTextFromListOfLeag, String prevAddedLeagues) throws Exception {
		ArrayList<String> addedListOfLeag = new ArrayList<>();
		List<WebElement> listFormed = appiumDriver.findElements(By.xpath(prevAddedLeagues));
		for (WebElement ele : listFormed) {
			addedListOfLeag.add(getText(ele));
		}
		String singleEle = null;

		singleEle = getText(prevAddedLeagues);
		for (int i = 0; i <= getTextFromListOfLeag.size(); i++) {
			String favToAddiOS2 = "(//*[@text='Competitions']/parent::*/following-sibling::*/child::*/child::*/child::*[@text='"
					+ getTextFromListOfLeag.get(i) + "']/preceding-sibling::*/child::*[@class='UIAImage'])[1]";
			if (listFormed.size() == 1) {
				if (!singleEle.equalsIgnoreCase(getTextFromListOfLeag.get(i))) {
					this.clickWithoutWait(favToAddiOS2, "League is selected");
					break;
				}
			} 
			else if(!addedListOfLeag.contains(getTextFromListOfLeag.get(i))) {
					this.clickWithoutWait(favToAddiOS2, "League is selected");
					break;
				}

			}
		}

	
	
	private String selectLeagueAndroid(ArrayList<String> listOfLeagues) throws Exception {
		String leagVal = null;
		Random rand = new Random();	
		int n = rand.nextInt(listOfLeagues.size());
		String xPathToSelTeam = null;
		for(int i=0; i<listOfLeagues.size();i++) {
			xPathToSelTeam = "//*[@text='Competitions']/parent::*/following-sibling::*/child::*[@text='"+listOfLeagues.get(i)+"']";
			if(n==i) {
				leagVal = getText(xPathToSelTeam);
				this.clickWithoutWait(xPathToSelTeam, "League name: " + leagVal);
			}
		}
		return leagVal;
		}



	

	
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getTheFavTeamNamesFromUI() throws Exception {
		ArrayList<String> leagueNames = new ArrayList<String>();
		ArrayList<String> leagueNamesNew = new ArrayList<String>();
		String displayedLeagues = null;
		if (platform_Name.equalsIgnoreCase("iOS")) {
			for (int i = 1; i <= 6; i++) {
				displayedLeagues = "(//*[@text and (./preceding-sibling::* | ./following-sibling::*)[@class='UIAView']])["+ i + "]";
					leagueNames.add(getText(displayedLeagues));
			}
			if(leagueNames.contains("Edit")) {
				int x = leagueNames.indexOf("Edit");
				leagueNames.subList(x+1, leagueNames.size()).clear();
			}
			Set<String> set = new HashSet<>(leagueNames);
			leagueNames.removeAll(Collections.singleton(null));
			set.remove("Home");
			set.remove("Favourites");
			set.remove("Edit");
			leagueNamesNew.addAll(set);
			return leagueNamesNew;
		}

		else if (platform_Name.equalsIgnoreCase("Android")) {
			displayedLeagues = "//*[@id='name']";
			List<WebElement> leaguesDisp = appiumDriver.findElements(By.xpath(displayedLeagues));
			for (WebElement text : leaguesDisp) {
				leagueNames.add(getText(text));
			}
			Set<String> set = new HashSet<>(leagueNames);
			leagueNames.removeAll(Collections.singleton(null));
			set.remove("Favourites");
			set.remove("Edit");
			leagueNamesNew.addAll(set);

		}

		return leagueNamesNew;
	}
	
	
	
	public void compareUIFavValuesWithAPI(ArrayList<String> leagueNamesUI,ArrayList<String> leagueNamesAPI) throws Exception {
		for(int i=0;i<leagueNamesUI.size();i++) {
			if(leagueNamesAPI.contains(leagueNamesUI.get(i))){
			this.assertTrue(leagueNamesAPI.contains(leagueNamesUI.get(i)),"The UI Value is present in the API: " + leagueNamesUI.get(i));	
			}else {
				System.out.println("The league Name is not present: " + leagueNamesUI.get(i));
			}
	}
}

	public ArrayList<String> formAPIurl(ArrayList<String> valFromUI) {
		
		ArrayList<String> valFreshToAqppendToApI = new ArrayList<>();
		String leagValToAdd = null;
		for (int i = 0; i < valFromUI.size(); i++) {
			if (valFromUI.get(i).contains("National Premier League")) {
				leagValToAdd = valFromUI.get(i).trim().replaceAll("National Premier League", "npl").replaceAll("\\s", "");
				valFreshToAqppendToApI.add(leagValToAdd);
			}
			else if (valFromUI.get(i).contains("Foxtel")) {
				leagValToAdd = valFromUI.get(i).trim().replaceAll("Foxtel", "").replaceAll("\\s", "").replaceAll("^a-zA-Z0-9]", "").toLowerCase().replace("-", "");
				valFreshToAqppendToApI.add(leagValToAdd);
			}

			else if (valFromUI.get(i).contains("Westfield")) {
				leagValToAdd = valFromUI.get(i).trim().replaceAll("Westfield", "").replaceAll("\\s", "").replaceAll("^a-zA-Z0-9]", "").toLowerCase().replace("-", "");
				valFreshToAqppendToApI.add(leagValToAdd);
			}

			else if (valFromUI.get(i).contains("-")) {
				leagValToAdd = valFromUI.get(i).trim().replace("-", "").replaceAll("\\s", "").toLowerCase();
				valFreshToAqppendToApI.add(leagValToAdd);
			}
			
			else {
				leagValToAdd = valFromUI.get(i).trim().replaceAll("\\s", "").toLowerCase();
				valFreshToAqppendToApI.add(leagValToAdd);
			}
			
		}

		return valFreshToAqppendToApI;
	}
	
	public void verifyIfWidgetsContainNameOfFavLeagues() throws Exception {
		ArrayList<String> namesFromUI = getTheFavTeamNamesFromUI();
		System.out.println("The name list size is: " + namesFromUI.size());
		this.swipeDownWithIf(latestMatches, 700, -15000);
		this.swipeDownForNTimes(1);
		
	}
	
	public String selectOnlyOneLeague(String endpint) throws Exception {
		ArrayList<String> getLeagueValues = getTheFavTeamNamesFromUI();
		System.out.println("The size of the UI league values is: " + getLeagueValues.size());
		String getleagVal = getLeagueValues.get(0);		
		String xpathOneLeague = "//*[contains(text(),'"+getleagVal.trim()+"')]";
		this.clickWithoutWait(xpathOneLeague, "only one league to be clicked");
		String leagValToAdd = null;
		leagValToAdd = convertStringFromUIaccToAPI(getleagVal);
		String endpoint = getAppProperties("FavoritesEndptFFA");
		String onlyOneTeamendPt = endpoint.concat(leagValToAdd);
		return onlyOneTeamendPt;
	}
	
	
	private String convertStringFromUIaccToAPI(String getleagVal) {
		String leagValToAdd;
		if (getleagVal.contains("National Premier League")) {
			leagValToAdd = getleagVal.trim().replaceAll("National Premier League", "npl").replaceAll("\\s", "");
		}
		else if (getleagVal.contains("Foxtel")) {
			leagValToAdd = getleagVal.trim().replaceAll("Foxtel", "").replaceAll("\\s", "").replaceAll("^a-zA-Z0-9]", "").toLowerCase().replace("-", "");
		}

		else if (getleagVal.contains("Westfield")) {
			leagValToAdd = getleagVal.trim().replaceAll("Westfield", "").replaceAll("\\s", "").replaceAll("^a-zA-Z0-9]", "").toLowerCase().replace("-", "");

		}

		else if (getleagVal.contains("-")) {
			leagValToAdd = getleagVal.trim().replace("-", "").replaceAll("\\s", "").toLowerCase();

		}
		
		else {
			leagValToAdd = getleagVal.trim().replaceAll("\\s", "").toLowerCase();
		}
		return leagValToAdd;
	}

	@SuppressWarnings("unchecked")
	public String removeOneOFFavLeaguesAndgetEndPt(String endPoint) throws Exception {
		String leagueXpth = null;
		ArrayList<String> favLeagueNames = new ArrayList<>();
		this.clickWithoutWait(editButton, "click on Edit");
		if(platform_Name.equalsIgnoreCase("iOS")) {
			leagueXpth = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*/child::*/child::*[@text]";
			WebElement activeLeagues = appiumDriver.findElement(By.xpath(leagueXpth));
			this.clickWithoutWait(activeLeagues, "click on active teams");	
			this.clickWithoutWait(doneBtn, "Done,Back to home page");
				}
		 if (platform_Name.equalsIgnoreCase("Android")) {
				leagueXpth = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*[@text]";
				List<WebElement> favLeaguesAndr = appiumDriver.findElements(By.xpath(leagueXpth));
				System.out.println("The size of favourites is: "+ favLeaguesAndr.size());
				for(WebElement ele: favLeaguesAndr) {
					if(!ele.getText().contains("REORDER") && !ele.getText().contains("Your Favourites")) {
					favLeagueNames.add(ele.getText());
					}
				}
				System.out.println("The size of the array is: "+ favLeagueNames.size());
				for(int i=1;i<2;i++) {
					String xpath = "//*[@text='Competitions']/parent::*/preceding-sibling::*/child::*[@text='"+favLeagueNames.get(i)+"']";
					this.clickWithoutWait(xpath, "click on active leagues");
				}
				this.clickWithoutWait(backButton, "back to home page");
			}
		System.out.println("one of the leagues removed");
		
		 String endPtNew = selectOnlyOneLeague(endPoint);
		return endPtNew;
		} 
	
	
	
	public void checkLiveStream() throws Exception {
		this.clickWithoutWait(watchLive, "Watch Live");
		Thread.sleep(8000);
		appiumDriver.findElement(By.xpath(clickOnVideoCont)).click();
		appiumDriver.findElement(By.xpath(closeVideo)).click();
		System.out.println("Live Stream is closed");
		}
	
	public void tapOnAllMatches() throws Exception {
		this.swipeDownWithIf(allMatches, 700, -14000);
		this.clickWithoutWait(allMatches, "All matches");
	}
	
	public void addTheMatchesToFav(int noOfMatches,String endPtType) throws Exception {
		addNewLeagues(noOfMatches,endPtType);
		this.clickWithoutWait(favourites, "Favourites Button");
	}

	public String clickOnOneLeagueAndCheckRoundNo(ArrayList<String> leagueNamesDisplayed) throws Exception {
		String rdVal = null;
		String roundValue = null;
		String xpathFirst = "//*[@text='" + leagueNamesDisplayed.get(0) + "']";
		this.clickWithoutWait(xpathFirst, "First League");
		if (platform_Name.equalsIgnoreCase("iOS")) {
		if (getText(xpathFirst).contains("League")) {
			if (getText(xpathFirst).contains("National")) {
				String nationalLeag = "NPL";
				rdVal = "//*[@class='UIAView' and ./*[@text]]/child::*[contains(text(),'" + nationalLeag + "')]";
			} 
			else {
				rdVal = "((//*[@class='UIAView' and ./*[@text]])[10]/child::*[contains(text(),'League')])[2]";
			}
		}
		else {
			rdVal = "(//*[@class='UIAView' and ./*[@text]])[9]/child::*[contains(text(),'" + getText(xpathFirst) + "')]";
		}
		
		this.assertTrue(isElementDisplayed(5, rdVal, "Team name and rd no"), "Team name and rd no is displayed" + getText(rdVal));	
		roundValue = getText(rdVal).split("\\|")[1].trim();
/*		String ValToCheckCss = "(//*[contains(text(),'"+roundValue+"')])[1]";
		String colorOfEle = appiumDriver.findElement(By.xpath(ValToCheckCss)).getCssValue("color");
		System.out.println("The color of the element is: " + colorOfEle);*/
	}
		
		else if (platform_Name.equalsIgnoreCase("Android")) {
			String upperCaseLEag = getText(xpathFirst).toUpperCase();
			if (upperCaseLEag.contains("LEAGUE")) {
				if (upperCaseLEag.contains("NATIONAL")) {
					String nationalLeag = "NPL";
					rdVal = "//*[@class='android.view.ViewGroup' and ./*[@text]]/child::*[contains(text(),'"+nationalLeag+"')]";
				} 
				else {
					rdVal = "//*[@class='android.view.ViewGroup' and ./*[@text]]/child::*[contains(text(),'LEAGUE')]";
				}
			}
			else {
				rdVal = "(//*[@class='android.view.ViewGroup' and ./*[@text]])[5]/child::*[contains(text(),'" + upperCaseLEag + "')]";
			}
			this.assertTrue(isElementDisplayed(5, rdVal, "Team name and rd no"), "Team name and rd no is displayed" + getText(rdVal));
			roundValue = getText(rdVal).split("\\|")[1].trim();
			String rndVal1 = "(//*[@text='"+roundValue+"'])[1]";
			String valFromRoundIndic = "//*[@id='round_indicator']/preceding-sibling::*";
			this.assertTrue(getText(rndVal1).equalsIgnoreCase(getText(valFromRoundIndic)), "The current round is the same");
		}

		return roundValue;
	}
	
	
	
	public String buildURLForFixtures(ArrayList<String> leagueNamesDisplayed,ArrayList<String> valFromGenfixAPI) throws Exception {
		String sumEndPt = null;
		String xpathFirst = "//*[@text='" + leagueNamesDisplayed.get(0) + "']";
		String textFromFirstDisLeague = getText(xpathFirst);
		for(int i=0;i<valFromGenfixAPI.size();i++) {
			if(valFromGenfixAPI.get(i).contains(textFromFirstDisLeague)) {
				int indOfLeagName = valFromGenfixAPI.indexOf(textFromFirstDisLeague);
				if(textFromFirstDisLeague.contains("Socceroos")| textFromFirstDisLeague.contains("Matildas")) {
					int compID = indOfLeagName - 1;
					String teamID = valFromGenfixAPI.get(compID);
					String fixEndPt = getAppProperties("fixtureAPICall");
					fixEndPt = fixEndPt.replace("TeamID", teamID);
					fixEndPt = sumEndPt;
			}
				else {				
					int seasonInd = indOfLeagName - 2;
					int compID = indOfLeagName - 1;
					String seasonID  = valFromGenfixAPI.get(seasonInd);
					String competID = valFromGenfixAPI.get(compID);	
					sumEndPt = getAppProperties("summaryAPICall");
					sumEndPt = sumEndPt.replace("CompID", competID).replace("Season", seasonID);
				}
			}
		}
		return sumEndPt;
	}
	
	
	public void compareUIFavValWithAPIForStringFromUI(String UIVal, ArrayList<String> leagueNamesAPI) throws Exception {
		if (platform_Name.equalsIgnoreCase("Android")) {
			ArrayList<String> leagueNamesAPInew = new ArrayList<>();
			for (int i = 0; i < leagueNamesAPI.size(); i++) {
				String upperCaseLeagueNames = leagueNamesAPI.get(i).toUpperCase();
				leagueNamesAPInew.add(upperCaseLeagueNames);
			}

			for (int i = 0; i < leagueNamesAPInew.size(); i++) {
				if (leagueNamesAPI.get(i).contains(UIVal)) {
					this.assertTrue(leagueNamesAPI.get(i).contains(UIVal),
							"The UI Value is present in the API: " + UIVal);
				} else {
					System.out.println("The UI value is not present: " + UIVal);
				}
			}
		}

		else if (platform_Name.equalsIgnoreCase("iOS")) {
			for (int i = 0; i < leagueNamesAPI.size(); i++) {
				if (leagueNamesAPI.get(i).contains(UIVal)) {
					this.assertTrue(leagueNamesAPI.get(i).contains(UIVal),
							"The UI Value is present in the API: " + UIVal);
				} else {
					System.out.println("The UI value is not present: " + UIVal);
				}
			}
		}
	}
}
	
	


