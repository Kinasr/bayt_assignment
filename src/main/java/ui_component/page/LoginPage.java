package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class LoginPage {

    // region Locators
    private final By inputEmail = By.id("LoginForm_username");
    private final By inputPassword = By.id("LoginForm_password");
    private final By buttonLogin = By.id("login-button");
    // endregion

    public LoginPage enterEmail(String email) {
        GUI.element(inputEmail)
                .type(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        GUI.element(inputPassword)
                .type(password);
        return this;
    }

    public DashboardPage clickLogin() {
        GUI.browser().screenshot();
        GUI.element(buttonLogin)
                .click();
        return new DashboardPage();
    }
}
