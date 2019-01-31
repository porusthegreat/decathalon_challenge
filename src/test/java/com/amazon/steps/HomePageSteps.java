package com.amazon.steps;

import com.amazon.pages.ProductDescriptionPage;
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
    }

    @And("user adds the first product in results to cart")
    public void userAddsTheFirstProductInResultsToCart() throws InterruptedException {
        homePage.selectFirstProductInResults();
        Thread.sleep(3000);
        String actualPriceBeforeAddingToCart = productDescriptionPage.getThePriceOfTheProductToBeAddedToCart();
        System.out.println(actualPriceBeforeAddingToCart);
        productDescriptionPage.addTheProductToCart();
    }


}
