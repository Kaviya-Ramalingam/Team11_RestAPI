package stepdefinition;


import static io.restassured.RestAssured.given;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.API_enum;
import utilities.ExcelWriter;
import utilities.TestData;
import utilities.Utils;


public class PostRequestSteps extends Utils {

	ResponseSpecification res1;
	RequestSpecification req1;
	Response response;
	
	public static String progname_env,progdes_env,progstatus_env,CreateTime_env,
	bacthId_env,bname_env,bdes_env,bclasses_env,bstatus_env,bpid_env,bpname_env,userId_env,AssignId_env,
							duedate_env,createdBy_env,assigndes_env,assignname_env;
	public static String progID_env,bid,gid;
	public static String userfirsname_env,userlastname_env,usermiddlename_env,phone,location,timezone,linkein,ug,pg,comment,visastatus;
	public static String submitID_env,subdate_env;
	TestData data=new TestData();
	ExcelWriter xlwrite = new ExcelWriter("./src/test/resources/Response_data.xlsx");
	
	@Given("User sets authorization to NO Auth")
	public void user_sets_authorization_to_NO_Auth()
	{
		given().auth().none();
	}

	//Create a program scenario steps
	
	
	@Given("user creates POST request for the LMS API endpoint from  {string} and {string}")
	public void user_creates_post_request_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException

