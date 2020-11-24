Feature: Contact Form Send Message

  Scenario: Validate that user can submit a message via contact form
    Given Contact web page is opened
    Then The Contact form is displayed
    When User fills in the contact form:
      | username | email                           | subject          | message          |
      | iondodon | ion.dodon@ati.utm.md            | Testing          | My test message  |
    And The SEND button is pressed
    Then Validate that contact form is send successfully