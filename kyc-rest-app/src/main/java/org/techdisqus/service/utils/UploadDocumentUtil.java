
package org.techdisqus.service.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.techdisqus.request.Document;
import org.techdisqus.service.KycBaseService;

@Component
public class UploadDocumentUtil extends KycBaseService {

    @Getter
    private static Logger logger = LoggerFactory.getLogger(UploadDocumentUtil.class);


    public List<org.techdisqus.request.Document> uploadDocuments(String msisdn, String referenceId, String externalId, List<org.techdisqus.request.Document> additionalDocuments,
                                                                 List<org.techdisqus.request.Document> idDocs, String userToken, String customerId, Map<String, String> opaqueData) {


        logger.info("upload additional docs started");
        List<org.techdisqus.request.Document> allDocuments = new ArrayList<>(idDocs);
        allDocuments.addAll(additionalDocuments);

        List<org.techdisqus.request.Document> uploadedDocuments = new ArrayList<>(allDocuments.size());
        logger.info("upload additional docs ended");

        return uploadedDocuments;
    }


}

