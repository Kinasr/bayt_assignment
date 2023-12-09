package test_package;

import action.gui.GUI;
import kinasr.nsr_yaml.core.YAML;
import org.junit.jupiter.api.*;
import ui_component.model.ApplicantInfo;
import ui_component.page.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BaytTest {
    private static final ApplicantInfo applicantInfo = YAML.read("src/test/resources/data/applicant_info.yaml")
            .get("applicant01").as(ApplicantInfo.class);

    @BeforeEach
    void setUp() {
        GUI.open();
    }

    @AfterEach
    void tearDown() {
        GUI.quit();
    }

    @Order(1)
    @Test
    void applyingForAJobWhileNotLoggedIn() {
        new HomePage()
                .clickAboutUs()
                .clickOnCareers()
                .clickOnFirstJob()
                .clickOnApply()
                .enterFirstName(applicantInfo.firstName())
                .enterLastName(applicantInfo.lastName())
                .enterEmail(applicantInfo.email())
                .enterPassword(applicantInfo.password())
                .enterMobile(applicantInfo.mobile())
                .clickOnApplyNow()
                .skip()
                .selectBirthDate(applicantInfo.birthDate())
                .selectGender(applicantInfo.gender())
                .selectNationality(applicantInfo.nationality())
                .addExperience(applicantInfo.hasExperience())
                .selectDegree(applicantInfo.degree())
                .enterUniversity(applicantInfo.university())
                .selectEducationCountry(applicantInfo.eductionCountry())
                .selectEducationCity(applicantInfo.eductionCity())
                .enterFieldOfStudy(applicantInfo.fieldOfStudy())
                .selectGraduationMonth(applicantInfo.graduationMonth())
                .selectGraduationYear(applicantInfo.graduationYear())
                .save()
                .selectVisaStatus(applicantInfo.visaStatus())
                .applyNow()
                .assertThatApplicationIsSentSuccessfully();
    }

    @Order(2)
    @Test
    void applyingWithARegisteredEmailShouldShowError() {
        var registrationPage = new HomePage()
                .clickAboutUs()
                .clickOnCareers()
                .clickOnFirstJob()
                .clickOnApply()
                .enterFirstName(applicantInfo.firstName())
                .enterLastName(applicantInfo.lastName())
                .enterEmail(applicantInfo.email())
                .enterPassword(applicantInfo.password())
                .enterMobile(applicantInfo.mobile());
        registrationPage.clickOnApplyNow();
        registrationPage.assertThatErrorEmailIsDisplayed();
    }

    @Order(3)
    @Test
    void userCanLoginSuccessfully() {
        new HomePage()
                .clickLogin()
                .enterEmail(applicantInfo.email())
                .enterPassword(applicantInfo.password())
                .clickLogin()
                .assertThatDashboardButtonIsDisplayed();
    }

    @Order(4)
    @Test
    void afterDeletingAccountShouldRedirectToHomePage() {
        new HomePage()
                .clickLogin()
                .enterEmail(applicantInfo.email())
                .enterPassword(applicantInfo.password())
                .clickLogin()
                .clickMenu()
                .clickAccountSettings()
                .clickDeleteMyAccount()
                .clickDelete()
                .confirmDelete()
                .assertThatLoginButtonIsDisplayed();
    }

    @Test
    void applyForAJobUsingMobileView() {
        GUI.browser().setWindowSize(500, 800);

        new HomePage()
                .mEnterJobSearch("Quality Assurance Engineer")
                .mSelectCountry("United Arab Emirates")
                .findJobs()
                .clickFirstJob()
                .applyOnCompanySite()
                .assertThatApplicationFormSubTitleIsCorrect();
    }
}
