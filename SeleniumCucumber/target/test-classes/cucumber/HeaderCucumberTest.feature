Feature: HeaderCucumberTest

  Scenario: Website header exists

    Given I have open the browser

    When I open 9gag website

    When I search for Computer

    Then Header should exits