Feature: All program GetRequest

	Background: User sets Authorization
			Given User sets authorization to NO Auth
			


  @allPrograms_neg1
  Scenario Outline: get list of all programs created with wrong url
    Given user creates GET request to get the list of all the programs but enters wrong url
    When user call the API "GetallProgs" with "get" http request with wrong url
    Then API response is "Not found" with status code 404




  @allPrograms_neg2
  Scenario Outline: get list of all programs created with wrong url
    Given user creates GET request to get the list of all the programs but enters wrong url
    When user call the API "GetallProgs" with "get" http request with wrong url
    Then API response is "Not found" with status code 404
    
   Examples: 
|programId|programName|programDescription|programStatus|
|11301 | 'Jun23-API Diggers-SDET-446'| 'Postman Hackathon-447'| 'active'|
  