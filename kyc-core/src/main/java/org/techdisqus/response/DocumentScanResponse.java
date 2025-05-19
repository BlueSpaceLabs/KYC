package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class DocumentScanResponse extends DigitalOnboardingResponse{

    private String image;
    private List<ExtractedData> extractedDataList;
    private UserOnboardingDetails userOnboardingDetails;

}
