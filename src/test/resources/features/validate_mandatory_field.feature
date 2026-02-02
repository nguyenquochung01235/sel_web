Feature: Validate Mandatory Field
  @test
  Scenario: Validate Mandatory Field
    Given user have login to OrangeHRM
    When user navigate to AddUserPage Page
    And click button Add User
    And user click Save Button
    Then verify username message as "Required"
    Then verify user role message as "Required"
    Then verify employee name message as "Required"
    Then verify status message as "Required"
    Then verify password Message as "Required"
    Then verify Confirm Password Message as "Passwords do not match"

  @test
  Scenario: Validate Mandatory Field 2
    Given user have login to OrangeHRM
    When user navigate to AddUserPage Page
    And click button Add User
    And user select User Role
    And user input employee name as "John akhil Doe"
    And User select status
    And user enter username as "NguyenA"
    And User input Password
    And User input confirm Password
    And user click Save Button

    @test
    Scenario: verify Cancel Button
      Given user have login to OrangeHRM
      When user navigate to AddUserPage Page
      And click button Add User
      And User click Cancel Button
      Then user click user button
      Then user click logout button



