package com.amazon.pages;

import com.amazon.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

class SearchResultsSection extends BasePage {

    @FindBy(css = ".a-size-medium.s-access-title.a-text-normal")
    private WebElement searchResultsTitle;

    @FindBy(css = ".a-size-medium.s-access-title.a-text-normal")
    private List<WebElement> searchResultsTitleList;


    SearchResultsSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String getTitleOfFirstItemInSearchResults() {
        waitForElementVisibility(searchResultsTitle);
        return searchResultsTitleList.get(0).getText();
    }

    void clickOnFirstProductInSearchResults() {
        waitForElementToBeClickable(searchResultsTitle);
        searchResultsTitleList.get(0).click();
        switchToActiveTab();
    }
}
