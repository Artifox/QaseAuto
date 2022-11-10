package io.qase.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectListPage {

    SelenideElement projectPageLabel = $(".container-fluid").$(byText("Projects"));
    SelenideElement createNewProjectButton = $("#createButton");
    SelenideElement projectNameField = $("#project-name");
    SelenideElement projectCodeField = $("#project-code");
    SelenideElement submitButton = $("button[type='submit']");

    @Step("Projects page has opened")
    public void isProjectPageOpened() {
       projectPageLabel.shouldBe(Condition.visible);
    }

    @Step("Click on 'Create new project' button")
    public void clickOnCreateNewProjectButton() {
        createNewProjectButton.click();
    }

    @Step("Fill in 'Create new project' form")
    public void fillCreateNewProjectForm(String projectName, String projectCode) {
        projectNameField.sendKeys(projectName);
        projectCodeField.sendKeys(projectCode);
    }

    @Step("Press 'Submit' button")
    public void pressSubmitButton(){
        submitButton.click();
    }
}
