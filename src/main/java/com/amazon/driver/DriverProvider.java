package com.amazon.driver;

import org.openqa.selenium.WebDriver;

public class DriverProvider {

    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        return webDriver;
    }

    static void setDriver(WebDriver driver) {
        webDriver = driver;
    }
}
