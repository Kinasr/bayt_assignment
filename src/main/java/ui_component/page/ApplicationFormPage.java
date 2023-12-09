package ui_component.page;

import action.gui.GUI;
import action.gui.utility.GUIWait;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import static assertion.Assertion.assertThat;

public class ApplicationFormPage {

    // region Locators
    private final By inputFirstName = By.id("JsApplicantRegisterForm_firstName");
    private final By inputLastName = By.id("JsApplicantRegisterForm_lastName");
    private final By inputEmail = By.id("JsApplicantRegisterForm_email");
    private final By errorMsgEmail = By.id("JsApplicantRegisterForm_email_em_");
    private final By inputPassword = By.id("JsApplicantRegisterForm_password");
    private final By inputMobile = By.id("JsApplicantRegisterForm_mobPhone");
    private final By buttonApplyNow = By.id("register");
    // endregion

    public ApplicationFormPage enterFirstName(String firstName) {
        GUI.element(inputFirstName)
                .type(firstName);
        return this;
    }

    public ApplicationFormPage enterLastName(String lastName) {
        GUI.element(inputLastName)
                .type(lastName);
        return this;
    }

    public ApplicationFormPage enterEmail(String email) {
        GUI.element(inputEmail)
                .type(email);
        return this;
    }

    public ApplicationFormPage enterPassword(String password) {
        GUI.element(inputPassword)
                .type(password);
        return this;
    }

    public ApplicationFormPage enterMobile(String mobile) {
        GUI.element(inputMobile)
                .type(mobile);
        return this;
    }

    public AttachCVPage clickOnApplyNow() {
        GUI.element(buttonApplyNow)
                .click();
        return new AttachCVPage();
    }

    public void assertThatErrorEmailIsDisplayed() {
        GUIWait.waitFor(ignore -> {
            try {
                assertThat(errorMsgEmail).isDisplayed()
                        .perform();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
    }
}
