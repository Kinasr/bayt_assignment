package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class JobDescriptionPage {

    // region Locators
    private final By buttonApply = By.xpath("//div[@id='view_inner'] //a[@class='btn  is-small  u-expanded-m m' and contains(., 'Apply on company site')]");
    // endregion

    public ApplicationFormPage applyOnCompanySite() {
        GUI.browser().screenshot();
        GUI.element(buttonApply)
                .click();
        return new ApplicationFormPage();
    }
}
