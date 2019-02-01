package com.amazon.pages;

import com.amazon.BasePage;
import com.amazon.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(css = ".a-color-price.hlb-price.a-inline-block.a-text-bold span")
    private WebElement priceInCheckoutPage;

    public CheckoutPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        waitForElementVisibility(priceInCheckoutPage);
        return priceInCheckoutPage.getText().trim();
    }
}
