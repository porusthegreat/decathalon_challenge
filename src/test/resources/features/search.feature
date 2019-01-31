Feature: Search a Product

  @search
  Scenario: Search a product and verify results
    When user chooses to search by iphone
    Then user verifies the results contain iphone