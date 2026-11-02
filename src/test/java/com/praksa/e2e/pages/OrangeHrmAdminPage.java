package com.praksa.e2e.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;



public class OrangeHrmAdminPage extends BasePage{

    private static final String ADMIN_URL_PART = "/web/index.php/admin/";

    private static final By ADMIN_SEARCH_USERNAME_INPUT_TEXTBOX = By.xpath(("(//input[@class='oxd-input oxd-input--active'])[2]"));
    private static final By ADMIN_SEARCH_BUTTON = By.xpath(("//button[text() =' Search ']"));
    private static final By ADMIN_SEARCHED_USERNAME = By.xpath(
            "(//div[contains(@class,'oxd-table-body')]" +
                    "//div[normalize-space()='Admin' and not(*)])[1]"
    );
    @Inject
    public OrangeHrmAdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAdminPageOpen(){
        return wait.until(ExpectedConditions.urlContains(ADMIN_URL_PART));
    }

    public boolean isAdminSearchUsernameVisible(){
        return isAnyDisplayed(ADMIN_SEARCH_USERNAME_INPUT_TEXTBOX);
    }

    public void enterUsername(){
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_SEARCH_USERNAME_INPUT_TEXTBOX));
        usernameInput.clear();
        usernameInput.sendKeys("Admin");
    }

    public void clickSearchButton(){
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_SEARCH_BUTTON));
        searchButton.click();
    }

    public String getSearchedUsername() {
        WebElement usernameElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        ADMIN_SEARCHED_USERNAME
                )
        );
        System.out.println(usernameElement.getDomProperty("textContent").trim());
        return usernameElement
                .getDomProperty("textContent")
                .trim();
    }
}
