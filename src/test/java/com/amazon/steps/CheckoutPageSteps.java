package com.amazon.steps;

import cucumber.api.java.en.Then;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutPageSteps extends BaseSteps {

    @Then("user verifies the price shown in checkout page")
    public void userVerifiesProductAndPriceShownInCheckoutPage() {
        String actualPrice = checkoutPage.getPrice();
        assertEquals("Price mismatch in checkout page", currentScenario.getPrice(), actualPrice);
    }
}
