package com.amazon.driver;

import com.amazon.utils.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class InitDriver {

    private String browser;

    public InitDriver(String browser) {
        this.browser = browser;
    }

    public WebDriver init() throws MalformedURLException {

        WebDriver driver;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser){
            case Browsers.CHROME:
                driver = getChromeDriver();
                break;
            case Browsers.FIREFOX:
                driver = getFirefoxDriver();
                break;
            default:
                driver = getChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverProvider.setDriver(driver);
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        return new FirefoxDriver();
    }

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "binaries/chromedriver");
       return new ChromeDriver();
    }

}
