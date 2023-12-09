package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class DeleteAccountConfirmationPage {
    // region Locators
    private final By buttonDelete = By.cssSelector(".btn.is-danger");
    private final By popupButtonDelete = By.cssSelector("[data-js-aid='delete']");
    // endregion

    public DeleteAccountConfirmationPage clickDelete() {
        GUI.browser().screenshot();
        GUI.element(buttonDelete)
                .click();
        return this;
    }

    public HomePage confirmDelete() {
        GUI.browser().screenshot();
        GUI.element(popupButtonDelete)
                .click();
        return new HomePage();
    }
}
