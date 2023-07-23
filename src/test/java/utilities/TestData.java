package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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

}
