package stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.API_enum;
import utilities.ExcelUtility;
import utilities.Utils;

public class Prog_Post_NegSteps extends Utils{
	ResponseSpecification res1;
	RequestSpecification req2;
	Response response;
	HashMap<String,Object> map=new HashMap<String, Object>();
	@Given("user creates POST request with existing prog name for the LMS API endpoint from  {string} and {string}")
	public void user_creates_post_request_with_existing_prog_name_for_the_lms_api_endpoint_from_and(String string, String string2) throws IOException {
		List<String> data=ExcelUtility.getData(string,string2);
		
		
		map.put("programName",PostRequestSteps.Pname_env);
		map.put("programDescription",data.get(1));
		map.put("programStatus",data.get(2));
		
		req2=given().spec(requestSpecification()).body(map);
		//res1=new ResponseSpecBuilder().expectStatusCode(400).build();

	}
	@When("user call {string} with {string} http request for program exists")
	public void user_call_with_http_request_for_program_exists(String resource, String method)
	{
		
		API_enum resource_api = API_enum.valueOf(resource);
		if (method.equalsIgnoreCase("POST"))
		{
			
		response = req2.post(resource_api.getresource())
		.then()
		.log().all()
		.extract().response();
		}
	}
	@Then("User receives Bad Request status with message and boolean success details")
	public void user_receives_bad_request_status_with_message_and_boolean_success_details() {
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(400);
		
		
	}

	/* negative scenario---with missing field ***/
	
	@Given("user creates POST request with missingfield for the LMS API endpoint from  {string} and {string}")
	public void user_creates_post_request_with_missingfield_for_the_lms_api_endpoint_from_and(String string, String string2) throws IOException {
		List<String> data=ExcelUtility.getData(string,string2);
		
		
		map.put("programName","");
		map.put("programDescription",data.get(1));
		map.put("programStatus",data.get(2));
		
		req2=given().spec(requestSpecification()).body(map);
	}

	@When("user call {string} with {string} http request for missing field")
	public void user_call_with_http_request_for_missing_field(String resource, String method) {
		API_enum resource_api = API_enum.valueOf(resource);
		if (method.equalsIgnoreCase("POST"))
		{
			
		response = req2.post(resource_api.getresource())
		.then()
		.log().all()
		.extract().response();
		}
	}

	@Then("User receives internal server error")
	public void user_receives_internal_server_error() {
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(400);
		
		
	}
}
