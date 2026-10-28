package com.praksa.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected List<WebElement> waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected boolean isAnyDisplayed(By locator) {
        return waitForPresence(locator).stream().anyMatch(WebElement::isDisplayed);
    }
}
