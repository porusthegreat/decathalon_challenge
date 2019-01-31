package com.amazon.steps;

import com.amazon.login.HomePage;
import cucumber.api.java.en.Given;

public class HomePageSteps extends BaseSteps {

    @Given("user is on amazon home page")
    public void userIsOnAmazonHomePage() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
    }
}
