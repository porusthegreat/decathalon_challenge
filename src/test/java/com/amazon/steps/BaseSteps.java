package com.amazon.steps;

import com.amazon.pages.CheckoutPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductDescriptionPage;

public class BaseSteps {

    HomePage homePage = new HomePage();
    ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    ScenarioContext currentScenario = new ScenarioContext();
}
