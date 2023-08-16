Feature: All program GetRequest

	Background: User sets Authorization
			Given User sets authorization to NO Auth
			


  @allPrograms
  Scenario Outline: get list of all programs created
    Given user creates GET request to get the list of all the programs
    When user call the API "GetallProgs" with "get" http request
    Then API response is success with status 200


    
   Examples: 
|programId|programName|programDescription|programStatus|
|11301 | 'Jun23-API Diggers-SDET-446'| 'Postman Hackathon-447'| 'active'|
  