Feature: Send a message and download report

  Scenario: Send a message and download report
    Given a user loged to tellit
    When the user do a "fast send"
    Then the user can download a report

