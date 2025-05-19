package org.techdisqus.request;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailsRequest extends AbstractRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private List<Address> addresses;

}
