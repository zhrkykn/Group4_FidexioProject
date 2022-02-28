@vsl
Feature:Create a new vehicle services logs.

  Background:
    Given the user is on the login page
    And Enter the user credentials
    And User on the new vehicle services logs under the fleet page

  Scenario: Posmanager is create a new vehicle services logs
    When click the create button
    And  enter the vehicle services logs information
    And  the user click the save button
    Then user should be able to create a new vehicle services logs

  Scenario Outline: Login with blank vehicle and service type information
    When click the create button
    And enters credential "<vehicle>" "<service type>"
    And the user click the save button
    Then Error message displayed
    Examples:
      | vehicle           | service type |
      |                   |              |
      | Audi/A1/1-AUD-001 |              |
      |                   | Snow Tires   |






