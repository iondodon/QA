Feature: Header is displayed after search

  Scenario: Validate that the headers is displayed after search
    Given Home page of 9.gag.com is opened
    When Search button is clicked
    Then User writes something in the search
    And Enter is pressed
    Then Header is displayed
