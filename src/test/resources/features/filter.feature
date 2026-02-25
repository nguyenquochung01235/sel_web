Feature: Filter
  @test-filter
  Scenario: Login and select filter A-Z Option
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "standard"
    Then user chose filter A-Z option
    And verify A-Z Product List

  @test-filter
  Scenario: Login and select filter Z-A Option
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "standard"
    Then user chose filter Z-A option
    And verify Z-A Product List
  @test-filter
  Scenario: Login and select filter Low to High Option
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "standard"
    Then user chose filter Low - High option
    And verify Low to High Product Price
  @test-filter
  Scenario: Login and select filter High to Low Option
    Given user open browser and navigate to sauce demo
    When user login using data provide in excel file "standard"
    Then user chose filter High-Low option
    And verify High to Low Product Price