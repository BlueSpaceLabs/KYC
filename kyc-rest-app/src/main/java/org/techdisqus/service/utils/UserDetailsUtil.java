package org.techdisqus.service.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovatrics.dot.integrationsamples.disapi.model.CustomerOnboardingApi;
import com.innovatrics.dot.integrationsamples.disapi.model.ImageCrop;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.request.Document;
import org.techdisqus.response.UserOnboardingDetails;
import org.techdisqus.service.UserDetailsServiceImpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class UserDetailsUtil {

    @Autowired private CustomerOnboardingApi customerOnboardingApi;

    @SneakyThrows
    public UserOnboardingDetails getUserOnboardingDetails(Map<String, String> map){

        String userDetails = map.get("userDetails");

        UserDetailsServiceImpl.UserDetailsHolder userDetailsHolder = new ObjectMapper().readValue(userDetails, UserDetailsServiceImpl.UserDetailsHolder.class);
        return UserOnboardingDetails.builder().
                dateOfBirth(userDetailsHolder.getDateOfBirth()).
                addresses(userDetailsHolder.getAddresses()).
                gender(userDetailsHolder.getGender()).
                firstName(userDetailsHolder.getFirstName()).
                middleName(userDetailsHolder.getMiddleName()).
                lastName(userDetailsHolder.getLastName()).build();





    }

    @SneakyThrows
    public List<Document> getAdditionalDocuments(Map<String, String> map) {
        List<Document> documents = new ArrayList<>(2);
        if(map.containsKey("fileNames")) {
            String[] fileTypes = map.get("fileTypes").split(",");
            String[] split = map.get("fileNames").split(",");
            for (int i = 0; i < split.length; i++) {
                String fileName = split[i];
                String fileType = fileTypes[i];
                String image =
                        Files.readString(Paths.get("/tmp/" + map.get("msisdn") + "___" + fileName + "___" + fileType  + ".txt"));
                Document document = new Document();
                document.setImage(image);
                document.setName(fileName);
                document.setType(fileType);
                document.setUploadedSuccessfully(true);
                documents.add(document);
            }
        }

        return documents;
    }

    @SneakyThrows
    public Map<String, String> getIdAndSelfie(Map<String, String> map) {

        Map<String, String> idAndSelfie = new HashMap<>();
        String customerId = map.get("customerId");

        ImageCrop frontPage = customerOnboardingApi.documentPageCrop(customerId, "front", null, null);
        idAndSelfie.put("id-document", Base64.getEncoder().encodeToString(frontPage.getData()));

        ImageCrop selfie = customerOnboardingApi.getSelfieImage(customerId);
        idAndSelfie.put("user-selfie", Base64.getEncoder().encodeToString(selfie.getData()));

        return idAndSelfie;
    }
}
