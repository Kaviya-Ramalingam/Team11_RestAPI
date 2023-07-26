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

import utilities.TestData2;
import utilities.Utils;

public class PutRequest extends Utils {
	
	
	ResponseSpecification res1;
	RequestSpecification req1;
	Response response;
	
	TestData2 data=new TestData2();
	
	
	@Given("user creates put request on Assignment  {string} and {string}")
	public void user_creates_put_request_on_assignment_and(String testcaseName, String Sheetname) throws IOException 
	
	{
		req1 = given().spec(requestSpecification()).body(data.assignPut(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(200).build();
	}
	
	
	
	
	
	@Given("user creates put request for UserRoleProgramBatchStatus the LMS API endpoint from  {string} and {string}")
	public void user_creates_put_request_for_user_role_program_batch_status_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException {
	   
		req1 = given().spec(requestSpecification()).body(data.UserPutprogbathstatus(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(200).build();
		
	}
	
	
	@Given("user creates put request for the LMS API endpoint from  {string} and {string}") 
	public void user_creates_put_request_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException 
	{
		
		req1 = given().spec(requestSpecification()).body(data.UserPut(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(200).build();
		
		
	}
	
	@Given("user creates put request on user for changing role status  {string} and {string}")
	public void user_creates_put_request_on_user_for_changing_role_status_and(String testcaseName, String Sheetname) throws IOException 
	{
		req1 = given().spec(requestSpecification()).body(data.Updaterolestatus(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(200).build();
	}



	@When("user call {string} with {string} http request to update")
	public void user_call_with_http_request_to_update(String resource, String method)
	
	{
		API_enum resource_api = API_enum.valueOf(resource);
		if (method.equalsIgnoreCase("PutUser"))
		response = req1.put(resource_api.getresource()+PostRequestSteps.userId_env);
		else if (method.equalsIgnoreCase("PutforUserrolestatus"))
			response = req1.put(resource_api.getresource()+"U7876");
		else if (method.equalsIgnoreCase("PutUserprogbatch"))
			response = req1.put(resource_api.getresource()+"U8618");
		else if (method.equalsIgnoreCase("PutProgram"))
			response = req1.put(resource_api.getresource()+PostRequestSteps.progID_env);
		else if (method.equalsIgnoreCase("PutProgramname"))
			response = req1.put(resource_api.getresource()+PostRequestSteps.progname_env);
		else if (method.equalsIgnoreCase("Putbatchid"))
			response = req1.put(resource_api.getresource()+PostRequestSteps.bacthId_env);
		else if (method.equalsIgnoreCase("putAssign"))
			response = req1.put(resource_api.getresource()+PostRequestSteps.AssignId_env);
	
	
		//System.out.println(PostRequestSteps.userId_env);
	}

	@Then("Request should be successful with status code 200user Role status Update")
	public void request_should_be_successful_with_status_code_200user_role_status_update() 
	
	{
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(200);
		
	}
	
	@Given("user creates put  request on program for the LMS API endpoint from  {string} and {string}")
	public void user_creates_put_request_on_program_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException {
		req1 = given().spec(requestSpecification()).body(data.ProgramPut(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(200).build();
	}
	
	@Given("user creates put  request on programname for the LMS API endpoint from  {string} and {string}")
	public void user_creates_put_request_on_programname_for_the_lms_api_endpoint_from_and(String testcaseName, String Sheetname) throws IOException {
		req1 = given().spec(requestSpecification()).body(data.programPut(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(200).build();
	}
	
	@Given("user creates put request on bath for the LMS API endpoint from bath id {string} and {string}")
	public void user_creates_put_request_on_bath_for_the_lms_api_endpoint_from_bath_id_and(String testcaseName, String Sheetname) throws IOException {
		req1 = given().spec(requestSpecification()).body(data.batchPut(testcaseName,Sheetname));
		res1=new ResponseSpecBuilder().expectStatusCode(200).build();
	}

}