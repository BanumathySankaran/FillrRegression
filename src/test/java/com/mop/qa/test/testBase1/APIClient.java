package com.mop.qa.test.testBase1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.http.client.utils.HttpClientUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mop.qa.pageobject.FFA_HomePage;


public class APIClient extends TestBase {
	FFA_HomePage homePage = new FFA_HomePage(appiumDriver);
  private BufferedReader b2;



public String getRequestByUnirestAsString(String apiEndPoint, String extractData, String name) throws Exception {

	String jsonList = null;
	String jsonText = "";
	String path = "";
	PageBase pageBase = new PageBase();
	String mhMediaName = pageBase.getAppProperties("ModifyHeader_MediaName");
	String mhMediaValue = pageBase.getAppProperties("ModifyHeader_MediaValue");
	String mhPostmanName = pageBase.getAppProperties("postmanName");
	String mhPostmanValue = pageBase.getAppProperties("postmanToken");
	try {
	
		HttpResponse<String> response = Unirest.get(apiEndPoint).header(mhMediaName, mhMediaValue)
				.header("cache-control", "no-cache").header(mhPostmanName, mhPostmanValue).asString(); 
		System.out.println("Status is : " + response.getStatus());
		System.out.println("Response Body is : " + (String) response.getBody());
		jsonText = (String) response.getBody();
		path = createJSONFile(jsonText, name);
		System.out.println("API JSON file created successfully, located at : " + path);
		pageBase.assertTrue("API JSON file created successfully located at : " + path);
		jsonList=jsonText;
		HttpClientUtils.closeQuietly((org.apache.http.HttpResponse) response);
	}
	catch (Exception e) {

	}
	return jsonList;
}


public void getResponseCode(String apiEndPoint) throws IOException, UnirestException {
		int status = 0;
		PageBase pageBase = new PageBase();
		String mhMediaName = pageBase.getAppProperties("ModifyHeader_MediaName");
		String mhMediaValue = pageBase.getAppProperties("ModifyHeader_MediaValue");
		String mhPostmanName = pageBase.getAppProperties("postmanName");
		String mhPostmanValue = pageBase.getAppProperties("postmanToken");	
			HttpResponse<String> response = Unirest.get(apiEndPoint).header(mhMediaName, mhMediaValue).header("cache-control", "no-cache").header(mhPostmanName, mhPostmanValue).asString(); 
			System.out.println("Status is : " + response.getStatus());
			status = response.getStatus();
			System.out.println("The end point is: " + apiEndPoint);
			Assert.assertTrue(status==200,"The response is 200");
}
  
  private String createJSONFile(String jsonText, String name) throws IOException {
    String ctPath = System.getProperty("user.dir");
    String filePath = String.valueOf(ctPath) + "\\jsonAPI\\File_" + name + "_" + getDateTime() + ".json";
    try {
      File fout = new File(filePath);
      FileOutputStream fos = new FileOutputStream(fout);
      OutputStreamWriter osw = new OutputStreamWriter(fos);
      osw.write(jsonText);
      osw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
    return filePath;
  }
  
  private String getDateTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    return sdf.format(ts);
  }
  

   
  
  
  public String fetchTheEndPoint(String param) throws IOException {
		String apiEndPoint = homePage.getAppProperties(param);
		System.out.println("end point is: " + apiEndPoint);
		return apiEndPoint;
	}
  
  
  
  public String replaceValInEndPointURL(String param1,ArrayList<String> valToAppend,String endpointType) throws Exception {
	  String valToAddToURL = null;
		String endPt1 = fetchTheEndPoint(param1);
		System.out.println("The size of the array is" + valToAppend.size());
		if(endpointType.equalsIgnoreCase("HomePage")) {
		if(valToAppend.size()==1) {
			endPt1 = endPt1.concat(valToAppend.get(0));
		}else {
		for(int i=0;i<=valToAppend.size()-1;i++) {
			if((i+1)<valToAppend.size()) {
			valToAddToURL = valToAppend.get(i).concat(",").concat(valToAppend.get(i+1)).replaceAll("\\s","");
			}
		}
		endPt1 = endPt1.concat(valToAddToURL);
		
		}
		}
		else if(endpointType.equalsIgnoreCase("fixturesAndResults")) {
			for(int i=0;i<=valToAppend.size()-1;i++) {
				if(i+2<valToAppend.size()) {
				endPt1 = endPt1.replace("league1", valToAppend.get(i)).replace("league2", valToAppend.get(i+1)).replace("league3", valToAppend.get(i+2));
				}
			}
		}
		System.out.println("The new url is: "+ endPt1);
		return endPt1;

	 }
  
