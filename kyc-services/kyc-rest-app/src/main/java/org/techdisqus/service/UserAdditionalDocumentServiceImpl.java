package org.techdisqus.service;


import com.innovatrics.dot.integrationsamples.disapi.ApiException;
import com.innovatrics.dot.integrationsamples.disapi.model.CustomerOnboardingApi;
import com.innovatrics.dot.integrationsamples.disapi.model.ImageCrop;
import org.techdisqus.request.UploadDocumentsRequest;
import org.techdisqus.response.UploadDocumentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UserAdditionalDocumentServiceImpl extends KycBaseService implements UserAdditionalDocumentService {


	@Autowired
	private CustomerOnboardingApi customerOnboardingApi;


	@Override
	public UploadDocumentsResponse uploadDocs(UploadDocumentsRequest request) {


		UploadDocumentsResponse uploadDocumentsResponse = UploadDocumentsResponse.builder().build();
        try {
			ImageCrop frontPage = customerOnboardingApi.documentPageCrop(request.getCustomerId(), "front", null, null);

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }


		return uploadDocumentsResponse;
	}

}
