@FIDE-740
Feature: Contacts functions

  Background:
    Given the user is on the login page
    And Enter the user credentials
    And the user navigates to "Contacts"


  @FIDE-734
  Scenario: Verify that the user can create new contact
    When Click on Create button
    And user enters required info for new Contact
    And Click on Save button
    Then user should be able to see new contact in list


  @FIDE-735
  Scenario: Verify that the user cannot create new contact with missing required
    When Click on Create button
    And Click on Save button
    Then Error message displayed


  @FIDE-736
  Scenario: Verify that the user can switch Kanban-List view
    When Click on List view
    Then user should be able to see List view
    When Click on Kanban view
    Then user should be able to see Kanban view

  @FIDE-737
  Scenario: Verify that the user can discard changes
    When Click on Create button
    And user enters required info for new Contact
    And Click on Discard
    Then User should able to quit without saving


  @FIDE-738
  Scenario: Verify that the user can edit contact
    When user click any contact
    And Click on Edit button
    And user changes the name
    And Click on Save button
    Then Verify that changed name appear in contact list


  @FIDE-739
  Scenario: Verify that the user can delete contact
    When user click any contact
    And click to Delete
    Then user shouldn't see name