Feature: Search for an item

  Scenario Outline: Validate that searching for an item works properly
    When The home page is opened
    And In search bar write an item "<item>"
    When The search icon is clicked
    Then Validate that the page with the item is returned
    Examples:
      | item  |
      | shoes |