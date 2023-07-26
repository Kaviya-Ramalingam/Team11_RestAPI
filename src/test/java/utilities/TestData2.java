package utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import stepdefinition.PostRequestSteps;

public class TestData2 {
	
	ExcelUtility e2=new ExcelUtility("./src/test/resources/Response_data.xlsx");
	public  HashMap<String,Object> programPut(String testcaseName,String sheetname) throws IOException
	{
		
		
		//List<String> data=e2.getData(testcaseName,sheetname);
		Random randomNum = new Random();
		String prog_name="Jul23-GoogleSurvivors-SDET-"+randomNum.nextInt(10);
		String prog_Des="Jul23-GoogleSurvivors-SDET-"+randomNum.nextInt(10);
		
		HashMap<String,Object> programdataput=new HashMap<String, Object>();
		programdataput.put("programDescription",prog_Des);
		
		programdataput.put("programName",prog_name);
		programdataput.put("programStatus","active");
		
		
		System.out.println(programdataput);
		return programdataput;
	}
	
	public  HashMap<String, Object> UserPut(String testcaseName,String Sheetname) throws IOException
	{
		List<String> data=e2.getData(testcaseName,Sheetname);
		Random randomNum = new Random();
		String User_name="GoogleSurvivors-"+randomNum.nextInt(10);
		int num1,num2,num3;
		num1=randomNum.nextInt(900)+100;
		num2=randomNum.nextInt(643)+100;
		num3=randomNum.nextInt(9000)+1000;
		String phonenumber=String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3);
		HashMap<String,Object> userdataput=new HashMap<String,Object>();
		userdataput.put("userComments",data.get(11));
		userdataput.put("userEduPg",data.get(10));
		userdataput.put("userEduUg",data.get(9));
		userdataput.put("userFirstName",User_name);
		userdataput.put("userLastName",data.get(3));
		userdataput.put("userId", data.get(1));
		userdataput.put("userLinkedinUrl",data.get(8));
		userdataput.put("userLocation",data.get(6));
		userdataput.put("userMiddleName",data.get(4));
		userdataput.put("userPhoneNumber",phonenumber);
		userdataput.put("userTimeZone",data.get(7));
		userdataput.put("userVisaStatus",data.get(12));
		
		System.out.println(userdataput);
	
		return userdataput;
	}
	
	//call from get
	public  HashMap<String, Object> UserPutprogbathstatus(String testcaseName,String Sheetname) throws IOException
	{
		
		
		HashMap<String,Object> parent=new HashMap<String,Object>();
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("batchId","7259");
		map.put("userRoleProgramBatchStatus","active");
		
		Object[] maparray=new Object[1];
		maparray[0]=map;
		
		parent.put("programId",10689);
		parent.put("roleId","7980");
		parent.put("userId","U7876");
		parent.put("userRoleProgramBatches",maparray);
		
		
		System.out.println(parent);
	
		return parent;
	}
	//get request
	public  HashMap<String, Object> Updaterolestatus(String testcaseName,String Sheetname) throws IOException
	{
		HashMap<String,Object> userdataput=new HashMap<String,Object>();
		userdataput.put("roleId","U7876");
		userdataput.put("userRoleStatus","online");
		System.out.println(userdataput);
		return userdataput;
	}
	public  HashMap<String, Object> ProgramPut(String testcaseName,String Sheetname) throws IOException
	{
	
		Random randomNum = new Random();
		String p_name="GoogleSurvivors-"+randomNum.nextInt(10);
		String p_desc="Sdet-"+randomNum.nextInt(10);
		HashMap<String,Object> progdataput=new HashMap<String,Object>();
		progdataput.put("programDescription",p_desc);
		progdataput.put("programId",PostRequestSteps.progID_env);
		progdataput.put("programName",p_name);
		progdataput.put("programStatus","active");
		System.out.println(progdataput);
		return progdataput;
	}
	
	
	public  HashMap<String, Object> batchPut(String testcaseName,String Sheetname) throws IOException
	{
		List<String> data=e2.getData(testcaseName,Sheetname);
		Random randomNum = new Random();
		String batch_name="Jul23-GoogleSurvivors-SDET-SDET01-"+randomNum.nextInt();
		HashMap<String,Object> batchdataput=new HashMap<String,Object>();
		batchdataput.put("batchDescription",data.get(1));
		batchdataput.put("batchId",data.get(2));
		batchdataput.put("batchName", batch_name);
		batchdataput.put("batchNoOfClasses",data.get(4));
		batchdataput.put("batchStatus",data.get(5));
		batchdataput.put("programId",data.get(6));
		batchdataput.put("programName",data.get(7));
		System.out.println(batchdataput);
		return batchdataput;
	}
	
	public  HashMap<String, Object> assignPut(String testcaseName,String Sheetname) throws IOException
	{
		List<String> data=e2.getData(testcaseName,Sheetname);
		HashMap<String,Object> assigndataput=new HashMap<String,Object>();
		assigndataput.put("assignmentDescription",data.get(1));
		assigndataput.put("assignmentId",data.get(2));
		assigndataput.put("assignmentName",data.get(3));
		assigndataput.put("batchId",data.get(4));
		assigndataput.put("comments","aaaa");
		assigndataput.put("createdBy",data.get(5));
		assigndataput.put("dueDate",data.get(6));
		assigndataput.put("graderId",data.get(7));
		assigndataput.put("pathAttachment1","/Users/srihari/API/file1.json");
		assigndataput.put("pathAttachment2","/Users/srihari/API/file2.json");
		assigndataput.put("pathAttachment3","/Users/srihari/API/file3.json");
		assigndataput.put("pathAttachment4","/Users/srihari/API/file4.json");
		assigndataput.put("pathAttachment5","/Users/srihari/API/file5.json");
		return assigndataput;
		
		
	}
	
}



