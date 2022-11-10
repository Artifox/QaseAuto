package io.qase.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    SelenideElement repositoryName = $(byText("repository"));

    public void isRepositoryCodeVisible(String repositoryTextName) {
        repositoryName.shouldHave(Condition.text(repositoryTextName));
    }
}