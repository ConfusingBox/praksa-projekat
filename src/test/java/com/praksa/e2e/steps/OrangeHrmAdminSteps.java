package com.praksa.e2e.steps;

import com.google.inject.Inject;
import com.praksa.e2e.pages.OrangeHrmAdminPage;
import com.praksa.e2e.pages.OrangeHrmDashboard;
import com.praksa.e2e.pages.OrangeHrmLiveLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrangeHrmAdminSteps {

    private final OrangeHrmDashboard orangeHrmDashboard;
    private final OrangeHrmAdminPage orangeHrmAdminPage;
    private final OrangeHrmLiveLogin orangeHrmLiveLogin;

    @Inject
    public OrangeHrmAdminSteps(OrangeHrmDashboard orangeHrmDashboard, OrangeHrmAdminPage orangeHrmAdminPage, OrangeHrmLiveLogin orangeHrmLiveLogin) {
        this.orangeHrmDashboard = orangeHrmDashboard;
        this.orangeHrmAdminPage = orangeHrmAdminPage;
        this.orangeHrmLiveLogin = orangeHrmLiveLogin;
    }

    @Given("I am logged in to Orange HRM")
    public void iAmLoggedInToOrangeHrm(){
        orangeHrmLiveLogin.open();
        orangeHrmLiveLogin.enterUsername();
        orangeHrmLiveLogin.enterPassword();
        orangeHrmLiveLogin.clickLoginButton();

        Assert.assertTrue(orangeHrmDashboard.isDashboardsOpen(),"Expected Dashboard to be opened after login");
    }

    @When("I click the Admin menu link")
    public void iClickTheAdminMenuLink(){
        orangeHrmDashboard.clickAdminMenuLink();
    }

    @Then("the Orange HRM Admin page should be opened")
    public void theOrangeHrmAdminPageShouldBeOpened(){
        Assert.assertTrue(orangeHrmAdminPage.isAdminPageOpen(),"Expected Orange HRM Admin page to be opened");
    }

    @When("I enter the Admin username")
    public void iEnterTheAdminUsername(){
        orangeHrmAdminPage.enterUsername();
    }

    @When("I click the Admin Search button")
    public void iClickTheAdminSearchButton(){
        orangeHrmAdminPage.clickSearchButton();
    }

    @Then("the searched username should be displayed")
    public void theSearchedUsernameShouldBeDisplayed() {
        Assert.assertEquals(
                orangeHrmAdminPage.getSearchedUsername(),
                "Admin",
                "Expected username Admin to be displayed in search results"
        );
    }

}
