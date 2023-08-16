package stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.API_enum;
import utilities.Utils;

public class GetRequest_AllProgramsSteps extends Utils {

	Response response;
	ResponseSpecification res1;
	RequestSpecification req2;

	@Given("user creates GET request to get the list of all the programs")
	public void user_creates_get_request_to_get_the_list_of_all_the_programs() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("running....");
		// throw new io.cucumber.java.PendingException();
	}

	@When("user call the API {string} with {string} http request")
	public void user_call_the_api_with_http_request(String resource, String method) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		API_enum resource_api = API_enum.valueOf(resource);
		req2 = given().spec(requestSpecification());
		if (method.equalsIgnoreCase("GET")) {

			response = req2.get(resource_api.getresource()).then().log().all().extract().response();
		}
		// throw new io.cucumber.java.PendingException();
	}

	@Then("API response is success with status {int}")
	public void api_response_is_success_with_status(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		response.then().assertThat().header("Content-Type", "application/json").statusCode(200);
		// throw new io.cucumber.java.PendingException();
	}

}
