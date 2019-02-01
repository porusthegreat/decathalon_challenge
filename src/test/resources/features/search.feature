Feature: Search a Product

  @search @add_to_cart
  Scenario Outline: Search a product and verify results
    When user chooses to search by <product>
    Then user verifies the results contain <product>
    And user adds the first product in results to cart
    Then user verifies the price shown in checkout page
    Examples:
      | product    |
      | oneplus 6t |