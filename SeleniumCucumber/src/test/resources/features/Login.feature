Feature: Login

  Scenario: Validate that user can login
    Given The website is open
    When Is pressed the sign in button
    Then Should appear the authentication form
    And User user inserts his credentials:
      | username    | email                      |
      | iondodon    | ion.dodon@ati.utm.md       |
    And Sign In button is pressed
    Then Appears the page with the user authenticated