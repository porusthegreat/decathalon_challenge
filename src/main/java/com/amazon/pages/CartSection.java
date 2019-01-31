package com.amazon.pages;

import com.amazon.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class CartSection extends BasePage {

    @FindBy(id = "submit.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "#newAccordionRow span.a-color-price .currencyINR")
    private WebElement selectedPriceValue;

    CartSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String getSelectedPriceOfProduct() {
        waitForElementVisibility(selectedPriceValue);
        return selectedPriceValue.getText().trim();
    }

    void clickOnAddToCartButton() {
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }
}
