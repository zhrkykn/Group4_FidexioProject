
@FleetContract
Feature: Contract Page

  Background:
    Given the user is on the login page
    And Enter the user credentials
    And user click the Fleet menu
    #Then user navigate to Vehicles Contracts


  Scenario: user should be able to create new vehicle contract
    When click the create button
    And user click to vehicle dropdown in vehicle contract menu
    And user select Audi option in vehicle dropdown
    Then User click on Save Button


  Scenario: user should not be able to create new vehicle contract with missing required field
    When click the create button
    And User click on Save Button
    Then Error message displayed









