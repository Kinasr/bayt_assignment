package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;
import utility.ToByFunction;

public class VisaStatusPage {

    // region Locators
    private final By selectorVisaStatus = By.id("applyToJobForm_visa_status__r");
    private final By buttonApplyName = By.name("submit");
    private final ToByFunction optionSelector = locator ->
            By.cssSelector("div.is-active .list-menu-group [data-text='" + locator + "']");
    // endregion

    public VisaStatusPage selectVisaStatus(String visaStatus) {
        GUI.element(selectorVisaStatus).scrollTo().click();
        GUI.element(optionSelector.toBy(visaStatus))
                .scrollTo()
                .click();
        return this;
    }

    public ApplicationSentPage applyNow() {
        GUI.browser().screenshot();
        GUI.element(buttonApplyName)
                .click();
        return new ApplicationSentPage();
    }
}
