package com.praksa.e2e.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHrmLiveLogin extends BasePage {
    private static final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    private static final By COOKIE_ACCEPT = By.xpath(
            "//button[normalize-space()='Accept all' or normalize-space()='I agree' or .//div[normalize-space()='Accept all']]"
    );

    private static final By USERNAME_INPUT = By.xpath("//input[@name='username']");

    private static final By PASSWORD_INPUT = By.xpath("//input[@name='password']");

    private static final By LOGIN_BUTTON = By.xpath("//button");

    @Inject
    public OrangeHrmLiveLogin(WebDriver driver) {
        super(driver);
    }

    public OrangeHrmLiveLogin open(){
        open(URL);
        return this;
    }

    public boolean isUsernameInputVisible(){
        return isAnyDisplayed(USERNAME_INPUT);
    }

    public boolean isPasswordInputVisible(){
        return isAnyDisplayed(PASSWORD_INPUT);
    }

    public boolean isLoginButtonVisible(){
        return isAnyDisplayed(LOGIN_BUTTON);
    }

    public void enterUsername(){
        WebElement usernameInput =  wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        usernameInput.clear();
        usernameInput.sendKeys("Admin");
    }

    public void enterPassword(){
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        passwordInput.clear();
        passwordInput.sendKeys("admin123");
    }

    public String getUsernameValue(){
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        return usernameInput.getAttribute("value");
    }

    public String getPasswordValue(){
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        return passwordInput.getAttribute("value");

    }

    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON)).click();
    }
}
