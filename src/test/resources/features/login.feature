@FIDE-683
Feature: Posmanager is login

  Background:
    Given the user is on the login page
  @FIDE-679
  Scenario: Login as a user
    When Enter the user credentials
    Then User should be able to login
  @FIDE-680
  Scenario Outline: Login with wrong credentials
    When the user enters invalid user information "<userType>" "<passWord>"
    Then error message should be displayed
    Examples:
      | userType              | passWord   |
      | posmanager10@info.com | password   |
      | username              | posmanager |

  @FIDE-681
  Scenario Outline: Login with blank credentials for username
    When the user enters blank user information "<userType>" "<passWord>"
    Then alert message should be displayed for username
    Examples:
      | userType | passWord   |
      |          | posmanager |
  @FIDE-682
  Scenario Outline: Login with blank credentials for password
    When the user enters blank user information "<userType>" "<passWord>"
    Then alert message should be displayed for password
    Examples:
      | userType              | passWord |
      | posmanager10@info.com |          |