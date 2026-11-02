package com.praksa.e2e.pages;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@ScenarioScoped
public class GoogleHomePage extends BasePage {

    private static final String URL = "https://www.google.com/?hl=en";

    private static final By COOKIE_ACCEPT = By.xpath(
            "//button[normalize-space()='Accept all' or normalize-space()='I agree' or .//div[normalize-space()='Accept all']]"
    );
    private static final By AI_MODE_BUTTON = By.xpath(
            "//*[self::a or self::button or @role='button' or @role='link']"
                    + "[contains(translate(normalize-space(.), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'AI MODE')]"
                    + " | //*[@aria-label[contains(translate(., 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'AI MODE')]]"
    );

    private static final By GOOGLE_SEARCH_BUTTON = By.xpath("/html/body/div[2]/div[6]/form/div[1]/div/div[4]/center/input[1]");

    @Inject
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleHomePage open() {
        open(URL);
        dismissCookieBannerIfPresent();
        return this;
    }

    public boolean isAiModeButtonVisible() {
        return isAnyDisplayed(AI_MODE_BUTTON);
    }

    private void dismissCookieBannerIfPresent() {
        List<WebElement> acceptButtons = findAll(COOKIE_ACCEPT);
        if (!acceptButtons.isEmpty()) {
            acceptButtons.get(0).click();
        }
    }

    public boolean isGoogleSearchButtonVisible(){
        return isAnyDisplayed(AI_MODE_BUTTON);
    }
}
