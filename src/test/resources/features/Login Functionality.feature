Feature: Login Test

  Scenario Outline: Valid Login

    Given the user navigates to the login page
    When enter valid "<username>" and "<password>"
    And click login button
    Then Secure Area page should display

    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |


  Scenario Outline: Invalid Login

    Given the user navigates to the login page
    When enter invalid "<invalidusername>" and "<invalidpassword>"
    And click login button
    Then error message should display

    Examples:
      | invalidusername | invalidpassword |
      | wrongusername   | wrongpassword!  |


  Scenario: Blank Login

    Given the user navigates to the login page
    When enter Blank username and password
    And click login button
    Then error message should display for blank