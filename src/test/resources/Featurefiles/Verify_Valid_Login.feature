@ValidLogin
Feature: Valid user login

  Scenario: Log in with valid credentials
    Given the user opens the OrangeHRM login page
    When the user logs in with the configured valid credentials
    Then the user should be redirected to the dashboard
