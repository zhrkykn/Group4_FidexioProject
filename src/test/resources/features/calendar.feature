@smoke
Feature: Calender page


  Scenario:  Verify that the user can access the Calender display as Week
    Given the user logged in as a "store manager"
    When the user navigates to Calender
    Then the user first lands on weekly display


  Scenario: Verify that the user can change the display
    Given the user logged in as a "store manager"
    And the user navigates to Calender
    And the user changes the display to Day
    When the user changes the display to Month
    Then the user changes the display to Week

  @wip
  Scenario: Verify that the user can create an event
    Given the user logged in as a "store manager"
    When the user navigates to Calender
    Then the user creates an event


  @wip
  Scenario: Verify that the user can edit a created event
    Given the user logged in as a "store manager"
    And the user navigates to Calender
    When the user edits Meeting Subject
    Then the user edits meeting schedule