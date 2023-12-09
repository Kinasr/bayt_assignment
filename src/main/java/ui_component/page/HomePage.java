package ui_component.page;

import action.gui.GUI;
import action.gui.utility.GUIWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import static assertion.Assertion.assertThat;

public class HomePage {

    // region Locators
    private final By linkAboutUs = By.linkText("About Us");
    private final By linkLogin = By.linkText("Log In");
    // endregion

    public AboutUsPage clickAboutUs() {
        var elementAction = GUI.element(linkAboutUs)
                .scrollTo();
        GUI.browser().screenshot();
        GUIWait.waitFor(ignore -> {
            try {
                elementAction.click();
                return true;
            } catch (ElementClickInterceptedException e) {
                return false;
            }
        });

        return new AboutUsPage();
    }

    public LoginPage clickLogin() {
        GUI.browser().screenshot();
        GUI.element(linkLogin)
                .click();
        return new LoginPage();
    }

    public void assertThatLoginButtonIsDisplayed() {
        assertThat(linkLogin).isDisplayed()
                .perform();
    }
}
