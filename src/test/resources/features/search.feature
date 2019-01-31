Feature: Search a Product

  @search
  Scenario: Search a product and verify results
    When user chooses to search by iphone 6s
    Then user verifies the results contain iphone 6s
    And user adds the first product in results to cart