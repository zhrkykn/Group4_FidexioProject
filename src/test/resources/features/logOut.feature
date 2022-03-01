@FIDE-695
Feature: LogOut features

  Background:
    Given the user is on the login page
    And Enter the user credentials
  @FIDE-693
  Scenario: user proper logout
    When the user logged out
    Then user should be logged out of account
  @FIDE-694
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out
    When the user logged out
    And try to back after successfully logged out
    Then user should see warning mesage