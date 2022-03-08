Feature: Sales Manager should be able to create CRM/QUOTATIONS

  Background:
    Given sales manager should be logged in
    And user navigates to "CRM" and "Quotations"

  Scenario: Verify that sales manager can not create new QUOTATIONS

    #due to warehouse alert
    When user clicks on the "Create" button
    And user edits quotation customer
    And Click on Save button
    Then Error message displayed


  Scenario: Verify that Kanban button works as expected

    When user clicks on the "Kanban" button
    Then verify that it switched to "Kanban" view

  Scenario: Verify that List button works as expected

    When user clicks on the "List" button
    Then verify that it switched to "List" view

  Scenario: Verify that the user can delete QUOTATIONS
    When user clicks on a random quotation
    And user clicks on the "cancel" button
    And user opens Actions dropdown and clicks Delete
    And user clicks on the "Ok" button
    Then user verifies the quotation has been deleted

  Scenario: Verify that sales manager can edit quotations
    When user clicks on a random quotation
    And user clicks on the "Edit" button
    And user edits quotation customer
    And user clicks on the "Save" button
    Then Verify that quotation has been edited

  Scenario:Verify that sales manager can discard changes
    When user gets number of quotes and clicks on Create
    And user edits quotation customer
    And user clicks on the "Discard" button
    And user clicks on the "ok" button
    Then user verifies the quotation list number has not changed








