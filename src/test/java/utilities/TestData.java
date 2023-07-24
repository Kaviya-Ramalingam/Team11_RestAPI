package utilities;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import stepdefinition.PostRequestSteps;

public class TestData {
	

	public  HashMap<String,Object> programPayload(String testcasename,String sheetname) throws IOException
	{
		
		
		List<String> data=ExcelUtility.getData(testcasename,sheetname);
		Random randomNum = new Random();
		String prog_name="Jul23-GoogleSurvivors-SDET-"+randomNum.nextInt();
		
		
		HashMap<String,Object> programdata=new HashMap<String, Object>();
		
		programdata.put("programName",prog_name);
		programdata.put("programDescription",data.get(1));
		programdata.put("programStatus",data.get(2));
		
		
		System.out.println(programdata);
		return programdata;
	}
	
	public  HashMap<String,Object> BatchPayload(String testcasename,String sheetname) throws IOException
	{
		
		
		List<String> data=ExcelUtility.getData(testcasename,sheetname);
		Random randomNum = new Random();
		String batch_name="Jul23-GoogleSurvivors-SDET-SDET01-"+randomNum.nextInt();
		
		
		HashMap<String,Object> batchdata=new HashMap<String, Object>();
		
		batchdata.put("batchName",batch_name);
		batchdata.put("batchDescription",data.get(1));
		batchdata.put("batchStatus",data.get(2));
		batchdata.put("batchNoOfClasses",data.get(3));
		
		batchdata.put("programId",PostRequestSteps.progID_env);
		
		System.out.println(batchdata);
		return batchdata;
	}
	
	public  HashMap<String,Object> UserPayload(String testcasename,String sheetname) throws IOException
	{
		
		
		List<String> data=ExcelUtility.getData(testcasename,sheetname);
		Random randomNum = new Random();
		String User_name="GoogleSurvivors-"+randomNum.nextInt();
	
	int phone=randomNum.nextInt(10);
		HashMap<String,Object> map=new HashMap<String, Object>();
		
		map.put("roleId",data.get(12));
		map.put("userRoleStatus",data.get(13));
		
		HashMap<String,Object> userdata=new HashMap<String, Object>();
		
		userdata.put("userComments",data.get(1));
		userdata.put("userEduPg",data.get(2));
		userdata.put("userEduUg",data.get(3));
		userdata.put("userFirstName",User_name);
		
		userdata.put("userLastName",data.get(4));
		userdata.put("userLinkedinUrl",data.get(5));
		userdata.put("userLocation",data.get(6));
		userdata.put("userMiddleName",data.get(8));
		userdata.put("userPhoneNumber",phone);
		userdata.put("userRoleMaps",map);
		
		userdata.put("userTimeZone",data.get(16));
		userdata.put("userVisaStatus",data.get(20));
		System.out.println(userdata);
	
		return userdata;
	}

}
