Feature: Orange HRM admin
  Scenario: Open the Admin page
    Given I am logged in to Orange HRM
    When I click the Admin menu link
    Then the Orange HRM Admin page should be opened

  Scenario: Search for a user by username
    Given I am logged in to Orange HRM
    When I click the Admin menu link
    Then the Orange HRM Admin page should be opened
    When I enter the Admin username
    And I click the Admin Search button
    Then the searched username should be displayed
