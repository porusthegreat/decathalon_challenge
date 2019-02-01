package com.amazon.pages;

import com.amazon.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class CartSection extends BasePage {

    @FindBy(id = "submit.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "#newAccordionRow .a-section.a-spacing-none.a-padding-none .a-color-price")
    private WebElement selectedPriceValue;

    CartSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void clickOnAddToCartButton() {
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }

    String getPriceOfProductSelected() {
        waitForElementVisibility(selectedPriceValue);
        return selectedPriceValue.getText();
    }
}
