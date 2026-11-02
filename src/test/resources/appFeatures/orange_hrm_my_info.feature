Feature: Orange HRM My Info
  Scenario: Update My Info contact details
    Given I am logged in to Orange HRM
    When I click the My Info menu link
    Then the View Personal Details page should be opened
    When I click the Contact Details submenu link
    Then the Contact Details page should be opened
    When I change my Country to "Albania"
    And I change my City to "Ruski Krstur"
    And I click the Save button
    Then my country should be "Albania"
    And my city should be "Ruski Krstur"