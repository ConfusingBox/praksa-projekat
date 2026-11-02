package com.praksa.e2e.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHrmDashboard extends BasePage {

    private static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    private static final By ADMIN_MENU_LINK = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    @Inject
    public OrangeHrmDashboard(WebDriver driver) {
        super(driver);
    }

    private static final By MY_INFO_MENU_LINK = By.xpath(
            "//a[@href='/web/index.php/pim/viewMyDetails']"
    );

    public void clickMyInfoMenuLink() {
        wait.until(
                ExpectedConditions.elementToBeClickable(MY_INFO_MENU_LINK)
        ).click();
    }

    public boolean isDashboardsOpen(){
        return wait.until(ExpectedConditions.urlToBe(DASHBOARD_URL));
    }

    public void clickAdminMenuLink(){
        wait.until(ExpectedConditions.elementToBeClickable(ADMIN_MENU_LINK)).click();
    }

}
