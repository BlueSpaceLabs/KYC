package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UserSelfieResponse extends DigitalOnboardingResponse{

    private String userSelfie;

}
