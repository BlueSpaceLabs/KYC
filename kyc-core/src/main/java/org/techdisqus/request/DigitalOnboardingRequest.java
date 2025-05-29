package org.techdisqus.request;

import lombok.Data;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.response.UserOnboardingDetails;

import java.util.List;

@Data
public abstract class DigitalOnboardingRequest extends AbstractRequest {

    private String customerId;
    private String externalId;
    private AccountType selectedAccountType;

    private List<ExtractedData> extractedDataList;
    private List<ExtractedData> updatedValues;
    private List<Address> addresses;
    private UserOnboardingDetails userOnboardingDetails;

}
