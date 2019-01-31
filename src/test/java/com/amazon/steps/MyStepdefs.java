package com.amazon.steps;

import com.amazon.login.LoginScreen;
import cucumber.api.java.en.Given;

public class MyStepdefs extends BaseTest {

    @Given("user is on amazon home page")
    public void userIsOnAmazonHomePage() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.navigateToHomePage();
    }
}
