package org.techdisqus.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.techdisqus.request.Document;

import java.util.List;
import java.util.Map;

@Data
@SuperBuilder
public class UploadDocumentsResponse extends DigitalOnboardingResponse {

    private List<Document> documents;
    private Map<String,String> images;
}
