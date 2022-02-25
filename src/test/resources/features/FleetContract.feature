
@FleetContract
Feature: Contract Page

  Background:
    Given the user is on the login page
    And Enter the user credentials
    And user click the Fleet menu
    Then user navigate to Vehicles Contracts


  Scenario: user should be able to create new vehicle contract
    When User click to create
    And user click to vehicle dropdown in vehicle contract menu
    And user select Audi option in vehicle dropdown
    Then User click on Save Button


  Scenario: user should not be able to create new vehicle contract with missing required field
    When User click to create
    And User click on Save Button
    Then error message should be displayed








