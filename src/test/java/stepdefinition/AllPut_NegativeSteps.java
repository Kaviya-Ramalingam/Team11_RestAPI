package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Utils;

public class AllPut_NegativeSteps extends Utils {
	
	@Given("user creates PUT request with Invalid ID for the LMS API endpoint from  {string} and {string}")
	public void user_creates_put_request_with_invalid_ID_for_the_lms_api_endpoint_from_and(String string, String string2) {
	   
	}

	@When("user call {string} with {string} http request for Put")
	public void user_call_with_http_request_for_put(String string, String string2) {
	   
	}

	@Then("User receives 404BadRequest status code with message and boolean success details")
	public void user_receives_404bad_request_status_code_with_message_and_boolean_success_details() {
	    
	}


}
