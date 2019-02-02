package com.amazon.pages;


import com.amazon.BasePage;
import com.amazon.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.Assert.assertTrue;

public class HomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = ".nav-input")
    private WebElement searchIcon;

    private SearchResultsSection searchResultsSection;

    @FindBy(css = ".nav-cart-icon.nav-sprite")
    private WebElement cartIcon;

    @FindBy(css = ".a-color-price.s-price")
    private WebElement getPriceOfitemToBeSelected;

    private SearchResultsSection getSearchResultsSection() {
        return searchResultsSection;
    }

    public HomePage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
        searchResultsSection = new SearchResultsSection(driver);
    }

    public void searchBy(String searchTerm){
        waitForElementVisibility(searchBox);
        searchBox.sendKeys(searchTerm);
        searchIcon.click();
    }

    public void verifySearchResultsContain(String expectedSearchTerm) {
        String actualOutput = getSearchResultsSection().getTitleOfFirstItemInSearchResults();
        assertTrue("First item in search results does not contain: " + expectedSearchTerm, actualOutput.toLowerCase().contains(expectedSearchTerm));
    }

    public void selectFirstProductInResults() {
        getSearchResultsSection().clickOnFirstProductInSearchResults();
    }

    public void clickOnMyCartButton() {
        waitForElementToBeClickable(cartIcon);
        cartIcon.click();
    }

    public String getThePriceOfTheProductToBeAddedToCart() {
        waitForElementVisibility(getPriceOfitemToBeSelected);
        return getPriceOfitemToBeSelected.getText().trim().replace(",", "");
    }
}
