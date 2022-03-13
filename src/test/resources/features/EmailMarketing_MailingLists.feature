Feature: Sales Manager should be able to create CRM/QUOTATIONS

  Background:
    Given sales manager should be logged in
    And user navigates to "Email Marketing" and "Mailing Lists"

  Scenario: Verify that Kanban button works as expected
    When user clicks on the "Kanban" button
    Then verify that it switched to "Kanban" view

  Scenario: Verify that List button works as expected
    When user clicks on the "List" button
    Then verify that it switched to "List" view


  Scenario: Verify that sales manager can create new Mailing List
    When user clicks on the "Create" button
    And user enters Mailing List name
    And user clicks on the "Save" button
    Then verify that the list has been created by searching


  Scenario: Verify that user can add contacts to Recipients
    When user clicks on a random Mailing List
    And user clicks recipients and Create button
    And user fills the new contact form
    Then Verify that the new contact is added in Recipients List


  Scenario: Verify that the user can delete Mailing List
    When user clicks on a random Mailing List
    And user opens Actions dropdown and clicks Delete
    And user clicks on the "Ok" button
    Then user verifies the Mailing List has been deleted

  Scenario: Verify that sales manager can edit quotations
    When user clicks on a random Mailing List
    And user clicks on the "Edit" button
    And user edits the name of the list
    And user clicks on the "Save" button
    Then verify that the list has been created by searching

  Scenario:Verify that sales manager can discard changes
    When user gets number of quotes and clicks on Create
    And user edits the name of the list
    And user clicks on the "Discard" button
    And user clicks on the "ok" button
    Then user verifies the quotation list number has not changed