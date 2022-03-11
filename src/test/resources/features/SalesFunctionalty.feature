Feature: As a Sales Functionality, I should be able to create and edit new customers from "Sales" module

  Background:
    Given sales functionality should be logged in
    And sales functionality clicks on Sales and Customers


  Scenario: Verify that the page title changed the customer name and address.


    When sales functionality clicks the first result link from customers list
    And sales functionality  clicks "Edit" button
    And sales functionality enters "Test" name
    And sales functionality clicks "Save" button
    Then it is displayed the edited customer name on the title.


  Scenario: Verify that the user should be able to see created customer is listed.

    When sales functionality  clicks "Create" button
    #And sales functionality enters "Cool Name"
    And sales functionality enters the name and the address
    And sales functionality clicks "Save" button
    Then verify it is listed the new customer by searching the name

  Scenario: Verify that "Save" button works as expected

    When sales  functionality clicks "Create" button
    And sales functionality enters the name and the address
    And sales functionality clicks "Save" button
    Then verify it is listed the new customer by searching the name

  Scenario: Verify that "Edit" button works as expected

    When sales functionality  clicks the first result link from customers list
    And sales functionality clicks "Edit" button
    And sales functionality enters "Test" name
    And sales functionality clicks "Save" button
    Then it is displayed the edited customer name on the title.

  Scenario: Verify that "Discard" button works as expected

    When sales functionality clicks "Create" button
    And sales functionality enters the name and the address
    And sales functionality clicks "Discard" button
    Then sales functionality verifies discard message is displayed


  Scenario: Verify that "Create" button works as expected
    When sales functionality clicks "Create" button
    Then the title changes to "New - Odoo"

  Scenario: Verify that "Create" function works as expected
    When sales functionality clicks "Create" button
    And sales functionality enters the name and the address
    And sales functionality clicks "Save" button
    Then verify it is listed the new customer by searching the name

