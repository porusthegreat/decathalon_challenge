package com.amazon.steps;

import com.amazon.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends BaseSteps {

    @When("user chooses to search by (.*)")
    public void userChoosesToSearchByIphone(String searchTerm) {
        HomePage homePage = new HomePage();
        homePage.searchBy(searchTerm);
    }

    @Then("user verifies the results contain iphone")
    public void userVerifiesTheResultsContainIphone() {

    }
}
