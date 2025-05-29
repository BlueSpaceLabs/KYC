package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import org.techdisqus.request.Address;

import java.util.List;

@Builder
@Data
public class UserOnboardingDetails {

    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String documentNo;
    private String documentType;
    private String gender;
    private List<Address> addresses;
}
