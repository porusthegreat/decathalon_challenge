package com.amazon.pages;

import com.amazon.BasePage;
import com.amazon.driver.DriverProvider;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage extends BasePage {

    private CartSection cartSection;

    private CartSection getCartSection() {
        return cartSection;
    }

    public ProductDescriptionPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
        cartSection = new CartSection(driver);
    }

    public void addTheProductToCart() throws InterruptedException {
        getCartSection().clickOnAddToCartButton();
        Thread.sleep(3000);
    }

    public String getThePriceOfTheProductToBeAddedToCart(){
        return getCartSection().getSelectedPriceOfProduct();
    }
}
