Feature: As a Sales Manager, I should be able to create and edit new customers from "Sales" module

  Background:
    Given sales manager should be logged in
    And sales manager clicks on Sales and Customers


  Scenario: Verify that the page title changed the customer name and address.


    When sales manager clicks the first result link from customers list
    And sales manager clicks "Edit" button
    And sales manager enters "Test" name
    And sales manager clicks "Save" button
    Then it is displayed the edited customer name on the title.


  Scenario: Verify that the user should be able to see created customer is listed.

    When sales manager clicks "Create" button
    #And sales manager enters "Cool Name"
    And sales manager enters the name and the address
    And sales manager clicks "Save" button
    Then verify it is listed the new customer by searching the name

  Scenario: Verify that "Save" button works as expected

    When sales manager clicks "Create" button
    And sales manager enters the name and the address
    And sales manager clicks "Save" button
    Then verify it is listed the new customer by searching the name

  Scenario: Verify that "Edit" button works as expected

    When sales manager clicks the first result link from customers list
    And sales manager clicks "Edit" button
    And sales manager enters "Test" name
    And sales manager clicks "Save" button
    Then it is displayed the edited customer name on the title.

  Scenario: Verify that "Discard" button works as expected

    When sales manager clicks "Create" button
    And sales manager enters the name and the address
    And sales manager clicks "Discard" button
    Then sales manager verifies discard message is displayed


  Scenario: Verify that "Create" button works as expected
    When sales manager clicks "Create" button
    Then the title changes to "New - Odoo"

  Scenario: Verify that "Create" function works as expected
    When sales manager clicks "Create" button
    And sales manager enters the name and the address
    And sales manager clicks "Save" button
    Then verify it is listed the new customer by searching the name

