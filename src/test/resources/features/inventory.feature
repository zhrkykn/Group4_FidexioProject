@ip
Feature: inventory button

  Background:
    Given the user is on the login in



    When the user is clicked inventory button
    And the user clicked the product button
    Then the create button seen



  Scenario: User create new product

    Then Add product name
    Then Add product Type
    And Add sales price
    And Click on product save button
    Then Get the created message


  Scenario: User can not create product without product name

    Then Add Product Type
    And Add sales price
    And Click on product save button
    And Error message is displayed