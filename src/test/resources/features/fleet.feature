
  Feature: Fleet page

    Background:
      Given the user is on the login page
      When Enter the user credentials


    @wip1
    Scenario:Create Vehicles Fuel Log
      When the user clicks on fleet link
      Then the user clicks on Vehicles Fuel Logs
      And the user clicks on create button for vehicle
      Then the user clicks on vehicle dropdown
      And the user chooses any car
      Then the user fills out liters
      And the user fills out price per liter
      Then the user fills out odometer value
      Then the user clicks on save button

    @wip2
    Scenario: Create Vehicles Fuel Log Without a Vehicle
      When the user clicks on fleet link
      Then the user clicks on Vehicles Fuel Logs
      And the user clicks on create button for vehicle
      Then the user clicks on vehicle dropdown
      Then the user fills out liters
      And the user fills out price per liter
      Then the user fills out odometer value
      Then the user clicks on save button
      And the user is able to see warning message