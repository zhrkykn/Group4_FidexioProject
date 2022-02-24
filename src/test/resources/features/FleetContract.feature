Feature: Contract Page

  Background:
    Given the user is on the login page
    And Enter the user credentials
    And User navigate to Fleet and Contracts



  Scenario: user should be able to create vehicle contract
    When User click to create
    And User enter required info for Vehicle Contract
    And User click on Save Button
    Then User should be able to see new vehicle contract in list

  Scenario: user shouldn't create a vehicle contract with missing required info
    Given the user clicks on create button
    When the user clicks on Save Button
    Then error message should be displayed