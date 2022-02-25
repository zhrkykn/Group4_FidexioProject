
Feature: inventory button

  Background:
    Given the user is on the login in
    When the user is clicked inventory button
    And the user clicked the product button




  Scenario: User create new product
    Then the create button seen
    Then Add product name
    Then Add product Type
    And Add sales price
    And Click on product save button
    Then Get the created message


  Scenario: User can not create product without product name
    Then the create button seen
    Then Add Product Type
    And Add sales price
    And Click on product save button
    And Error message displayed


    Scenario: Verify that a new product can be found in the search.

      Then click search button
      And product name written
      Then product name found on the list




    Scenario: Verify that all the saved details are listed correctly.

      Then click search button
      And product name written
    Then product name found on the list
      Then product type and sales price seen