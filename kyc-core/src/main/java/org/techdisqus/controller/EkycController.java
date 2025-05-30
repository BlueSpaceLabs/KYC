package org.techdisqus.controller;

import com.innovatrics.dot.integrationsamples.disapi.ApiException;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.techdisqus.request.*;
import org.techdisqus.response.*;
import org.techdisqus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techdisqus.util.JwtTokenUtil;

@RestController
@RequestMapping("/v1/ekyc")
@CrossOrigin(origins = "*")
public class EkycController {

    @Autowired
    private DocumentScanService documentScanService;

    @Autowired
    private SelfieScanService selfieScanService;

    @Autowired
    private ValidateAccountService validateAccountService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private UserConfigService userConfigService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserAdditionalDocumentService userAdditionalDocumentService;

    @Autowired
    private RegisterUserService registerUserService;

    @Autowired
    private UserSummaryService userSummaryService;

    @Autowired
    private EditService editService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping(value = "/validateAccount", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ValidateAccountResponse> validateAccount(@RequestBody ValidateAccountRequest request, KycRequestHeaders kycRequestHeaders) {
        ValidateAccountResponse response =  validateAccountService.verify(request,kycRequestHeaders);
        String token = jwtTokenUtil.generateToken(request.getAccountIdentifier());

        return response.isSuccess() ? ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(response) :
                ResponseEntity.badRequest().body(response);
    }

    @PostMapping(value = "/resend-otp", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ValidateAccountResponse> resendOtp(@RequestBody ValidateAccountRequest request, KycRequestHeaders kycRequestHeaders) {
        ValidateAccountResponse response =  validateAccountService.resendOtp(request,kycRequestHeaders);
        String token = jwtTokenUtil.generateToken(request.getAccountIdentifier());

        return response.isSuccess() ? ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(response) :
                ResponseEntity.badRequest().body(response);
    }

    @PostMapping(value = "/validateOtp", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ValidateCodeResponse> validateOtp(@RequestBody ValidateCodeRequest request, KycRequestHeaders kycRequestHeaders) {
        ValidateCodeResponse response =  validateCodeService.verifyOtp(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @GetMapping(value = "/userConfig")
    public ResponseEntity<UserConfigResponse> getUserConfig(KycRequestHeaders kycRequestHeaders) {
        UserConfigRequest request = new UserConfigRequest();
        request.setLocale(kycRequestHeaders.getLocale());
        request.setRequestInformation(kycRequestHeaders.getRequestInformation());
        UserConfigResponse response = userConfigService.getAccountTypes(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @PutMapping(value = "/userConfig")
    public ResponseEntity<AccountTypeSelectionResponse> submitUserConfig(@RequestBody AccountTypeSelectionRequest request, KycRequestHeaders kycRequestHeaders) {
        AccountTypeSelectionResponse response = userConfigService.submitAccountType(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @PostMapping(value = "/documentScan", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DocumentScanResponse> documentScan(@RequestBody DocumentScanRequest request, KycRequestHeaders kycRequestHeaders) throws ApiException{
        DocumentScanResponse response = documentScanService.scanDocument(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @PostMapping(value = "/documentScan/raw", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public DocumentScanResponse documentScanBinary(@RequestBody DocumentScanRequest request, KycRequestHeaders kycRequestHeaders) throws ApiException {
        return documentScanService.scanDocument(request, kycRequestHeaders);

    }

    @SneakyThrows
    @PostMapping(value = "/evaluateUserSelfie", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserSelfieResponse> evaluateSelfie(@RequestBody UserSelfieRequest request, KycRequestHeaders kycRequestHeaders) throws ApiException{
        UserSelfieResponse response = selfieScanService.scanSelfie(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @PostMapping(value = "/user-details/submit", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDetailsResponse> submitUserDetailsService(@RequestBody UserDetailsRequest request, KycRequestHeaders kycRequestHeaders) throws ApiException{
        UserDetailsResponse response = userDetailsService.submitPersonalDetails(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @PostMapping(value = "/additional-docs/upload", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UploadDocumentsResponse> additionalDocsUpload(@RequestBody UploadDocumentsRequest request, KycRequestHeaders kycRequestHeaders) throws ApiException{
        UploadDocumentsResponse response = userAdditionalDocumentService.uploadDocs(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @GetMapping(value = "/summary",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserSummaryResponse> additionalDocsUpload( KycRequestHeaders kycRequestHeaders) throws ApiException{
        UserSummaryRequest request = new UserSummaryRequest();
        request.setRequestInformation(kycRequestHeaders.getRequestInformation());
        UserSummaryResponse response = userSummaryService.getSummary(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @GetMapping(value = "/edit", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EditResponse> edit( KycRequestHeaders kycRequestHeaders) throws ApiException{
        EditRequest request = new EditRequest();
        request.setRequestInformation(kycRequestHeaders.getRequestInformation());
        EditResponse response = editService.edit(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }

    @SneakyThrows
    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest request, KycRequestHeaders kycRequestHeaders) throws ApiException{
        RegisterUserResponse response = registerUserService.register(request,kycRequestHeaders);

        return response.isSuccess() ? ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body(response);
    }



}
