package com.example.fluentlenium;

import java.io.IOException;
import java.sql.SQLException;

import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.events.annotations.BeforeNavigate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.Dimension;

import com.example.fluentlenium.config.TestConfig;
import com.example.fluentlenium.pages.DashboardPage;
import com.example.fluentlenium.pages.LoginPage;
import com.example.fluentlenium.services.TestDataService;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest extends FluentTest {

    TestConfig config = TestConfig.get();

    @Page
    LoginPage loginPage;

    @Page
    DashboardPage dashboardPage;

    @BeforeAll
    void setUpAllTests() {
        setUpBrowserDriver(getWebDriver());
    }

    @BeforeEach
    void setUpEachTest() throws SQLException, IOException {
        TestDataService.loadInitialData();
        window().setSize(new Dimension(1600, 900));
        // window().maximize();
        logIn();
    }

    @AfterEach
    void tearDownEachTest(TestInfo info) {
        String fileName = info.getTestMethod().get().getName() + ".png";
        takeScreenshot(fileName);
        // Attach file to Jenkins test report through JUnit Attachments plugin
        System.out.format("[[ATTACHMENT|%s]]", getScreenshotPath() + fileName);
    }

    @BeforeNavigate
    void beforeNavigateTo(String url) {
        log.info("Navigate to <{}>", url);
    }

    void setUpBrowserDriver(String browser) {
        if (browser == "chrome") {
            WebDriverManager.chromedriver().setup();
        } else if (browser == "firefox") {
            WebDriverManager.firefoxdriver().setup();
        }
    }

    void logIn() {
        goTo(loginPage);
        loginPage.isAt();
        loginPage.logIn(config.appUser(), config.appPassword());
        dashboardPage.isAt();
    }
}
