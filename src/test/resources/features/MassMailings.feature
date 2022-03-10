Feature: Sales Manager should be able to create Email Marketings / Mass Mailings

  Background:
    Given sales manager should be logged in
    And user navigates to "Email Marketing" and "Mass Mailings"

  Scenario: Verify that sales manager can create new Mass Mailings
    When the user clicks on the "Create" button
    And user enters subject name as "Third Newsletter"
    And the user clicks on the "Save" button
    Then verify that title changes to "Third Newsletter - Odoo"

  Scenario: Verify that Kanban button works as expected in the Mass Mailings Page
    When the user clicks on the "Kanban" button
    Then verify that it switched to "Kanban" view


  Scenario: Verify that sales manager can edit mass mailings
    When user clicks on a random Mass mailings
    And the user clicks on the "Edit" button
    And the user edits the name of the subject
    And the user clicks on the "Save" button
    Then Verify that the Subject name has been changed

  Scenario:Verify that sales manager can discard changes
    When the user clicks on a random Mass mailings
    And the user clicks on the "Edit" button
    And the user edits the name of the subject
    And the user clicks on the "Discard" button
    And the user clicks on the "ok" from the pop up button
    Then user verifies the Mass mailings number has not changed

  Scenario: Verify that the user can delete Mass Mailings
    When the user clicks on a random Mass mailings
    And the user opens Actions dropdown and clicks Delete
    And the user clicks on the "Ok" from the pop up button
    Then verify that  Mass Mailings  has been deleted