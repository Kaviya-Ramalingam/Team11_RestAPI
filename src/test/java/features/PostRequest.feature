
@tag
Feature: post request of all modules
  
  @tag1
  Scenario Outline: check if user able to create a program with valid endpoint and request body
    Given user creates POST request for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    When user call "AddProgram" with "post" http request
    Then API call is success with status code201
    Then verify the programId in json Response body
    
   Examples: 
|testcaseName|Sheetname|
| Prog_1  |   Program |
| Prog_2  |   Program|