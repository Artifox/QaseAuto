package io.qase.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.qase.ui.tests.TestBase.credConfig;

public class LoginPage {

    SelenideElement email = $("#inputEmail");
    SelenideElement password = $("#inputPassword");
    SelenideElement loginButton = $("#btnLogin");

    @Step("Opening 'Login' page")
    public LoginPage open() {
        Selenide.open("/login");
        return this;
    }

    @Step("Login to Qase")
    public void login() {
        email.sendKeys(credConfig.getEmail());
        password.sendKeys(credConfig.getPassword());
        loginButton.click();
    }
}
