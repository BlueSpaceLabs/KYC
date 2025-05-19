package org.techdisqus.request;

import lombok.Data;

@Data
public class DocumentScanRequest extends DigitalOnboardingRequest{

    private String image;
    private String type;

}
