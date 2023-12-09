package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class ApplicationSentPage {

    // region Locators
    private final By textTitle = By.cssSelector("h1.t-danger");
    // endregion

    public void assertThatApplicationIsSentSuccessfully() {
        GUI.browser().screenshot();
        GUI.element(textTitle)
                .text().assertThat()
                .isContain("Your application has been sent")
                .perform();
    }
}
