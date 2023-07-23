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
	public static String progID_env,Pname_env,bacthId_env,Bname_env;
	TestData data=new TestData();
	//ExcelWriter xlwrite = new ExcelWriter("./src/test/resources/Response_data.xlsx");

	@Given("user creates POST request for the LMS API endpoint from  {string} and {string}")
	public void user_creates_post_request_for_the_lms_api_endpoint_from_and(String string, String string2) throws IOException

	{
		
		req1 = given().spec(requestSpecification()).body(data.programPayload(string,string2));
		res1=new ResponseSpecBuilder().expectStatusCode(201).build();

	
	}

	
	
	
	@When("user call {string} with {string} http request")
	public void user_call_with_http_request(String resource, String method)
	{
		System.out.println("in when statement");
		API_enum resource_api = API_enum.valueOf(resource);
		if (method.equalsIgnoreCase("POST"))
		{
			System.out.println("in if statement");
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
		/*xlwrite.setcelldata("Response_data",0,0,"programID");
		xlwrite.setcelldata("Response_data",0,1,progID_env);
		xlwrite.setcelldata("Response_data",1,0,"programname");
		xlwrite.setcelldata("Response_data",1,2,Pname_env);*/
	   
	}
	
	/*** Batch Scenario steps ***/
	
	@Given("user creates Batch POST request for the LMS API endpoint from  {string} and {string}")
	public void user_creates_batch_post_request_for_the_lms_api_endpoint_from_and(String string, String string2) throws IOException {
		req1 = given().spec(requestSpecification()).body(data.BatchPayload(string,string2));
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
		/*xlwrite.setcelldata("Response_data",1,0,"batchID");
		xlwrite.setcelldata("Response_data",1,1,batch_ID);*/
	}




	
}
