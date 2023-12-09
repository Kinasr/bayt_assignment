package ui_component.model;

import helper.H;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true, fluent = true)
public class ApplicantInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobile;
    private String cvLocation;
    private LocalDate birthDate;
    private Gender gender;
    private String nationality;
    private String visaStatus;
    private Boolean hasExperience;
    private String degree;
    private String university;
    private String eductionCountry;
    private String eductionCity;
    private String fieldOfStudy;
    private String graduationMonth;
    private Integer graduationYear;
    private String jobTitle;
    private String jobLevel;

    public String email() {
        if (email.contains("{timestamp}"))
            email = email.replace("{timestamp}", H.timestamp());

        return email;
    }
}
