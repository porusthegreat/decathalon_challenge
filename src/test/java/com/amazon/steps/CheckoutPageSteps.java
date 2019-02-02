package com.amazon.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutPageSteps extends BaseSteps {

    @Then("user verifies the price shown in checkout page")
    public void userVerifiesProductAndPriceShownInCheckoutPage() {
        double actualPrice = checkoutPage.getPrice();
        assertEquals("Price mismatch in checkout page", currentScenario.getPrice(), actualPrice);
    }

    @Then("user verifies the cart price has updated")
    public void userVerifiesTheCartPriceHasUpdated() {
        double actualPrice = cartPage.getActualCartPrice();
        currentScenario.setCartPrice(currentScenario.getPrice() + currentScenario.getCartPrice());
        assertEquals("Cart price has not got updated", actualPrice, currentScenario.getCartPrice());
    }

    @And("user removes an item from cart")
    public void userRemovesAnItemFromCart() throws InterruptedException {
        currentScenario.setPrice(cartPage.removeOneItemOnTop());
    }

    @Then("user verifies the cart price has got updated after removing cart items")
    public void userVerifiesTheCartPriceHasGotUpdatedAccordingly() {
        double actualCartPrice = currentScenario.getCartPrice() - currentScenario.getPrice();
        currentScenario.setCartPrice(actualCartPrice);

        double actualPrice = cartPage.getActualCartPrice();
        assertEquals("Cart price has not got updated", actualPrice, currentScenario.getCartPrice());
    }

    @After
    public void clearTheCart(){
        cartPage.deleteAllCartItems();
    }
}
