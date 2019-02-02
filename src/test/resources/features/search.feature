Feature: Search a Product

  @search @add_to_cart @verify_cart_items
  Scenario Outline: Search a product and verify results
    When user chooses to search by <product>
    Then user verifies the results contain <product>
    And user adds the first product in results to cart
    Then user verifies the price shown in checkout page
    And user navigates to my cart page
    Then user verifies the item added to cart
    When user increases the number of items in cart to <numberOfItems>
    Then the price should get updated accordingly to <numberOfItems>
    Examples:
      | product | numberOfItems |
      | redmi 5 | 4             |