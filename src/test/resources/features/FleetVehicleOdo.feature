
Feature:Fleet Vehicle Odometer

  Background:
    Given The user should be logged in with valid credentials
    When the user clicks to fleetPage
    Then the user clicks to Vehicle Odometer
    And Click on Create button

  Scenario: User create Vehicles Odometer in fleet menu
    When Choose the vehicle name
    Then Enter odometer value
    And Enter date
    And Click on Save button

  Scenario: User can not create Vehicles Odometer without vehicle name
    Then Enter odometer value
    And Enter date
    And Click on Save button
    And Error message displayed
