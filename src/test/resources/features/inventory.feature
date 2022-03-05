@FIDE-709
Feature: inventory button

  Background:
    Given the user is on the login in
    When the user is clicked inventory button
    #And the user clicked the product button


  @FIDE-705

  Scenario: User create new product
    Then Click on Create button
    Then Add product name
    #Then Add product Type
    #And Add sales price
    And Click on Save button
    Then Get the created message

  @FIDE-706
  Scenario: User can not create product without product name
    Then Click on Create button
    Then Add Product Type
    And Add sales price
    And Click on Save button
    And Error message displayed

  @FIDE-707
  Scenario: Verify that a new product can be found in the search.

    Then click search button
    And product name written
    Then product name found on the list
  @FIDE-708
  Scenario: Verify that all the saved details are listed correctly.

    Then click search button
    And product name written
    Then product name found on the list
    Then product type and sales price seen

