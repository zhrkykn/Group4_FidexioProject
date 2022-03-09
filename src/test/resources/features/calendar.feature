
Feature: Calender page

  Background:
    Given The user logged in as a "store manager"

  Scenario:  Verify that the user can access the Calender display as Week
    When the user navigates to Calender
    Then the user first lands on weekly display


  Scenario: Verify that the user can change the display
    And the user navigates to Calender
    And the user changes the display to Day
    When the user changes the display to Month
    Then the user changes the display to Week


  Scenario: Verify that the user can create an event
    When the user navigates to Calender
    Then the user creates an event


  Scenario: Verify that the user can edit a created event
    And the user navigates to Calender
    When the user edits Meeting Subject
    Then the user edits meeting schedule