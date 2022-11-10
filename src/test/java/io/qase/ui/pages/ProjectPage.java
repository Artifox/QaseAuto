package io.qase.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    SelenideElement projectPageLabel = $(".container-fluid").$(byText("Projects"));

    @Step("Projects page has opened")
    public void isProjectPageOpened() {
       projectPageLabel.shouldBe(Condition.visible);
    }
}
