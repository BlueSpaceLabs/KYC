package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.techdisqus.request.Address;

import java.util.List;

@Data
@SuperBuilder
public class UserDetailsResponse extends DigitalOnboardingResponse{

    private UserOnboardingDetails updatedUserOnboardingDetails;
    private List<Address> addresses;

}