	public String formatTheString(String teamNameAPI) {
		teamNameAPI = teamNameAPI.replaceAll("\"", "").replace(",", "").trim().toUpperCase();
		System.out.println("The formatted String is: "+ teamNameAPI);
		return teamNameAPI;
	}
	
	public String formatTheStringAndReturnAsString(String teamNameAPI) {
			teamNameAPI = teamNameAPI.replaceAll("\\{", ",").replaceAll("\\}", "").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "").replace("\n","");
		System.out.println("The formatted String is: "+ teamNameAPI);
		return teamNameAPI;
	}


	public ArrayList<String> formatStringAndgetValues(String valFromAPI, String valFromUI) {
		ArrayList<String> listOfNamesNew = new ArrayList<>();
		String listOfNames = formatTheStringAndReturnAsString(valFromAPI);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(listOfNames.split(",")));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(valFromUI)) {
				String nameOFLeague = list.get(i).replace("name:", "").replace("nick", "");
				listOfNamesNew.add(nameOFLeague);
			}
		}
		System.out.println("The League names' list is: " + listOfNamesNew);
		return listOfNamesNew;
	}
   
	
   

	  
	 @SuppressWarnings("resource")
	public ArrayList<String> readTxtFile(String name) throws IOException {
		  ArrayList<String> titleArrayJSONAPI = new ArrayList<String>();
		  String ctPath = System.getProperty("user.dir");
		  String filePath = String.valueOf(ctPath) + "\\matchesAPIData\\File_" + name + ".txt";
	      BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
	      String line = buffReader.readLine(); 
	      while (line != null) {
	            System.out.println(line);
	            titleArrayJSONAPI.add(line);
	            line = buffReader.readLine();	            
	      }

		 return titleArrayJSONAPI; 
	  }
	 
	 
	 

	public ArrayList<String> parseJSONFileNExtractTeamNameForAbbr(String path, String extractData, String name)
			throws ParseException, IOException {
		ArrayList<String> jsonList = new ArrayList<>();
		String[] titleCommaSep = null;
		File f = new File(path);
		b2 = new BufferedReader(new FileReader(f));
		String readLine = "";
		while ((readLine = b2.readLine()) != null) {
			if (name.contains("season")) {
				if (readLine.contains("name")) {
					System.out.println(readLine);
					titleCommaSep = readLine.split("name\" :");
					jsonList.add(titleCommaSep[1].trim().replaceAll("\"", "").replaceAll(",", ""));
					continue;
				}
				if (readLine.contains(extractData)) {
					System.out.println(readLine);
					titleCommaSep = readLine.split("abbr\" :");
					jsonList.add(titleCommaSep[1].trim().replaceAll("\"", "").replaceAll(",", ""));
				}
			}
		}
		jsonList.removeAll(Collections.singleton(null));
		return jsonList;
	}
	
	
	public ArrayList<String> parseJSONFileNExtractAbbrRoundNumAbbr(String path, String extractData, String name)
			throws ParseException, IOException {
		ArrayList<String> jsonList = new ArrayList<>();
		String[] titleCommaSep = null;
		File f = new File(path);
		b2 = new BufferedReader(new FileReader(f));
		String readLine = "";
		while ((readLine = b2.readLine()) != null) {
			if (name.contains("season")) {
				if (readLine.contains("abbreviation")) {
					System.out.println(readLine);
					titleCommaSep = readLine.split("abbreviation\" :");
					titleCommaSep[1] = titleCommaSep[1].replaceAll("\"", "").replaceAll(",", "");
					jsonList.add(titleCommaSep[1].trim());
					continue;
				}
				if (readLine.contains(extractData)) {
					System.out.println(readLine);
					titleCommaSep = readLine.split("roundNumber\" :");
					titleCommaSep[1] = titleCommaSep[1].replaceAll("\"", "").replaceAll(",", "");
					jsonList.add(titleCommaSep[1].trim());
				}
			}
		}
		jsonList.removeAll(Collections.singleton(null));
		return jsonList;
	}
	
	
    public void createTextFileFromArray(ArrayList<String> arrayOfAbbr,String name) throws IOException {
	    String ctPath = System.getProperty("user.dir");
	    String filePath = String.valueOf(ctPath) + "\\matchesAPIData\\File_" + name + ".txt";
	      File fout = new File(filePath);
	      FileOutputStream fos = new FileOutputStream(fout);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
	      for(int i=0;i<arrayOfAbbr.size();i++) {
	    	  osw.write(arrayOfAbbr.get(i));
	    	  osw.append("\n");
	      }
	      osw.close();
	}
    
	
    public ArrayList<String> changeAbbrToTeam(ArrayList<String> UIVal,ArrayList<String>abbrJSONAPI) {
		ArrayList<String> newValUI = new ArrayList<String>();
		if (PageBase.platform_Name.equalsIgnoreCase("Android")) {
			String teams = UIVal.get(0);
			String splitHomeAwayAbbr[] = teams.split("v");
			if(abbrJSONAPI.contains(splitHomeAwayAbbr[0]) && abbrJSONAPI.contains(splitHomeAwayAbbr[1])) {
				String teamFromAbbr = abbrJSONAPI.get(abbrJSONAPI.indexOf(splitHomeAwayAbbr[0])-1);
				String awayteamFromAbbr = abbrJSONAPI.get(abbrJSONAPI.indexOf(splitHomeAwayAbbr[1])-1);
				String totalVal = teamFromAbbr.concat(" ").concat("v").concat(" ").concat(awayteamFromAbbr);
				newValUI.add(totalVal);
			}
			newValUI.add(UIVal.get(1));		
		}
		return newValUI;
	}
    
    
    
	public ArrayList<String> formatThearrayandSeperateTitle(ArrayList<String> jsonResponse, String pageType) {
		ArrayList<String> newArray = new ArrayList<>();
		ArrayList<String> newArray2 = new ArrayList<>();
		for (String element : jsonResponse) {
			element = element.replace("\"", "").replace(",", "");
			newArray.add(element.trim());
		}
		newArray.removeAll(Collections.singleton(null));
		if (pageType.equalsIgnoreCase("videoPage")) {
			for (String item : newArray) {
				if (Character.isUpperCase(item.charAt(0)) && (item.length() > 4)) {
					newArray2.add(item);
				}
			}
		}	else {
			newArray2=newArray;
		}
		return newArray2;
	}
	
	public ArrayList<String> getRequestByUnirestAndParseJson(String apiEndPoint, String apiType)
			throws UnirestException, IOException, ParseException, Exception {
		String jsonText = "";
		ArrayList<String> jsonList = new ArrayList<>();
		PageBase pageBase = new PageBase();
		String mhMediaName = pageBase.getAppProperties("ModifyHeader_MediaName");
		String mhMediaValue = pageBase.getAppProperties("ModifyHeader_MediaValue");
		String mhPostmanName = pageBase.getAppProperties("postmanName");
		String mhPostmanValue = pageBase.getAppProperties("postmanToken");
		HttpResponse<String> response = Unirest.get(apiEndPoint).header(mhMediaName, mhMediaValue)
				.header("cache-control", "no-cache").header(mhPostmanName, mhPostmanValue).asString();
		System.out.println("Status is : " + response.getStatus());
		System.out.println("Response Body is : " + (String) response.getBody());
		jsonText = (String) response.getBody();
		JSONObject jsonObject = new JSONObject(jsonText);
		if (apiType.equalsIgnoreCase("general")) {
			jsonList = methodForGeneralAPIEndPt(jsonList, jsonObject);
		}else if(apiType.equalsIgnoreCase("summaryOrFixEndPt")) {
			jsonList = extractRoundValue(jsonList, jsonObject);
		}
		//HttpClientUtils.closeQuietly((org.apache.http.HttpResponse) response);
		return jsonList;
	}


	private ArrayList<String> extractRoundValue(ArrayList<String> jsonList, JSONObject jsonObject) {
		JSONObject result = jsonObject.getJSONObject("round_info");
		for (int i = 0; i < result.length(); i++) {
		JSONObject rndObj = result.getJSONObject("active_round");
			String roundID = rndObj.getString("abbr");
			jsonList.add(roundID);
		}
			return jsonList;
	}


	private ArrayList<String> methodForGeneralAPIEndPt(ArrayList<String> jsonList, JSONObject jsonObject) {
		JSONArray result = jsonObject.getJSONArray("hub_configuration");
		for (int i = 0; i < result.length(); i++) {
			JSONObject result1 = result.getJSONObject(i);
			if (result1.has("active_season")) {
				String seasonVal = result1.getString("active_season");
				jsonList.add(seasonVal);
			}
			if (result1.has("competition_id")) {
				String compId = result1.getString("competition_id");
				System.out.println("The field val is: " + compId);
				jsonList.add(compId);
			}
			if (result1.has("team_id")) {
				String teamID = result1.getString("team_id");
				System.out.println("The field val is: " + teamID);
				jsonList.add(teamID);
			}
			String nameOfLeag = result1.getString("long_name");
			System.out.println("The field val is: " + nameOfLeag);
			jsonList.add(nameOfLeag);
		}
		return jsonList;
	}



}
