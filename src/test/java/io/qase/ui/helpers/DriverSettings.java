package io.qase.ui.helpers;

import com.codeborne.selenide.Configuration;
import io.qase.ui.config.AppConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.qase.ui.tests.TestBase.credConfig;

public class DriverSettings {
    public static AppConfig appConfig = ConfigFactory.create(AppConfig.class);

    public static void configure() {
        Configuration.browser = appConfig.getBrowser();
        Configuration.browserVersion = appConfig.getBrowserVersion();
        Configuration.browserSize = appConfig.getBrowserSize();
        Configuration.baseUrl = appConfig.getBaseUrl();

        System.out.println(appConfig.getBrowser());
        System.out.println(appConfig.getBrowserVersion());
        System.out.println(appConfig.getBrowserSize());
        System.out.println(appConfig.getBaseUrl());
        System.out.println(appConfig.getRemoteDriverUrl());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub/",
                    credConfig.getSelenoidUsername(), credConfig.getSelenoidPassword(), appConfig.getRemoteDriverUrl());
        }


        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }

    public static boolean isRemoteWebDriver() {
        return !appConfig.getRemoteDriverUrl().equals("");
    }
}
