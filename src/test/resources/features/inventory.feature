Feature: inventory button

  Background:
    Given the user is on the login in


  Scenario: inventory page
    When the user is clicked inventory button
    And the user clicked the product button
    Then the create button seen

