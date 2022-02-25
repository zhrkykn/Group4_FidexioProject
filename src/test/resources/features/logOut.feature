Feature: LogOut features

  Background:
    Given the user is on the login page
    And Enter the user credentials

  Scenario: user proper logout
    When the user logged out
    Then user should be logged out of account

  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out
    When the user logged out
    And try to back after successfully logged out
    Then user should see warning mesage