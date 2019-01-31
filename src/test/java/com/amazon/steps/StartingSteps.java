package com.amazon.steps;

import com.amazon.driver.InitDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class StartingSteps {

    private WebDriver driver;

    @Before
    public void beforeSteps() throws MalformedURLException {
        System.out.println("Before steps");
        driver = new InitDriver(System.getProperty("browser")).init();
    }

    @After
    public void destroyDriver(){
        driver.quit();
    }

}
