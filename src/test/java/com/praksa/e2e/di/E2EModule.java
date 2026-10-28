package com.praksa.e2e.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.praksa.e2e.pages.GoogleHomePage;
import io.cucumber.guice.ScenarioScoped;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class E2EModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GoogleHomePage.class).in(ScenarioScoped.class);
    }

    @Provides
    @ScenarioScoped
    public WebDriver provideWebdriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        return new ChromeDriver(options);
    }
}
