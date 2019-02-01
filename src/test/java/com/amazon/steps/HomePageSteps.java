package com.amazon.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends BaseSteps {

    @When("user chooses to search by (.*)")
    public void userChoosesToSearchByIphone(String searchTerm) {
        homePage.searchBy(searchTerm);
    }

    @Then("user verifies the results contain (.*)")
    public void userVerifiesTheResultsContainIphone(String searchTerm) {
        homePage.verifySearchResultsContain(searchTerm);
        currentScenario.setItemName(searchTerm);
    }

    @And("user adds the first product in results to cart")
    public void userAddsTheFirstProductInResultsToCart() throws InterruptedException {
        homePage.selectFirstProductInResults();
        String actualPriceBeforeAddingToCart = productDescriptionPage.getThePriceOfTheProductToBeAddedToCart();
        currentScenario.setPrice(actualPriceBeforeAddingToCart);
        productDescriptionPage.addTheProductToCart();
    }


    @And("user navigates to my cart page")
    public void userNavigatesToMyCartPage() {
        homePage.clickOnMyCartButton();
    }

    @Then("user verifies the item added to cart")
    public void userVerifiesTheItemAddedToCart() {
        cartPage.assertItemNameInCart(currentScenario.getItemName());
    }
}
