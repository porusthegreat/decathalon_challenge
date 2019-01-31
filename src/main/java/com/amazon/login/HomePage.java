package com.amazon.login;


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

    public void navigateToHomePage() throws InterruptedException {
        driver.get("https://www.amazon.in");
        waitForElementVisibility(searchBox);
        searchBox.sendKeys("iPhone 6s");
    }
}
