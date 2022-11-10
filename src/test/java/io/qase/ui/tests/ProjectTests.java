package io.qase.ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class ProjectTests extends TestBase {

    @Test
    @DisplayName("User creates a new project in TMS")
    void createProjectTest() {
        step("Open 'https://app.qase.io'", () -> {
            loginPage.open();
        });
        step("Login to app", () -> {
            loginPage.login();
            projectListPage.isProjectPageOpened();
        });
        step("Create a new project", () -> {
            projectListPage.clickOnCreateNewProjectButton();
            projectListPage.fillCreateNewProjectForm(testData.projectName, testData.projectCode);
            projectListPage.pressSubmitButton();
        });
        step("Project should be created", () -> {
            projectPage.isRepositoryCodeVisible(testData.projectCode);
        });
    }
}