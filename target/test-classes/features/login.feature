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
      | siwarbaccouche.isitc@gmail.com | NewSuperSecurePassword2 |

  @InvalidCredentials
  Scenario Outline: Failed login
    Given the user is on the login page
    When the user clicks the Sign In link
    And  the user enters an email as "<email>"
    And clicks on the next button
    Then the user should see error message

    Examples:
      | email |
      |  verywrongemail@gggmail.com |


#  @InvalidPassword
#  Scenario Outline: Failed login wrong password
#    Given the user is on the login page
#    When the user clicks the Sign In link
#    And  the user enters an email as "<email>"
#    And clicks on the continue button
#    And the user enters a password as "<password>"
#    And clicks on the next button
#    Then the user should see password error message
#
#    Examples:
#      | email | password |
#      |  siwarbaccouche.isitc@gmail.com  | SuperSecretPassword!!! |
