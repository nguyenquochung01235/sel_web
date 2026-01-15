Feature: Test Feature 2
  Scenario: Scenario Test 2 Pass
    Given user open browser
    When navigate to example.com
    Then close browser

  Scenario: Scenario Test 2 Fail
    Given user open browser
    When navigate to fail google.com
    Then close browser