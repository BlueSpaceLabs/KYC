package org.techdisqus.request;

import lombok.Data;

@Data
public class UserSelfieRequest extends DigitalOnboardingRequest{

    private String image;
}
