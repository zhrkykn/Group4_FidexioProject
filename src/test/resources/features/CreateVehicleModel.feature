@wip2
Feature: Create a new vehicle model

  Background:
    Given the user is on the login page
    When Enter the user credentials
    Then User should be able to login

    Scenario: Creating new vehicle model
      When user click the Fleet menu
      And click Vehicle Model menu
      And click Create button
      And write Model name


