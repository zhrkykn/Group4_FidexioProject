@wip
Feature:Fleet Vehicle Costs

  Background:
    Given The user should be logged in with valid credentials
    When the user clicks to fleetPage
    Then the user clicks to Vehicle Costs
    And Click on Vehicle Costs Create button

  Scenario: User create Vehicles Costs in fleet menu
    When Choose the vehicle name in Vehicle Costs menu
    Then Choose the type in Vehicle Costs menu
    And Enter date in Vehicle Costs menu
    And Enter total price in Vehicle Costs menu
    And Click on Save button in Vehicle Costs menu
    And the title should be Vehicle Costs

  Scenario: User can not create Vehicles Costs without vehicle name
    Then Choose the type in Vehicle Costs menu
    And Enter date in Vehicle Costs menu
    And Enter total price in Vehicle Costs menu
    And Click on Save button in Vehicle Costs menu
    And Error message displayed in Vehicle Costs menu

