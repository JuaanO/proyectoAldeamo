
Feature: Message and report validation
  As a valid and logged-in user I want to make a "fast send" from the SMS module
  then from the reports module download the report

  Scenario: A user send a message and download report
    Given a user loged to tellit
    When the user do a "fast send"
    Then the user can download a report

