@hzk
Feature: Notes Functionality

  Background:
    Given The user should be logged in with valid credentials
    When The user clicks the Notes Page

    Scenario: Verify that the user can create new note
      Then Click on Create button for Notes
      And The user select tags for notes
      And The user write a note
      And Click on Save button for Notes
      And The user should be able to see new note

    Scenario:Verify that the user can switch Kanban-List view
      Then Click on Kanban button for Notes
      And The user should be able to see Kanban note list
      Then Click on List button for Notes
      And The user should be able to see List note list

    Scenario: Verify that the user can discard changes
      Then Click on Create button for Notes
      And The user select tags for notes
      And The user write a note
      Then Click on Discard button for Notes
      And Click on Ok button for notes
      And The user should be able to see Kanban note list

    Scenario: Verify that the user can edit notes
      Then Select note to edit
      And The user write a note
      And Click on Save button for Notes
      And The user should be able to see edited note

    Scenario: Verify that the user can delete notes
      Then Click the more button on the side of the note
      And Click on delete button for notes
      Then Click on Ok button for notes
      And The user should be able to see that the note has been deleted







