package ui_component.page;

import action.gui.GUI;
import action.gui.utility.GUIWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import utility.ToByFunction;

import static assertion.Assertion.assertThat;

public class HomePage {

    // region Locators
    private final By linkLogin = By.linkText("Log In");
    private final By inputSearch = By.id("text_search");
    private final By selectorSearchCountry = By.id("search_country__r");
    private final By buttonFindJobs = By.cssSelector("[data-js-aid='search']");
    private final By linkFirstJob = By.cssSelector("[data-js-job]:nth-child(2)");
    private final By linkAboutUs = By.linkText("About Us");
    private final By inputSelectorSearch = By.cssSelector("div.is-active .list-menu-title input");
    private final ToByFunction optionSelector = locator ->
            By.cssSelector("div.is-active .list-menu-group [data-text='" + locator + "']");
    private final ToByFunction optionInput = university -> By.cssSelector("[data-text='" + university + "']");
    // endregion

    public AboutUsPage clickAboutUs() {
        var elementAction = GUI.element(linkAboutUs)
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

        return new AboutUsPage();
    }

    public LoginPage clickLogin() {
        GUI.browser().screenshot();
        GUI.element(linkLogin)
                .click();
        return new LoginPage();
    }

    public HomePage mEnterJobSearch(String jobSearch) {
        GUI.element(inputSearch).click();
        GUI.element(inputSelectorSearch).type(jobSearch);
        GUI.element(optionInput.toBy(jobSearch.toLowerCase())).click();

        return this;
    }

    public HomePage mSelectCountry(String country) {
        GUI.element(selectorSearchCountry).click();
        GUI.element(inputSelectorSearch).type(country);
        GUI.element(optionSelector.toBy(country)).click();

        return this;
    }

    public HomePage findJobs() {
        GUI.browser().screenshot();
        GUI.element(buttonFindJobs)
                .click();
        return this;
    }

    public JobDescriptionPage clickFirstJob() {
        GUI.browser().screenshot();
        GUI.element(linkFirstJob)
                .scrollTo()
                .click();
        return new JobDescriptionPage();
    }


    public void assertThatLoginButtonIsDisplayed() {
        assertThat(linkLogin).isDisplayed()
                .perform();
    }
}
