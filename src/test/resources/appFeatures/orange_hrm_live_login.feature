Feature: Orange HRM Live Login
  Scenario: Orange HRM Live Login contains username input
    Given I open the Orange HRM Live Login
    Then the username input should be visible

  Scenario: Orange HRM Live Login contains password input
    Given I open the Orange HRM Live Login
    Then the password input should be visible

  Scenario: Orange HRM Live Login contains Login button
    Given I open the Orange HRM Live Login
    Then the login button should be visible

  Scenario: Enter valid Orange HRM Credentials
    Given I open the Orange HRM Live Login
    And I enter valid Orange HRM Credentials
    Then valid Orange HRM credentials should be entered

  Scenario: Login with valid Orange HRM credentials
    Given I open the Orange HRM Live Login
    And I enter valid Orange HRM Credentials
    When I click the Login button
    Then the Orange HRM Dashboard should be opened