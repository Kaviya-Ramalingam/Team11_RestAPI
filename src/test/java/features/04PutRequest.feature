@update
Feature: Title of your feature
  I want to use this template for my feature file
  
  
  
  @UpdateAssignment 
  
  Scenario Outline: Check if user able to update a user with valid User Id and request body
    Given user creates put request on Assignment  "<testcaseName>" and "<Sheetname>"
    When user call "updateAssign" with "putAssign" http request to update
    Then Request should be successful with status code 200user Role status Update

    Examples: 
      | testcaseName | Sheetname     |
      | assignupdate1  | Response_Assign |
  
  
  
  
  
  
  

  #@updatebyuserrolestatus
  #Scenario Outline: Check if user able to update a user role status with valid User Id and request body
    #Given user creates put request on user for changing role status  "<testcaseName>" and "<Sheetname>"
    #When user call "updateuserrolestatus" with "PutforUserrolestatus" http request to update
    #Then Request should be successful with status code 200user Role status Update
#
    #Examples: 
      #| testcaseName | Sheetname     |
      #| Userupdate1  | Response_User |
#
  #@updatebyuserid
  #Scenario Outline: Check if user able to update a user with valid User Id and request body
    #Given user creates put request for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    #When user call "updateuser" with "PutUser" http request to update
    #Then Request should be successful with status code 200user Role status Update
#
    #Examples: 
      #| testcaseName | Sheetname     |
      #| Userupdate1  | Response_User |
#
  #@AssignUpdateUserRoleProgramBatchStatus
  #Scenario Outline: Check if user able to update a user with valid User Id and request body
    #Given user creates put request for UserRoleProgramBatchStatus the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    #When user call "updateuserprogbatch" with "PutUserprogbatch" http request to update
    #Then Request should be successful with status code 200user Role status Update
#
    #Examples: 
      #| testcaseName | Sheetname     |
      #| Userupdate1  | Response_User |
#
  #@updatebybatchid
  #Scenario Outline: Check if user able to update a batch with valid batch Id and request body
    #Given user creates put request on bath for the LMS API endpoint from bath id "<testcaseName>" and "<Sheetname>"
    #When user call "updatebatchbyid" with "Putbatchid" http request to update
    #Then Request should be successful with status code 200user Role status Update
#
    #Examples: 
      #| testcaseName | Sheetname      |
      #| batchupdate1 | Response_Batch |
#
  #@updatebyprogramname
  #Scenario Outline: Check if user able to update a program with valid program name and request body
    #Given user creates put  request on programname for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    #When user call "updateprogramname" with "PutProgramname" http request to update
    #Then Request should be successful with status code 200user Role status Update
#
    #Examples: 
      #| testcaseName | Sheetname        |
      #| Progput_1    | Response_Program |
#
  #@updatebyprogramid
  #Scenario Outline: Check if user able to update a program with valid program Id and request body
    #Given user creates put  request on program for the LMS API endpoint from  "<testcaseName>" and "<Sheetname>"
    #When user call "updateprogram" with "PutProgram" http request to update
    #Then Request should be successful with status code 200user Role status Update
#
    #Examples: 
      #| testcaseName | Sheetname        |
      #| Progput_1    | Response_Program |
