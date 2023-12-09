package ui_component.page;

import action.gui.GUI;
import action.gui.utility.GUIWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

public class MyAccountPage {

    // region Locators
    private final By linkDeleteMyAccount = By.linkText("Delete My Account");
    // endregion

    public DeleteAccountConfirmationPage clickDeleteMyAccount() {
        var elementAction = GUI.element(linkDeleteMyAccount)
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
        return new DeleteAccountConfirmationPage();
    }
}
