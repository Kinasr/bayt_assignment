package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class BaytCompanyPage {

    // region Locators
    private final By linkFirstJob = By.cssSelector(".is-4-d.is-12-m:first-child a[data-js-aid='jobTitle']");
    // endregion

    public BaytJobDescriptionPage clickOnFirstJob() {
        var guiBrowser = GUI.browser();
        guiBrowser.screenshot();
        var currentTabs = guiBrowser.getCurrentTabs();

        GUI.element(linkFirstJob)
                .click();

        guiBrowser.focusOnNewTab(currentTabs);
        return new BaytJobDescriptionPage();
    }
}
