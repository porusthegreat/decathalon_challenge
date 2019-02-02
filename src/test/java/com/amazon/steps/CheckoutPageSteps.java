package com.amazon.steps;

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
        assertEquals("Cart price has not got updated", actualPrice, currentScenario.getPrice() + currentScenario.getCartPrice());
    }
}
