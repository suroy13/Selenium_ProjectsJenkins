#Author: diatmsubhankar@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@TestSuite_Spicejet
Feature: Spicejet Flight Search on its WebPortal
  As a user I want to perform search of flights on dates for specific desitinations

  @TC001
  Scenario: Search To and From Search 
    Given The user has opened the Spicejet Browser on a Web Browser
    When User Selects the Destinations 
    And Select the Travel dates 
    And Select the number of Passengers
    And Select the Curency
    And Clicks on the Search Fight button
    Then User able to see the avaibale flights for that route
    Then Users Closes the Browser
    

  
