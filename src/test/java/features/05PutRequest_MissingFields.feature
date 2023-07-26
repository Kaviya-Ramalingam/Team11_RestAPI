 
 @PutRequest_missingFields

Feature: update all data with missing fields and valid ids-  Negative Scenarios

  Background: User sets Authorization
    Given User sets authorization to NO Auth
 
 @ProgPut_missingField
  Scenario Outline: check if user able to update a program with missing field
    Given user creates PUT request with missing data for the LMS API endpoint
    When user call "updateprogram" with "PutProgram" http request for Put
    Then User receives 400BadRequest status code with message and boolean success details
    
    @ProgPutname_missingField
	  Scenario Outline: check if user able to update a program with missing field and valid program name
	    Given user creates PUT request with missing data and valid name for the LMS API endpoint
	    When user call "updateprogramname" with "PutProgramname" http request for Put
	    Then User receives 400BadRequest status code with message and boolean success details
	    
	    @batchPut_missingField
  Scenario Outline: check if user able to update a batch with missing field
    Given user creates PUT request with missing batch data for the LMS API endpoint
    When user call "updatebatchbyid" with "Putbatchid" http request for Put
    Then User receives 400BadRequest status code with message and boolean success details
    
     @PutUSer_missingFields
  Scenario Outline: Check if user able to update a user with missing fields
    Given user creates put request for missing fields and valid user the LMS API endpoint
    When user call "updateuser" with "PutUser" http request for Put
    Then  User receives 400BadRequest status code with message and boolean success details
    
     @update_rolestatus_missing
      Scenario Outline: Check if user able to update a user role status with missing data
    Given user creates put request on user for changing role status with missing data 
    When user call "updateuserrolestatus" with "PutforUserrolestatus" http request for Put
    Then User receives 400BadRequest status code with message and boolean success details
    
     @assignUSerrole_missingdata
     Scenario Outline: Check if user able to assign user to program batch with missing data
    Given user creates put request on user assign user to program batch with missing data 
    When user call "updateuserrolestatus" with "PutforUserrolestatus" http request for Put
    Then User receives 400BadRequest status code with message and boolean success details
    