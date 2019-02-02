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
    When user chooses to search by <anotherProduct>
    Then user verifies the results contain <anotherProduct>
    And user adds the first product in results to cart
    And user navigates to my cart page
    Then user verifies the item added to cart
    Then user verifies the cart price has updated
    And user removes an item from cart
    Then user verifies the cart price has got updated after removing cart items
    Examples:
      | product | numberOfItems | anotherProduct |
      | redmi 5 | 4             | oneplus 6t     |