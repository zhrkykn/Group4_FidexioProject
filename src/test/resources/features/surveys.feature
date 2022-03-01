@fc
Feature: As a posmanager, I should be able to create and design a new survey from "Surveys" module

  Background:
    Given the user is logged in as posmanager
    When the  user clicks on the  Surveys module

  Scenario: verify that "Create" button work as expected in the survey design page
    When the user clicks on the "Create" button
    Then the user  sees the  title "New - Odoo"


  Scenario: verify that "Import" button work as expected in the survey design page
    When the user clicks on the "Import" button
    Then User should see "Import a File - Odoo" title


  Scenario:Verify that the "Survey created" message appears
    When the user clicks on create button
    And the user enters survey title as "Customer Survey3"
    And the user clicks on Save Button
    Then the user should see "Survey created" message


  Scenario: Verify that user can not create a survey without Survey Title
    When the user clicks on create button
    And the user clicks on Save Button
    Then Error message displayed

  Scenario: Verify that the user should be able to see created survey is listed after clicking the Surveys module.
    Then the user should be able to see created survey is listed