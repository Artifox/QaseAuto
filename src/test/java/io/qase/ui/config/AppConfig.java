package io.qase.ui.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/${env}.properties"
})
public interface AppConfig extends Config {

    @DefaultValue("chrome")
    @Key("browser")
    String getBrowser();

    @DefaultValue("91.0")
    @Key("browserVersion")
    String getBrowserVersion();

    @DefaultValue("1920x1080")
    @Key("browserSize")
    String getBrowserSize();

    //@DefaultValue("https://app.qase.io/")
    @Key("baseUrl")
    String getBaseUrl();

    @Key("remoteUrl")
    String getRemoteUrl();
}
