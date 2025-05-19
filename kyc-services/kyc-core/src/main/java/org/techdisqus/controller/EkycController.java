package org.techdisqus.controller;

import com.innovatrics.dot.integrationsamples.disapi.ApiException;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.techdisqus.request.*;
import org.techdisqus.response.*;
import org.techdisqus.service.DocumentScanService;
import org.techdisqus.service.UserConfigService;
import org.techdisqus.service.ValidateAccountService;
import org.techdisqus.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/ekyc")
public class EkycController {

    @Autowired
    private DocumentScanService documentScanService;

    @Autowired
    private ValidateAccountService validateAccountService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private UserConfigService userConfigService;



    @PostMapping(value = "/validateAccount", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ValidateAccountResponse> validateAccount(@RequestBody ValidateAccountRequest request) {
        ValidateAccountResponse response =  validateAccountService.verify(request);
        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @PostMapping(value = "/validateOtp", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ValidateCodeResponse> validateOtp(@RequestBody ValidateCodeRequest request) {
        ValidateCodeResponse response =  validateCodeService.verifyOtp(request);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @GetMapping(value = "/userConfig")
    public ResponseEntity<UserConfigResponse> getUserConfig(@RequestBody UserConfigRequest request) {
        UserConfigResponse response = userConfigService.getAccountTypes(request);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @PutMapping(value = "/userConfig")
    public ResponseEntity<AccountTypeSelectionResponse> submitUserConfig(@RequestBody AccountTypeSelectionRequest request) {
        AccountTypeSelectionResponse response = userConfigService.submitAccountType(request);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @PostMapping(value = "/documentScan", consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DocumentScanResponse> documentScan(@RequestBody DocumentScanRequest request) throws ApiException{
        DocumentScanResponse response = documentScanService.scanDocument(request);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @PostMapping(value = "/documentScan/raw", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public DocumentScanResponse documentScanBinary(@RequestBody DocumentScanRequest request) throws ApiException {
        return documentScanService.scanDocument(request);

    }



}
