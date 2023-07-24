package stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.API_enum;
import utilities.ExcelUtility;
import utilities.Utils;

public class Batch_PostNegSteps extends Utils {
	ResponseSpecification res1;
	RequestSpecification req3;
	Response response;
	HashMap<String,Object> map=new HashMap<String, Object>();
	@Given("user creates POST request with existing batch name for the LMS API endpoint from  {string} and {string}")
	public void user_creates_post_request_with_existing_batch_name_for_the_lms_api_endpoint_from_and(String string, String string2) throws IOException {
		
		List<String> data=ExcelUtility.getData(string,string2);
		
		//with same batch name
		map.put("batchName",PostRequestSteps.Bname_env);
		map.put("batchDescription",data.get(1));
		map.put("batchStatus",data.get(2));
		map.put("batchNoOfClasses",data.get(3));
		
		map.put("programId",PostRequestSteps.progID_env);
		
		req3=given().spec(requestSpecification()).body(map);
	}

	@When("user call {string} with {string} http request for batch")
	public void user_call_with_http_request_for_batch(String resource, String method) {
		API_enum resource_api = API_enum.valueOf(resource);
		if (method.equalsIgnoreCase("POST"))
		{
			
		response = req3.post(resource_api.getresource())
		.then()
		.log().all()
		.extract().response();
		}
	   
	}

	@Given("user creates POST request with missingfield in batch for the LMS API endpoint from  {string} and {string}")
	public void user_creates_post_request_with_missingfield_in_batch_for_the_lms_api_endpoint_from_and(String string, String string2) throws IOException {
		
		List<String> data=ExcelUtility.getData(string,string2);
		
		
		map.put("batchName",PostRequestSteps.Bname_env);
		map.put("batchDescription",data.get(1));
		map.put("batchStatus",data.get(2));
		map.put("batchNoOfClasses",data.get(3));
		
		//missing programID
		req3=given().spec(requestSpecification()).body(map);
	    
	}
	@Then("User receives BadRequest status with message and boolean success details")
	public void user_receives_bad_request_status_with_message_and_boolean_success_details() {
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(400);
		
	}

	@Then("User receives internal server error400")
	public void user_receives_internal_server_error400() {
		response.then().assertThat().header("Content-Type","application/json")
		.statusCode(400);
	}




}
