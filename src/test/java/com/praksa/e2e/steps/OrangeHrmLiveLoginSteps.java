package com.praksa.e2e.steps;

import com.google.inject.Inject;
import com.praksa.e2e.pages.OrangeHrmDashboard;
import com.praksa.e2e.pages.OrangeHrmLiveLogin;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrangeHrmLiveLoginSteps {


    private final OrangeHrmLiveLogin orangeHrmLiveLogin;
    private final OrangeHrmDashboard orangeHrmDashboard;

    @Inject
    public OrangeHrmLiveLoginSteps(OrangeHrmLiveLogin orangeHrmLiveLogin, OrangeHrmDashboard orangeHrmDashboard) {
        this.orangeHrmLiveLogin = orangeHrmLiveLogin;
        this.orangeHrmDashboard = orangeHrmDashboard;
    }

    @Given("I open the Orange HRM Live Login")
    public void iOpenOrangeHrmLiveLogin(){
        orangeHrmLiveLogin.open();
    }

    @Then("the username input should be visible")
    public void  theUsernameInputShouldBeVisible(){
        Assert.assertTrue(
                orangeHrmLiveLogin.isUsernameInputVisible(),
                "Expected Username input to be visible"
        );
    }

    @Then("the password input should be visible")
    public void thePasswordInputShouldBeVisible() {
        Assert.assertTrue(
                orangeHrmLiveLogin.isPasswordInputVisible(),
                "Expected Password input to be visible"
        );
    }

    @Then("the login button should be visible")
    public void theLoginButtonShouldBeVisible(){
        Assert.assertTrue(
                orangeHrmLiveLogin.isLoginButtonVisible(),
                "Expected Login Button to be visible"
        );
    }

    @Given("I enter valid Orange HRM Credentials")
    public void iEnterValidOrangeHrmCredentials(){
        orangeHrmLiveLogin.enterUsername();
        orangeHrmLiveLogin.enterPassword();
    }

    @Then("valid Orange HRM credentials should be entered")
    public void validOrangeHrmCredentialsShouldBeEntered(){
        Assert.assertEquals(orangeHrmLiveLogin.getUsernameValue(),
                "Admin",
                "Expected username to be admin");

        Assert.assertEquals(orangeHrmLiveLogin.getPasswordValue(),
                "admin123",
                "Expected password to be admin123");
    }

    @When("I click the Login button")
    public void iClickTheLoginButton(){
        orangeHrmLiveLogin.clickLoginButton();
    }

    @Then("the Orange HRM Dashboard should be opened")
    public void theOrangeHrmDashboardShouldBeOpened(){
        Assert.assertTrue(orangeHrmDashboard.isDashboardsOpen(),
                "Expected Orange HRM Dashboard to be opened");
    }

}
