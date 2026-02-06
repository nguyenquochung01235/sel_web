Feature: Login
  @test
  Scenario: Login using standard account
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "standard"
    Then verify login pass account

  @test
  Scenario: Login using lock account
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "lock"
    Then verify login fail account "Epic sadface: Sorry, this user has been locked out."

  @test
  Scenario: Login using problem account
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "problem"
    Then verify login pass account

  @test
  Scenario: Login using performance account
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "performance"
    Then verify login pass account

  @test
  Scenario: Login using standard_nonepass account
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "standard_nonepass"
    Then verify login fail account "Epic sadface: Username is required"

  @test
  Scenario: Login using none_username account
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "none_username"
    Then verify login fail account "Epic sadface: Username is required"

  @test
  Scenario: Login using black_user account
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "blank_user"
    Then verify login fail account "Epic sadface: Username is required"