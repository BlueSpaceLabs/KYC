package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class UserSelfieResponse extends DigitalOnboardingResponse{

    private String userSelfie;
    private List<ExtractedData> selfieData;

}
