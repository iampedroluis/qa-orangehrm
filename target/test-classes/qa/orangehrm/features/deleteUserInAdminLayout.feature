@DeleteUser @AllTests
Feature: Delete a user in the Admin panel

   Scenario: Successfully delete a user with ESS role
    Given The user logs in as an administrator
    When The user clicks on the Admin panel option in the navigation menu
    Then The user should be redirected to the User Management
    When The user searches for "Uzerv-test01" in the System user input field
    And The user clicks on the Search button
    Then The user should see the "Uzerv-test01" in the search results
    When The user clicks on the Delete button for the "Uzerv-test01" user
    Then A delete confirmation message is displayed
    When The user clicks on the Yes button in the confirmation message
    Then The user should see a success message indicating the user has been deleted
