package utilities;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;


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
	
	public  HashMap<String, Object> UserPayload(String testcasename,String sheetname) throws IOException
	{
		
		
		List<String> data=ExcelUtility.getData(testcasename,sheetname);
		Random randomNum = new Random();
		String User_name="GoogleSurvivors-"+randomNum.nextInt(10);
		
		int num1,num2,num3;
		num1=randomNum.nextInt(900)+100;
		num2=randomNum.nextInt(643)+100;
		num3=randomNum.nextInt(9000)+1000;
		String phonenumber=String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3);
		
		HashMap<String,Object> userdata=new HashMap<String,Object>();
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("roleId",data.get(12));
		map.put("userRoleStatus",data.get(13));
		
		Object[] maparray=new Object[1];
		maparray[0]=map;
		
		userdata.put("userComments",data.get(1));
		userdata.put("userEduPg",data.get(2));
		userdata.put("userEduUg",data.get(3));
		userdata.put("userFirstName",User_name);
		
		userdata.put("userLastName",data.get(4));
		userdata.put("userLinkedinUrl",data.get(5));
		userdata.put("userLocation",data.get(6));
		userdata.put("userMiddleName",data.get(8));
		userdata.put("userPhoneNumber",phonenumber);
					
		userdata.put("userRoleMaps",maparray);
		
		userdata.put("userTimeZone",data.get(16));
		userdata.put("userVisaStatus",data.get(20));
		
		System.out.println(userdata);
	
		return userdata;
	}
	public  HashMap<String, Object> AssignPayload(String testcasename,String sheetname) throws IOException
	{
		
		List<String> data=ExcelUtility.getData(testcasename,sheetname);
		Random randomNum = new Random();
		String Ass_name="Jul23-GoogleSurvivors-SDET-RestAPI-"+randomNum.nextInt();
		
	 final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 Calendar cal = Calendar.getInstance();
	 cal.setTimeInMillis(timestamp.getTime());
	    cal.add(Calendar.DAY_OF_MONTH,5);
	    timestamp = new Timestamp(cal.getTime().getTime());
	    System.out.println(timestamp);
	    
		
		HashMap<String,Object> assdata=new HashMap<String, Object>();
		
		assdata.put("assignmentDescription",data.get(1));
		assdata.put("assignmentName",Ass_name);
		assdata.put("batchId",PostRequestSteps.bacthId_env);
		assdata.put("comments",data.get(7));
		
		assdata.put("createdBy",PostRequestSteps.userId_env);
		
		assdata.put("dueDate",sdf.format(timestamp));
		assdata.put("graderId",PostRequestSteps.userId_env);
		assdata.put("pathAttachment1",data.get(2));
		assdata.put("pathAttachment2",data.get(3));
		assdata.put("pathAttachment3",data.get(4));
		assdata.put("pathAttachment4",data.get(5));
		assdata.put("pathAttachment5",data.get(6));
		
		System.out.println(assdata);
		return assdata;
	}
	
}
