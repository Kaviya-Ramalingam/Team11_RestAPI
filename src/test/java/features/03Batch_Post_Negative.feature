Feature: Batch Post Negative Scenarios

  Background: User sets Authorization
    Given User sets authorization to NO Auth

  @BatchPost_Neg1
  Scenario Outline: check if user able to create a program with existing batch name
    Given user creates POST request with existing batch name for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    When user call "AddBatch" with "post" http request for batch 
    Then User receives BadRequest status with message and boolean success details

    Examples: 
      | testcaseName | Sheetname |
      | Prog_1       | Program   |

  @BatchPost_Neg2
  Scenario Outline: check if user able to create a program with missing field
    Given user creates POST request with missingfield in batch for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    When user call "AddBatch" with "post" http request for batch
    Then User receives internal server error400

    Examples: 
      |testcaseName|Sheetname|
			| ProgBatch_1  |   Batch |