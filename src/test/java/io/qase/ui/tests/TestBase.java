package io.qase.ui.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.qase.ui.config.CredentialsConfig;
import io.qase.ui.helpers.Attach;
import io.qase.ui.helpers.DriverSettings;
import io.qase.ui.pages.LoginPage;
import io.qase.ui.pages.ProjectPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;


@ExtendWith({AllureJunit5.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {

    public static CredentialsConfig credConfig = ConfigFactory.create(CredentialsConfig.class);

    protected LoginPage loginPage;
    protected ProjectPage projectPage;

    @BeforeAll
    void setUp() {
        DriverSettings.configure();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
    }

    @BeforeEach
    public void setAllureSelenideListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
