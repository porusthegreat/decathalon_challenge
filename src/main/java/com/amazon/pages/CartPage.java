package com.amazon.pages;

import com.amazon.BasePage;
import com.amazon.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class CartPage extends BasePage {


    @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
    private List<WebElement> itemsListAddedToCart;

    @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
    private WebElement cartItem;

    public CartPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    private String getItemNameInCart(){
        waitForElementVisibility(cartItem);
        return itemsListAddedToCart.get(0).getText();
    }

    public void assertItemNameInCart(String expectedItem){
        assertTrue("First item in cart items list does not contain expected item: ",
                getItemNameInCart().toLowerCase().contains(expectedItem));
    }

}
