Feature: Header is displayed after search

  Scenario Outline: Validate that the headers is displayed after search
    Given Home page of 9gag.com is opened
    When Search button is clicked
    Then User writes "<item>" in the search
    And Enter is pressed
    Then Header is displayed

    Examples:
      | item  |
      | shoes |