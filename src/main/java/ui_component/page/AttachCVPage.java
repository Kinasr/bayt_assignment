package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

public class AttachCVPage {

    // region Locators
    private final By inputUploadCV = By.id("uploadCvForm_uploadCv");
    private final By buttonSkip = By.id("skip-btn");
    private final By buttonNext = By.name("submit");
    // endregion

    public AttachCVPage uploadCV(String cvFilePath) {
        GUI.element(inputUploadCV)
                .upload(cvFilePath);
        return this;
    }

    public CompleteCVPage skip() {
        GUI.element(buttonSkip)
                .click();
        return new CompleteCVPage();
    }

    public CompleteCVPage next() {
        GUI.browser().screenshot();
        GUI.element(buttonNext)
                .click();
        return new CompleteCVPage();
    }
}
