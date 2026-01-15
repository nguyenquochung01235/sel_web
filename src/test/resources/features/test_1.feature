Feature: Test Feature 1
  Background:
    Given user open browser

  Scenario: Scenario Test 1 Pass
    When navigate to google.com
    Then close browser

  Scenario: Scenario Test 1 Fail
    When navigate to fail google.com
    Then close browser