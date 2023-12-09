package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class BaytJobDescriptionPage {

    // region Locators
    private final By buttonApply = By.id("applyButton");
    // endregion

    public ApplicationFormPage clickOnApply() {
        GUI.browser().screenshot();
        GUI.element(buttonApply)
                .click();

        return new ApplicationFormPage();
    }
}
