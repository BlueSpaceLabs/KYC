package org.techdisqus.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class RegisterUserResponse extends AbstractResponse{

    private String referenceId;
    private String status;
    private List<String> rejectReasons;
    private String simRegistrationDate;
    private String statusMessage;

}
