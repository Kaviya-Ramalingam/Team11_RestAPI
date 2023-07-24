Feature: Program Post Negative Scenarios

  Background: User sets Authorization
    Given User sets authorization to NO Auth

  @ProgPost_Neg1
  Scenario Outline: check if user able to create a program with existing program name
    Given user creates POST request with existing prog name for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    When user call "AddProgram" with "post" http request for program exists
    Then User receives Bad Request status with message and boolean success details

    Examples: 
      | testcaseName | Sheetname |
      | Prog_1       | Program   |

  @ProgPost_Neg2
  Scenario Outline: check if user able to create a program with missing field
    Given user creates POST request with missingfield for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    When user call "AddProgram" with "post" http request for missing field
    Then User receives internal server error

    Examples: 
      | testcaseName | Sheetname |
      | Prog_1       | Program   |
