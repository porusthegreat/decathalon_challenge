package com.amazon;

import org.openqa.selenium.JavascriptExecutor;
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

    protected void switchToActiveTab(){
        String parentWindow = driver.getWindowHandle();

        for(String childWindow:driver.getWindowHandles())
            if(!childWindow.equals(parentWindow))
                driver.switchTo().window(childWindow);
            else
                driver.close();
    }

    protected void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
