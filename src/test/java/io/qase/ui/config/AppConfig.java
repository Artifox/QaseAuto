package io.qase.ui.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties",
})
public interface AppConfig extends Config {

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();


    @Key("browserSize")
    String getBrowserSize();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("remoteDriverUrl")
    String getRemoteDriverUrl();
}
