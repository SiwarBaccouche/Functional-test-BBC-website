@Logout
Feature: User Logout

  Background: Successful login
    Given the user is on the login page
    When the user clicks the Sign In link
    And the user enters an email as "siwarbaccouche.isitc@gmail.com"
    And clicks on the continue button
    And the user enters a password as "EPIdigitalschool5"
    And clicks on the next button
    Then the user should see your account button

  @SuccessfulLogout
  Scenario: Successful logout
    Given the user is on the home page
    When the user clicks on the account button
    And the user clicks on the logout button
    Then the user should see a successful logout message