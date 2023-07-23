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
		
		ExcelUtility d=new ExcelUtility();
		List<String> data=d.getData(testcasename,sheetname);
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
		
		ExcelUtility d=new ExcelUtility();
		List<String> data=d.getData(testcasename,sheetname);
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

}
