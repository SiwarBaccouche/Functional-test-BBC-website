@Password
Feature: User Changes Password

  Background: Successful login
    Given the user is on the login page
    When the user clicks the Sign In link
    And the user enters an email as "siwarbaccouche.isitc@gmail.com"
    And clicks on the continue button
    And the user enters a password as "NewSuperSecurePassword3"
    And clicks on the next button
    Then the user should see your account button

  @FailedPasswordChanging
  Scenario Outline: Password failed to change
    Given the user in personal details page
    When the user clicks on the edit password button
    And the user enters new password as "<password>"
    And the user clicks on show password
    And the user clicks on save and continue button
    Then the user should see a password change error message
    Examples:
    | password |
    | NewSuperSecurePassword3 |

  @SuccessfulPasswordChanging
  Scenario Outline: Password Changed Successfully
    Given the user in personal details page
    When the user clicks on the edit password button
    And the user enters new password as "<password>"
    And the user clicks on save and continue button
    Then the user should see a successful password change message
    Examples:
      | password |
      | NewSuperSecurePasswordTest |