@LoginUser @AllTests
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given The user navigates to the login page
    When The user enters a valid username and password
      |username  |password  |
      | Admin    | admin123 |
    And The user clicks on the login button
    Then The user should be redirected to the dashboard page