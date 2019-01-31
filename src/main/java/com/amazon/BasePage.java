package com.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public WebElement waitForElementToBeClickable(WebElement element) {
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(element));
        return myDynamicElement;
    }

    public WebElement waitForElementVisibility(WebElement element) {
        WebElement wait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(element));
        return wait;
    }
}
