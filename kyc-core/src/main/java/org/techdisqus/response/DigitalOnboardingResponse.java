package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class DigitalOnboardingResponse extends AbstractResponse{

    private String customerId;
    private String externalId;
    private List<ExtractedData> documentExtractedDataList;
    private List<ExtractedData> selfieExtractedDataList;
    private UserOnboardingDetails userOnboardingDetails;
}
