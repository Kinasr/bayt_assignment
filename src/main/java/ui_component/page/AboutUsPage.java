package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class AboutUsPage {

    // region Locators
    private final By linkCareers = By.linkText("Careers");
    // endregion

    public BaytCompanyPage clickOnCareers() {
        GUI.browser().screenshot();

        GUI.element(linkCareers)
                .click();
        return new BaytCompanyPage();
    }
}
