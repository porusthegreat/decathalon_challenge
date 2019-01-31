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
        assertTrue(actualOutput.toLowerCase().contains(expectedSearchTerm));
    }

    public void selectFirstProductInResults() {
        getSearchResultsSection().clickOnFirstProductInSearchResults();
    }
}
