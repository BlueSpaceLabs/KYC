package org.techdisqus.service;


import com.innovatrics.dot.integrationsamples.disapi.model.CustomerOnboardingApi;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.techdisqus.exception.ApiExecutionException;
import org.techdisqus.request.Document;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.UploadDocumentsRequest;
import org.techdisqus.response.UploadDocumentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@Primary
public class UserAdditionalDocumentServiceImpl extends KycBaseService implements UserAdditionalDocumentService {


	@Autowired
	private CustomerOnboardingApi customerOnboardingApi;


	@SneakyThrows
    @Override
	public UploadDocumentsResponse uploadDocs(UploadDocumentsRequest request, KycRequestHeaders kycRequestHeaders) {


		log.info("upload additional docs started");
		UploadDocumentsResponse uploadDocumentsResponse = UploadDocumentsResponse.builder().documents(request.getDocuments()).build();
		Map<String,String> map = request.getRequestInformation();

		uploadDocumentsResponse.setUserData(map);

		if(CollectionUtils.isEmpty(request.getDocuments())
		||request.getDocuments().size() != 2) {
			uploadDocumentsResponse.setErrorCode("ADDL-DOC-001");
			uploadDocumentsResponse.setErrorDetails("Additional documents are missing");
		}


		StringBuilder sb = new StringBuilder();

		request.getDocuments().forEach(doc -> {
            try {

				Path tempFile = Files.createTempFile( map.get("msisdn") +"___"+ doc.getName() + "___" + doc.getType() + UUID.randomUUID(), ".txt");
                Files.write(tempFile, doc.getImage().getBytes(), StandardOpenOption.WRITE);
				sb.append(tempFile.toAbsolutePath()).append(",");
            } catch (IOException e) {
                throw new ApiExecutionException(e, request);
            }
        });

		String fileNames = request.getDocuments().stream().map(Document::getName).collect(Collectors.joining(","));
		String fileTypes = request.getDocuments().stream().map(Document::getType).collect(Collectors.joining(","));
		map.put("fileNames", fileNames);
		map.put("fileTypes", fileTypes);
		map.put("files",sb.substring(0,sb.lastIndexOf(",")));
		uploadDocumentsResponse.setUserData(map);

		uploadDocumentsResponse.setDocuments(request.getDocuments().stream().peek(document -> document.setUploadedSuccessfully(true)).toList());

		/*boolean isPassport = false;
		if(map.getOrDefault("isPassport", "false").equalsIgnoreCase("true")){
			source = DocumentUtils.mrz;
			isPassport = true;
		}

		GetCustomerResponse getCustomerResponse = customerOnboardingApi.getCustomer(map.get("customerId"));
		DocumentUtils.ContextHolder contextHolder = new DocumentUtils.ContextHolder(getCustomerResponse.getCustomer());
        try {
			ImageCrop frontPage = customerOnboardingApi.documentPageCrop(request.getCustomerId(), "front", null, null);

			List<ExtractedData> extractedDataList = List.of(new ExtractedData("dob", DocumentUtils.getDateOfBirthStr(contextHolder, source), "Date of birth"),
					new ExtractedData("gender",DocumentUtils.getGender(contextHolder, source), "Gender"),
					new ExtractedData("firstName",DocumentUtils.getFirstName(contextHolder, source), "FirstName"),
					new ExtractedData("middleName",DocumentUtils.getMiddleNameViz(contextHolder, source), "Middle name"),
					new ExtractedData("lastName",DocumentUtils.getLastName(contextHolder, source), "Last name"),
					new ExtractedData("dateOfExpiry",DocumentUtils.getDateOfExpiry(contextHolder, source), "Date of expiry"),
					new ExtractedData("issuingAuthority",DocumentUtils.getIssuingAuthority(contextHolder, source), "Issuing Authority"),
					new ExtractedData("edition",DocumentUtils.getEdition(contextHolder), "Edition"),
					new ExtractedData("nationality",DocumentUtils.getNationality(contextHolder, source), "Nationality"),
					new ExtractedData("name",DocumentUtils.getName(getCustomerResponse.getCustomer(), isPassport).getFullName(), "Name"));

			uploadDocumentsResponse.setDocumentExtractedDataList(extractedDataList);
			uploadDocumentsResponse.setImages(new HashMap<>(1));
			uploadDocumentsResponse.getImages().put("document", Base64.getEncoder().encodeToString(frontPage.getData()));
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
*/
		log.info("upload additional docs ended");

		return uploadDocumentsResponse;
	}

}
