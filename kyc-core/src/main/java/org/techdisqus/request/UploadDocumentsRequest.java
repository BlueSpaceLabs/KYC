package org.techdisqus.request;

import lombok.Data;

import java.util.List;

@Data
public class UploadDocumentsRequest extends DigitalOnboardingRequest{

    private List<Document> documents;
}
