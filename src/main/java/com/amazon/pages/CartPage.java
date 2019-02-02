package com.amazon.pages;

import com.amazon.BasePage;
import com.amazon.driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CartPage extends BasePage {


    @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
    private List<WebElement> itemsListAddedToCart;

    @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
    private WebElement cartItem;

    String quantity = "a#dropdown1_%s.a-dropdown-link";

    @FindBy(id = "a-autoid-0-announce")
    private WebElement quantityList;

    @FindBy(name = "quantityBox")
    private WebElement quantityTextBox;

    @FindBy(css = ".sc-update-link .a-button-text")
    private WebElement updateItemsInCart;

    @FindBy(css = "#sc-subtotal-amount-activecart span")
    private WebElement priceIncartPage;

    public CartPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    private String getItemNameInCart() {
        waitForElementVisibility(cartItem);
        return itemsListAddedToCart.get(0).getText();
    }

    public void assertItemNameInCart(String expectedItem) {
        assertTrue("First item in cart items list does not contain expected item: ",
                getItemNameInCart().toLowerCase().contains(expectedItem));
    }

    public void increaseCurrentProductUnitsTo(int numberOfItems) {
        waitForElementVisibility(quantityList);
        quantityList.click();
        waitForElementVisibility(driver.findElement(By.cssSelector(String.format(quantity, numberOfItems - 1))));
        driver.findElement(By.cssSelector(String.format(quantity, numberOfItems - 1))).click();

        try {
            quantityTextBox.clear();
            quantityTextBox.sendKeys(String.valueOf(numberOfItems));
            updateItemsInCart.click();
        } catch (Exception ignore) {}
    }

    public Double verifyThePriceHasGotUpdateWithItemQuantityIncreasedTo(int parseInt, String pricePerItem) {
        waitForElementVisibility(priceIncartPage);

        String actualPriceString = priceIncartPage.getText().replace(" ", "")
                .substring(0, priceIncartPage.getText().replace(" ", "").length() - 3)
                .replace(",", "");

        double actualPrice = Integer.parseInt(actualPriceString);

        String expectedPriceString = pricePerItem.trim();
        double expectedPricePerItem = Integer.parseInt(expectedPriceString
                .substring(0, expectedPriceString.length() - 3)
                .replace(",", ""));

        double expectedPrice = expectedPricePerItem * parseInt;

        assertEquals("Expected price did not match according to the items updated", expectedPrice, actualPrice, 0);
        return actualPrice;
    }

    public double getActualCartPrice() {
        waitForElementVisibility(priceIncartPage);

        String actualPriceString = priceIncartPage.getText().replace(" ", "")
                .substring(0, priceIncartPage.getText().replace(" ", "").length() - 3)
                .replace(",", "");

        return Integer.parseInt(actualPriceString);
    }
}
