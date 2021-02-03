
Feature: Message and report validation
  As a valid and logged-in user I want to send messages from the SMS module
  then from the reports module download the report

  Scenario: A user send a message and download report
    Given a user logged to Tellit choose an option
    When the user do a "fast send"
    And the user fill the form
    Then the user can download a report

