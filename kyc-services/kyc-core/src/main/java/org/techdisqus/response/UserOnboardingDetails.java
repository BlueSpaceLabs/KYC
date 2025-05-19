package org.techdisqus.response;

import lombok.Data;

@Data
public class UserOnboardingDetails {

    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String documentNo;
    private String documentType;
    private String gender;
}
