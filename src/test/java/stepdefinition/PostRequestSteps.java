package stepdefinition;


import static io.restassured.RestAssured.given;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
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
	
	public static String progID_env,Pname_env,bacthId_env,Bname_env,userId_env,CreateTime_env,AssignId_env,
							duedate_env,createdBy_env;
	
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
		Pname_env=getJsonPath(response, "programName");
		CreateTime_env=getJsonPath(response, "creationTime");
		xlwrite.setcelldata("Response_Program",0,0,"programID");
		xlwrite.setcelldata("Response_Program",0,1,progID_env);
		xlwrite.setcelldata("Response_Program",1,0,"programname");
		xlwrite.setcelldata("Response_Program",1,1,Pname_env);
		xlwrite.setcelldata("Response_Program",2,0,"creationTime");
		xlwrite.setcelldata("Response_Program",2,1,CreateTime_env);
	   
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
		
		bacthId_env = getJsonPath(response, "batchId");

		Bname_env=getJsonPath(response, "batchName");
		
		xlwrite.setcelldata("Response_Batch",0,0,"batchID");
		xlwrite.setcelldata("Response_Batch",0,1,bacthId_env);
		xlwrite.setcelldata("Response_Batch",1,0,"batchName");
		xlwrite.setcelldata("Response_Batch",1,1,Bname_env);
		
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
				
		xlwrite.setcelldata("Response_User",0,0,"userID");
		xlwrite.setcelldata("Response_User",0,1,userId_env);
		
		
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
		
		xlwrite.setcelldata("Response_Assign",0,0,"AssignmentID");
		xlwrite.setcelldata("Response_Assign",0,1,AssignId_env);
		xlwrite.setcelldata("Response_Assign",1,0,"dueDate");
		xlwrite.setcelldata("Response_Assign",1,1,duedate_env);
		xlwrite.setcelldata("Response_Assign",2,0,"createdBy");
		xlwrite.setcelldata("Response_Assign",2,1,createdBy_env);
	    
	}


	
	
}
