package org.techdisqus.request;

import lombok.Data;

import java.util.List;

@Data
public class RegisterUserRequest extends DigitalOnboardingRequest{

    private List<Consent> consents;

}
