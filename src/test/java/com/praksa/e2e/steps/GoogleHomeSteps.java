package com.praksa.e2e.steps;

import com.google.inject.Inject;
import com.praksa.e2e.pages.GoogleHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class GoogleHomeSteps {

    private final GoogleHomePage googleHomePage;

    @Inject
    public GoogleHomeSteps(GoogleHomePage googleHomePage) {
        this.googleHomePage = googleHomePage;
    }

    @Given("I open the Google home page")
    public void iOpenTheGoogleHomePage() {
        googleHomePage.open();
    }

    @Then("the AI Mode button should be visible")
    public void theAiModeButtonShouldBeVisible() {
        Assert.assertTrue(
                googleHomePage.isAiModeButtonVisible(),
                "Expected Google home page to contain a visible AI Mode button"
        );
    }

    @Then("the Google Search button should be visible")
    public void theGoogleSearchButtonShouldBeVisible(){
        int i =2;
        Assert.assertTrue(
                googleHomePage.isGoogleSearchButtonVisible(),
                "Expected Google home page to contain a visible Google Search button"
        );
//        Assert.assertTrue(
//                true,
//                "TEst123"
//        );

    }
}
