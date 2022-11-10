package io.qase.ui.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credentials.properties"
})
public interface CredentialsConfig extends Config {

    @Key("email")
    String getEmail();

    @Key("password")
    String getPassword();

    @Key("selenoidUsername")
    String getSelenoidUsername();

    @Key("selenoidPassword")
    String getSelenoidPassword();
}
