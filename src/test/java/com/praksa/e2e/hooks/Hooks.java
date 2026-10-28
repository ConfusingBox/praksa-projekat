package com.praksa.e2e.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private final WebDriver driver;

    @Inject
    public Hooks(WebDriver driver) {
        this.driver = driver;
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
