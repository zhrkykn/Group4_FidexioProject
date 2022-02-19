Feature:

  Scenario: Verify that USER can see these menus on the left side under the Fleet Menu.

    Given The user should be logged in with valid credentials
    When the user clicks to fleetPage
    Then the side menu contains


      | Vehicles               |
      | Vehicles Odometer      |
      | Vehicle Costs          |
      | Vehicles Contracts     |
      | Vehicles Fuel Logs     |
      | Vehicles Services Logs |
      | Costs                  |
      | Indicative Costs       |
      | Vehicle Model          |
      | Model make of Vehicle  |
      | Service Types          |
      | Contract Types         |
      | Vehicle Status         |
      | Vehicle Tags           |


