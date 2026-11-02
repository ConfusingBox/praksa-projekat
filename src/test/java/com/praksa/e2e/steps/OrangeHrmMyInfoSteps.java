package com.praksa.e2e.steps;

import com.google.inject.Inject;
import com.praksa.e2e.pages.OrangeHrmDashboard;
import com.praksa.e2e.pages.OrangeHrmMyInfoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrangeHrmMyInfoSteps
{

    private final OrangeHrmDashboard orangeHrmDashboard;
    private final OrangeHrmMyInfoPage orangeHrmMyInfoPage;

    @Inject
    public OrangeHrmMyInfoSteps(OrangeHrmDashboard orangeHrmDashboard, OrangeHrmMyInfoPage orangeHrmMyInfoPage) {
        this.orangeHrmDashboard = orangeHrmDashboard;
        this.orangeHrmMyInfoPage = orangeHrmMyInfoPage;
    }


    @When("I click the My Info menu link")
    public void iClickTheMyInfoMenuLink(){
        orangeHrmDashboard.clickMyInfoMenuLink();
    }

    @Then("the View Personal Details page should be opened")
    public void theViewPersonalDetailsPageShouldBeOpened(){
        Assert.assertTrue(
                orangeHrmMyInfoPage.isPersonalDetailsPageOpen());

    }

    @When("I click the Contact Details submenu link")
    public void iClickTheContactDetailsSubmenuLink(){
        orangeHrmMyInfoPage.clickContactDetailsLink();
    }

    @Then("the Contact Details page should be opened")
    public void theContactDetailsPageShouldBeOpened(){
        Assert.assertTrue(
                orangeHrmMyInfoPage.isContactDetailsPageOpen()
        );
    }

    @When("I change my Country to {string}")
    public void iChangeMyCountryTo(String country){
        orangeHrmMyInfoPage.selectCountry(country);
    }

    @When("I change my City to {string}")
    public void iChangeMyCityTo(String city){
        orangeHrmMyInfoPage.enterCity(city);
    }

    @When("I click the Save button")
    public void iClickTheSaveButton(){
        orangeHrmMyInfoPage.clickSaveButton();
    }

    @Then("my country should be {string}")
    public void myCountryShouldBe(String expectedCountry){
        Assert.assertEquals(
                orangeHrmMyInfoPage.getSelectedCountry(),
                expectedCountry
        );
    }

    @Then("my city should be {string}")
    public void myCityShouldBe(String expectedCity) {
        Assert.assertEquals(
                orangeHrmMyInfoPage.getCityValue(),
                expectedCity
        );
    }

}
