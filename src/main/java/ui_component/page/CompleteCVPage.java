package ui_component.page;

import action.gui.GUI;
import helper.H;
import org.openqa.selenium.By;
import ui_component.model.Gender;
import utility.ToByFunction;

import java.time.LocalDate;

public class CompleteCVPage {

    // region Locators
    private final By selectorBirthDay = By.id("personalInformationForm_birthDay__r");
    private final By selectorBirthMonth = By.id("personalInformationForm_birthMonth__r");
    private final By selectorBirthYear = By.id("personalInformationForm_birthYear__r");
    private final By radioButtonMale = By.cssSelector("[for='personalInformationForm_gender_0']");
    private final By radioButtonFemale = By.cssSelector("[for='personalInformationForm_gender_1']");
    private final By selectorNationality = By.id("personalInformationForm_nationalityCitizenAc__r");
    private final By selectorVisaStatus = By.id("personalInformationForm_visaStatus__r");
    private final By radioButtonExperienceNo = By.cssSelector("[for='experienceForm_hasExperience_1']");
    private final By selectorDegree = By.id("EducationForm_degree__r");
    private final By inputUniversity = By.id("EducationForm_institution");
    private final By selectorEducationCountry = By.id("EducationForm_educationCountry__r");
    private final By selectorEducationCity = By.id("EducationForm_educationCity__r");
    private final By inputFieldOfStudy = By.id("EducationForm_major");
    private final By selectorGraduationMonth = By.id("EducationForm_completionMonth__r");
    private final By selectorGraduationYear = By.id("EducationForm_completionYear__r");
    private final By inputJobTitle = By.id("targetJobForm_positionSought");
    private final By selectorJobLever = By.id("targetJobForm_careerLevel__r");
    private final By buttonSave = By.name("submit");
    private final By inputSelectorSearch = By.cssSelector("div.is-active .list-menu-title input");
    private final ToByFunction optionSelector = locator ->
            By.cssSelector("div.is-active .list-menu-group [data-text='" + locator + "']");
    private final ToByFunction optionInput = university -> By.cssSelector("[data-text='" + university + "']");
    // endregion

    public CompleteCVPage selectBirthDate(LocalDate date) {
        GUI.element(selectorBirthDay).click();
        GUI.element(optionSelector.toBy(String.valueOf(date.getDayOfMonth())))
                .scrollTo()
                .click();

        GUI.element(selectorBirthMonth).click();
        GUI.element(optionSelector.toBy(H.capitalizeFirstLetter(date.getMonth().name())))
                .scrollTo()
                .click();

        GUI.element(selectorBirthYear).click();
        GUI.element(optionSelector.toBy(String.valueOf(date.getYear())))
                .scrollTo()
                .click();

        return this;
    }

    public CompleteCVPage selectGender(Gender gender) {
        if (gender == Gender.MALE)
            GUI.element(radioButtonMale).click();
        else
            GUI.element(radioButtonFemale).click();

        return this;
    }

    public CompleteCVPage selectNationality(String nationality) {
        GUI.element(selectorNationality).click();
        GUI.element(inputSelectorSearch).type(nationality);
        GUI.element(optionSelector.toBy(nationality))
                .scrollTo()
                .click();

        return this;
    }

    public CompleteCVPage selectVisaStatus(String visaStatus) {
        GUI.element(selectorVisaStatus).click();
        GUI.element(optionSelector.toBy(visaStatus))
                .scrollTo()
                .click();

        return this;
    }

    public CompleteCVPage addExperience(boolean hasExperience) {
        if (!hasExperience)
            GUI.element(radioButtonExperienceNo).click();

        return this;
    }

    public CompleteCVPage selectDegree(String degree) {
        GUI.element(selectorEducationCity).scrollTo();
        GUI.element(selectorDegree).click();
        GUI.element(optionSelector.toBy(degree))
                .scrollTo()
                .click();

        return this;
    }

    public CompleteCVPage enterUniversity(String university) {
        GUI.element(inputUniversity)
                .scrollTo()
                .type(university);
        GUI.element(optionInput.toBy(university))
                .click();
        return this;
    }

    public CompleteCVPage selectEducationCountry(String country) {
        GUI.element(selectorEducationCountry).scrollTo().click();
        GUI.element(inputSelectorSearch).type(country);
        GUI.element(optionSelector.toBy(country))
                .scrollTo()
                .click();
        return this;
    }

    public CompleteCVPage selectEducationCity(String city) {
        GUI.element(selectorEducationCity).scrollTo().click();
        GUI.element(inputSelectorSearch).scrollTo().type(city);
        GUI.element(optionSelector.toBy(city))
                .scrollTo()
                .click();
        return this;
    }

    public CompleteCVPage enterFieldOfStudy(String fieldOfStudy) {
        GUI.element(inputFieldOfStudy)
                .scrollTo()
                .type(fieldOfStudy);
        GUI.element(optionInput.toBy(fieldOfStudy))
                .scrollTo()
                .click();
        return this;
    }

    public CompleteCVPage selectGraduationMonth(String month) {
        GUI.element(selectorGraduationMonth).scrollTo().click();
        GUI.element(inputSelectorSearch).type(month);
        GUI.element(optionSelector.toBy(month))
                .scrollTo()
                .click();
        return this;
    }

    public CompleteCVPage selectGraduationYear(int year) {
        var yearStr = String.valueOf(year);
        GUI.element(selectorGraduationYear).scrollTo().click();
        GUI.element(inputSelectorSearch).type(yearStr);
        GUI.element(optionSelector.toBy(yearStr))
                .scrollTo()
                .click();
        return this;
    }

    public CompleteCVPage enterJobTitle(String jobTitle) {
        GUI.element(inputJobTitle)
                .scrollTo()
                .type(jobTitle);
        GUI.element(optionInput.toBy(jobTitle))
                .scrollTo()
                .click();
        return this;
    }

    public CompleteCVPage selectJobLever(String jobLever) {
        GUI.element(selectorJobLever).scrollTo().click();
        GUI.element(inputSelectorSearch).type(jobLever);
        GUI.element(optionSelector.toBy(jobLever))
                .scrollTo()
                .click();
        return this;
    }

    public VisaStatusPage save() {
        GUI.browser().screenshot();
        GUI.element(buttonSave)
                .scrollTo()
                .click();
        return new VisaStatusPage();
    }
}
