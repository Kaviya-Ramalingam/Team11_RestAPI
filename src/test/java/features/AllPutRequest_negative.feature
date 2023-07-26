@PutRequest_Negative

Feature: Put  Negative Scenarios

  Background: User sets Authorization
    Given User sets authorization to NO Auth

  @ProgPut_invalidID
  Scenario Outline: check if user able to update a program with invalid ID
    Given user creates PUT request with Invalid ID for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    When user call "putProgByID" with "put" http request for Put
    Then User receives 404BadRequest status code with message and boolean success details

    Examples: 
      | testcaseName | Sheetname |
      | Prog_1       | Program   |