	{
		
		req1 = given().spec(requestSpecification()).body(data.programPayload(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(201).build();

	
	}
	
	
	
	@When("user call {string} with {string} http request")
	public void user_call_with_http_request(String resource, String method)
	{
		
		API_enum resource_api = API_enum.valueOf(resource);
		if (method.equalsIgnoreCase("POST"))
		{
			
		response = req1.post(resource_api.getresource())
		.then()
		.log().all()
		.extract().response();
		}
	}
	
	@Then("API call is success with status code201")
	public void api_call_is_success_with_status_code201() {
		
	
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(201)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("programSchema.json"));
		
		
	}
	@Then("verify the programId in json Response body")
	public void verify_the_program_id_in_json_response_body() throws IOException
	{
		progID_env = getJsonPath(response, "programId");
		progname_env=getJsonPath(response, "programName");
		progdes_env=getJsonPath(response, "programDescription");
		progstatus_env=getJsonPath(response, "programStatus");
		CreateTime_env=getJsonPath(response, "creationTime");
		
		xlwrite.setcelldata("Response_Program",0,0,"testcaseName");
		xlwrite.setcelldata("Response_Program",0,1,"programId");
		xlwrite.setcelldata("Response_Program",0,2,"programName");
		xlwrite.setcelldata("Response_Program",0,3,"programDescription");
		xlwrite.setcelldata("Response_Program",0,4,"programStatus");
		//xlwrite.setcelldata("Response_Program",0,5,"creationTime");
		
		xlwrite.setcelldata("Response_Program",1,0,"Progput_1");
		xlwrite.setcelldata("Response_Program",1,1,progID_env);
		xlwrite.setcelldata("Response_Program",1,2,progname_env);
		xlwrite.setcelldata("Response_Program",1,3,progdes_env);
		xlwrite.setcelldata("Response_Program",1,4,progstatus_env);
		//xlwrite.setcelldata("Response_Program",1,5,CreateTime_env);
	   
	}
	
	/*** Batch Scenario steps ***/
	
	@Given("user creates Batch POST request for the LMS API endpoint from  {string} and {string}")
	public void user_creates_batch_post_request_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException {
		req1 = given().spec(requestSpecification()).body(data.BatchPayload(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(201).build();
	    
	}
	
	@Then("API call for batch is success with status code201")
	public void api_call_for_batch_is_success_with_status_code201() {
		
	
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(201)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("BatchSchema.json"));
		
		
	}
	@Then("verify the batchId in json Response body")
	public void verify_the_batch_id_in_json_response_body() throws IOException {
		bdes_env=getJsonPath(response, "batchDescription");
		bacthId_env = getJsonPath(response, "batchId");
		bname_env=getJsonPath(response, "batchName");
		bclasses_env=getJsonPath(response, "batchNoOfClasses");
		bstatus_env=getJsonPath(response, "batchStatus");
		bpid_env=getJsonPath(response, "programId");
		bpname_env=getJsonPath(response, "programName");
		
		
		xlwrite.setcelldata("Response_Batch",0,0,"testcaseName");
		xlwrite.setcelldata("Response_Batch",0,1,"batchDescription");
		xlwrite.setcelldata("Response_Batch",0,2,"batchId");
		xlwrite.setcelldata("Response_Batch",0,3,"batchName");
		xlwrite.setcelldata("Response_Batch",0,4,"batchNoOfClasses");
		xlwrite.setcelldata("Response_Batch",0,5,"batchStatus");
		xlwrite.setcelldata("Response_Batch",0,6,"programId");
		xlwrite.setcelldata("Response_Batch",0,7,"programName");
		
		xlwrite.setcelldata("Response_Batch",1,0,"batchupdate1");
		xlwrite.setcelldata("Response_Batch",1,1,bdes_env);
		xlwrite.setcelldata("Response_Batch",1,2,bacthId_env);
		xlwrite.setcelldata("Response_Batch",1,3,bname_env);
		xlwrite.setcelldata("Response_Batch",1,4,bclasses_env);
		xlwrite.setcelldata("Response_Batch",1,5,bstatus_env);
		xlwrite.setcelldata("Response_Batch",1,6,bpid_env);
		xlwrite.setcelldata("Response_Batch",1,7,bpname_env);
		
		
	}


/** Creating USers steps  ****/
	
	@Given("user creates User POST request for the LMS API endpoint from  {string} and {string}")
	public void user_creates_user_post_request_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException {
		
		req1 = given().spec(requestSpecification()).body(data.UserPayload(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(201).build();
	}
	
	@Then("API call for User module is success with status code201")
	public void api_call_for_user_module_is_success_with_status_code201() {
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(201)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("UserSchema.json"));
	   
	}
	@Then("verify the userID in json Response body")
	public void verify_the_user_id_in_json_response_body() throws IOException {
		userId_env = getJsonPath(response, "userId");
		userfirsname_env = getJsonPath(response, "userFirstName");
		userlastname_env = getJsonPath(response, "userLastName");
		usermiddlename_env = getJsonPath(response, "userMiddleName");
		phone = getJsonPath(response, "userPhoneNumber");
		location= getJsonPath(response, "userLocation");
		timezone= getJsonPath(response, "userTimeZone");
		linkein= getJsonPath(response, "userLinkedinUrl");
		ug= getJsonPath(response, "userEduUg");
		pg= getJsonPath(response, "userEduPg");
		comment= getJsonPath(response, "userComments");
		visastatus= getJsonPath(response, "userVisaStatus");
		
		
		xlwrite.setcelldata("Response_User",0,0,"testcaseName");
		xlwrite.setcelldata("Response_User",0,1,"userId");
		xlwrite.setcelldata("Response_User",0,2,"userFirstName");
		xlwrite.setcelldata("Response_User",0,3,"userLastName");
		xlwrite.setcelldata("Response_User",0,4,"userMiddleName");
		xlwrite.setcelldata("Response_User",0,5,"userPhoneNumber");
		xlwrite.setcelldata("Response_User",0,6,"userLocation");
		xlwrite.setcelldata("Response_User",0,7,"userTimeZone");
		xlwrite.setcelldata("Response_User",0,8,"userLinkedinUrl");
		xlwrite.setcelldata("Response_User",0,9,"userEduUg");
		xlwrite.setcelldata("Response_User",0,10,"userEduPg");
		xlwrite.setcelldata("Response_User",0,11,"userComments");
		xlwrite.setcelldata("Response_User",0,12,"userVisaStatus");
		
		xlwrite.setcelldata("Response_User",1,0,"Userupdate1");
		xlwrite.setcelldata("Response_User",1,1,userId_env);
		xlwrite.setcelldata("Response_User",1,2,userfirsname_env);
		xlwrite.setcelldata("Response_User",1,3,userlastname_env );
		xlwrite.setcelldata("Response_User",1,4,usermiddlename_env );
		xlwrite.setcelldata("Response_User",1,5,phone);
		xlwrite.setcelldata("Response_User",1,6,location);
		xlwrite.setcelldata("Response_User",1,7,timezone);
		xlwrite.setcelldata("Response_User",1,8,linkein);
		xlwrite.setcelldata("Response_User",1,9,ug);
		xlwrite.setcelldata("Response_User",1,10,pg);
		xlwrite.setcelldata("Response_User",1,11,comment);
		xlwrite.setcelldata("Response_User",1,12,visastatus);
		
		
		
	}

/*** Assignment Module POST Scenario 
 * @throws IOException ***/
	@Given("user creates Assignment POST request for the LMS API endpoint from  {string} and {string}")
	public void user_creates_assignment_post_request_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException {
		req1 = given().spec(requestSpecification()).body(data.AssignPayload(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(201).build();
	
	}

	

	@Then("User receives status code201 as success")
	public void user_receives_status_code201_as_success() {
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(201)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AssignmentSchema.json"));
	}

	@Then("store the AssignID from json Response body")
	public void store_the_assign_id_from_json_response_body() throws IOException {
		AssignId_env = getJsonPath(response, "assignmentId");
		duedate_env = getJsonPath(response, "dueDate");
		createdBy_env = getJsonPath(response, "createdBy");
		assigndes_env = getJsonPath(response, "assignmentDescription");
		assignname_env = getJsonPath(response, "assignmentName");
		bid = getJsonPath(response, "batchId");
		 gid= getJsonPath(response, "graderId");
		
		xlwrite.setcelldata("Response_Assign",0,0,"testcaseName");
		xlwrite.setcelldata("Response_Assign",0,1,"assignmentDescription");
		xlwrite.setcelldata("Response_Assign",0,2,"AssignmentID");
		xlwrite.setcelldata("Response_Assign",0,3,"assignmentName");
		xlwrite.setcelldata("Response_Assign",0,4,"batchId");
		xlwrite.setcelldata("Response_Assign",0,5,"createdBy");
		xlwrite.setcelldata("Response_Assign",0,6,"dueDate");
		xlwrite.setcelldata("Response_Assign",0,7,"graderId");
		
		
		xlwrite.setcelldata("Response_Assign",1,0,"assignupdate1");
		xlwrite.setcelldata("Response_Assign",1,1,assigndes_env);
		xlwrite.setcelldata("Response_Assign",1,2,AssignId_env);
		xlwrite.setcelldata("Response_Assign",1,3,assignname_env);
		xlwrite.setcelldata("Response_Assign",1,4,bid);
		xlwrite.setcelldata("Response_Assign",1,5,createdBy_env);
		xlwrite.setcelldata("Response_Assign",1,6,duedate_env);
		xlwrite.setcelldata("Response_Assign",1,7,gid);
	    
	}

/*** ASSIGNMENT SUBMIT POST SCENARIO STEPS  ***/
	
	@Given("user creates Submit Assign POST request for the LMS API endpoint from  {string} and {string}")
	public void user_creates_submit_assign_post_request_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException {
		req1 = given().spec(requestSpecification()).body(data.AssignSubmitPayload(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(201).build();
	}

	@Then("User receives success code with response body")
	public void user_receives_success_code_with_response_body() {
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(201)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AssignSubmitSchema.json"));
	}

	@Then("store the SubmissionID from json Response body")
	public void store_the_submission_id_from_json_response_body() {
		submitID_env = getJsonPath(response, "submissionId");
		subdate_env = getJsonPath(response, "subDateTime");
		//gradDate_env = getJsonPath(response, "gradedDateTime");
		
		
	}
	
	
	
}
