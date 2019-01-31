package com.amazon.login;


import com.amazon.BaseScreen;
import com.amazon.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends BaseScreen {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    public LoginScreen() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() throws InterruptedException {
        driver.get("https://www.amazon.in");
        waitForElementVisibility(searchBox);
        searchBox.sendKeys("iPhone 6s");
    }
}
