package com.praksa.e2e.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHrmMyInfoPage extends BasePage {

    private static final String PERSONAL_DETAILS_URL_PART =
            "/web/index.php/pim/viewPersonalDetails/empNumber/";

    private static final String CONTACT_DETAILS_URL_PART =
            "/web/index.php/pim/contactDetails/empNumber/";

    private static final By CONTACT_DETAILS_LINK = By.xpath(
            "//a[normalize-space()='Contact Details']"
    );

    private static final By COUNTRY_DROPDOWN = By.xpath(
            "//label[normalize-space()='Country']" +
                    "/ancestor::div[contains(@class,'oxd-input-group')]" +
                    "//div[contains(@class,'oxd-select-text')]"
    );

    private static final By SELECTED_COUNTRY = By.xpath(
            "//label[normalize-space()='Country']" +
                    "/ancestor::div[contains(@class,'oxd-input-group')]" +
                    "//div[contains(@class,'oxd-select-text-input')]"
    );

    private static final By CITY_INPUT = By.xpath(
            "//label[normalize-space()='City']" +
                    "/ancestor::div[contains(@class,'oxd-input-group')]//input"
    );

    private static final By SAVE_BUTTON = By.xpath(
            "//form[.//label[normalize-space()='Country']]" +
                    "//button[@type='submit' and normalize-space()='Save']"
    );

    private static final By SUCCESS_MESSAGE = By.xpath(
            "//*[contains(@class,'oxd-toast')]" +
                    "//*[normalize-space()='Success']"
    );

    @Inject
    public OrangeHrmMyInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPersonalDetailsPageOpen() {
        return wait.until(
                ExpectedConditions.urlContains(
                        PERSONAL_DETAILS_URL_PART
                )
        );
    }

    public void clickContactDetailsLink() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        CONTACT_DETAILS_LINK
                )
        ).click();
    }

    public boolean isContactDetailsPageOpen() {
        return wait.until(
                ExpectedConditions.urlContains(
                        CONTACT_DETAILS_URL_PART
                )
        );
    }

    public void selectCountry(String country) {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        COUNTRY_DROPDOWN
                )
        ).click();

        By countryOption = By.xpath(
                "//div[@role='option']" +
                        "//span[normalize-space()='" + country + "']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(countryOption)
        ).click();
    }

    public void enterCity(String city) {
        WebElement cityInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        CITY_INPUT
                )
        );

        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void clickSaveButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        SAVE_BUTTON
                )
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        SUCCESS_MESSAGE
                )
        );
    }

    public String getSelectedCountry() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        SELECTED_COUNTRY
                )
        ).getText().trim();
    }

    public String getCityValue() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        CITY_INPUT
                )
        ).getDomProperty("value");
    }
}