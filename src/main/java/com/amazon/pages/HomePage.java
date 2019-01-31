package com.amazon.pages;


import com.amazon.BasePage;
import com.amazon.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    public HomePage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void searchBy(String searchTerm){
        waitForElementVisibility(searchBox);
        searchBox.sendKeys(searchTerm);
    }
}
