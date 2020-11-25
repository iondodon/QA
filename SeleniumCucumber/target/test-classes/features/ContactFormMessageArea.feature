Feature: Expanding message area
  Scenario: Validate that the message area from the contact form expands only top-bottom
    Given The website is open on the Contact page
    When I Click on the corner of the message area from the Contact Form
    And Drag the corner of the message area left to right
    Then The width of the message area should not change
