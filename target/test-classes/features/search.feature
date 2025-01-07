Feature: Search Feature

  Background: Successful login
    Given the user is on the login page
    When the user clicks the Sign In link
    And the user enters an email as "siwarbaccouche.isitc@gmail.com"
    And clicks on the continue button
    And the user enters a password as "NewSuperSecurePassword2"
    And clicks on the next button
    Then the user should see your account button

  @SuccessfulSearch
  Scenario Outline: Search a valid article
    Given the user is on home page
    When the user clicks the search icon
    And the user enters a title as "<article>"
    And clicks on the search button
    Then the user should see the searched article
    Examples:
      | article |
      | Elon Musk changes his name to Kekius Maximus on X  |

  @FailedSearch
  Scenario Outline: Search an unvalid article
    Given the user is on home page
    When the user clicks the search icon
    And the user enters a title as "<badarticle>"
    And clicks on the search button
    Then the user should see an error message
    Examples:
      | badarticle |
      | Elon Musk changes his name to Kekius Maximus on Xinvalid search  |
