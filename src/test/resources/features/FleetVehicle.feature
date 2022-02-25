@aa
Feature: Creation vehicle in Fleet

  Background:
    Given the user is on the login page
    And Enter the user credentials
    And User navigate to "Fleet"
    And Click on Create button


  Scenario: user should be able to create vehicle
    And User enter required info for Vehicle
    And User click on Save Button
    Then User should be able to see new vehicle in list

  Scenario Outline: user shouldn't create a vehicle with missing required info
    When user enters missing information required to create tool "<carName>" "<license>"
    And User click on Save Button
    Then Error message displayed
    Examples:
      | carName | license   |
      | Audi/A3 |           |
      |         | 123asd123 |
      |         |           |