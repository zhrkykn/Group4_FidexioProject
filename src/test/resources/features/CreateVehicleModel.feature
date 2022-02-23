@mehmet
Feature: Create a new vehicle model

  Background:
    Given the user is on the login page
    When Enter the user credentials
    Then User should be able to login
    When user click the Fleet menu
    And click Vehicle Model menu
    And click Create button in vehicle model menu
@VecCrea1
    Scenario: Creating new vehicle model
      When write Model name to input "Java EU7"
      And Click make type dropdown menu
      And Choose "Audi" for make type on dropdown menu
      And Click Save button in the vehicle model menu
      Then verify that vehicle model created
  @VecCrea2
    Scenario:Cannot create a new Vehicle Model without Model name
    When Click make type dropdown menu
    And Choose "Audi" for make type on dropdown menu
    And Click Save button in the vehicle model menu
    Then verify that alert display in vehicle model creation page
  @VecCrea3
    Scenario: Cannot create a new Vehicle Model without Make type
    When write Model name to input "Java EU7"
    And Click Save button in the vehicle model menu
    Then verify that alert display in vehicle model creation page
  @VecCrea4
   Scenario: Cannot create a new Vehicle Model without Model name and Make type
    And Click Save button in the vehicle model menu
    Then verify that alert display in vehicle model creation page




