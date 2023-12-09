package ui_component.page;

import action.gui.GUI;
import org.openqa.selenium.By;

import static assertion.Assertion.assertThat;

public class DashboardPage {

    // region Locators
    private final By linkDashboard = By.linkText("Dashboard");
    private final By linkMenu = By.xpath("//li[@data-popover='{\"trigger\":\"click\"}']//a[@href='#']");
    private final By linkAccountSettings = By.linkText("Account Settings");
    // endregion

    public void assertThatDashboardButtonIsDisplayed() {
        assertThat(linkDashboard).isDisplayed()
                .perform();
    }

    public DashboardPage clickMenu() {
        GUI.element(linkMenu)
                .click();
        return this;
    }

    public MyAccountPage clickAccountSettings() {
        GUI.browser().screenshot();
        GUI.element(linkAccountSettings)
                .click();
        return new MyAccountPage();
    }
}
