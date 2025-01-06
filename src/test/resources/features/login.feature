Feature: Login Functionality

  @runValidLoginAsAdmin
  Scenario Outline: Login with Valid Credentials
    Given the user is on the login page
    When the user clicks the Sign In link
    And  the user enters an email as "<email>"
    And clicks on the continue button
    And the user enters a password as "<password>"
    And clicks on the next button
    Then the user should see your account button
    Examples:
      |email|password|
      | siwarbaccouche.isitc@gmail.com | EPIdigitalschool5 |
#
#  @InvalidCredentials
#  Scenario Outline: Failed login
#    Given the user is on the login page
#    When the user clicks the Sign In link
#    And  the user enters an email as "<email>"
#    And clicks on the continue button
#    And the user enters a password as "<password>"
#    And clicks on the next button
#    Then the user should see an error message
#
#    Examples:
#      | email | password |
#      |  siwarbaccouche.isitc@gmail.com | SuperSecretPassword!!! |
