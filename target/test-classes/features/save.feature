Feature: Search Feature

  Background: Successful login and search
    Given the user is on the login page
    When the user clicks the Sign In link
    And the user enters an email as "siwarbaccouche.isitc@gmail.com"
    And clicks on the continue button
    And the user enters a password as "NewSuperSecurePassword2"
    And clicks on the next button
    Then the user should see your account button
    And the user is on home page
    When the user clicks the search icon
    And the user enters a title as "Elon Musk changes his name to Kekius Maximus on X"
    And clicks on the search button
    Then the user should see the searched article


  @SuccessfulSave
  Scenario: Save a valid article
    Given the user is on the searched article
    When the user clicks the searched article
    And the user clicks save button
    And clicks on the account bar
    And clicks on the saved bar
    Then the user should see the saved article

  @FailedSave
  Scenario: Empty savings
    Given the user is on the searched article
    When the user clicks the searched article
    And skips clicking the save button
    And clicks on the account bar
    And clicks on the saved bar
    Then the user should see a save error message
