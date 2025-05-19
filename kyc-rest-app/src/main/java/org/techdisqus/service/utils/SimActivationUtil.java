package org.techdisqus.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.GetCustomerDetailsDao;
import org.techdisqus.dao.RegisterEventDao;
import org.techdisqus.dao.request.RegistrationEventDaoRequest;
import org.techdisqus.dao.response.RegistrationEventResponse;
import org.techdisqus.dao.response.custom.attributes.GetCustomerDetailsDaoResponse;
import org.techdisqus.request.AccountType;
import org.techdisqus.service.KycBaseService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.techdisqus.service.utils.DateUtils.ZONE_ID;

@Component
public class SimActivationUtil extends KycBaseService {

    @Resource
    private GetCustomerDetailsDao getCustomerDetailsDao;

    @Resource
    private RegistrationStatusUtil registrationStatusUtils;

    @Autowired
    private RegisterEventDao registerEventDao;

    private static final Map<String, String> REGISTRATION_TYPE_MAPPING = new HashMap<>(8);

    private static final Logger logger = LoggerFactory.getLogger(SimActivationUtil.class);

    public static class SimActivateDetails {

        private String externalId;

        private String msisdn;

        private String encryptedMsisdn;

        private String channelId;

        private String simType;

        private String brand;

        private AccountType accountType;

        public String getExternalId() {
            return externalId;
        }

        public void setExternalId(String externalId) {
            this.externalId = externalId;
        }

        public String getEncryptedMsisdn() {
            return encryptedMsisdn;
        }

        public void setEncryptedMsisdn(String encryptedMsisdn) {
            this.encryptedMsisdn = encryptedMsisdn;
        }

        public String getMsisdn() {
            return msisdn;
        }

        public void setMsisdn(String msisdn) {
            this.msisdn = msisdn;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getSimType() {
            return simType;
        }

        public void setSimType(String simType) {
            this.simType = simType;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public AccountType getAccountType() {
            return accountType;
        }

        public void setAccountType(AccountType accountType) {
            this.accountType = accountType;
        }
    }


    public boolean activateSim( SimActivateDetails simActivateDetails){
        try {
            RegistrationEventDaoRequest daoRequest = getRegistrationEventDaoRequest(simActivateDetails);
            RegistrationEventResponse registrationEventDaoResponse = registerEventDao.registerSim(daoRequest);
            logger.info("message from the registration event: {}", registrationEventDaoResponse.getMessage());
        } catch (Exception e) {
            logger.error("Error while retrieving the customer details from ABIS", e);
            return false;
        }
        return true;
    }

    public boolean activateSim( String externalId, GetCustomerDetailsDaoResponse getCustomerDetailsDaoResponse){

        SimActivateDetails simActivateDetails = new SimActivateDetails();
        simActivateDetails.setExternalId(externalId);
        simActivateDetails.setEncryptedMsisdn(encryptionUtil.encrypt(getCustomerDetailsDaoResponse.getCustomDetails().getPhoneNumber()));
        simActivateDetails.setChannelId(getCustomerDetailsDaoResponse.getCustomDetails().getLocation());
        simActivateDetails.setSimType(getCustomerDetailsDaoResponse.getCustomDetails().getSourceSystem());
        simActivateDetails.setBrand(getCustomerDetailsDaoResponse.getCustomDetails().getEmployer());
        AccountType accountType = new AccountType();
        accountType.setKey(getCustomerDetailsDaoResponse.getCustomDetails().getRegistrationType());
        simActivateDetails.setAccountType(accountType);

        return activateSim(simActivateDetails);
    }

    public RegistrationEventDaoRequest getRegistrationEventDaoRequest(SimActivateDetails simActivateDetails) {

        String formattedDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZONE_ID)
                .format(Instant.now().atZone(ZONE_ID).toInstant());

        RegistrationEventDaoRequest daoRequest = new RegistrationEventDaoRequest();

        daoRequest.setEventName("INSERT");
        daoRequest.setPkRegistration("SUB#"+simActivateDetails.getMsisdn());
        daoRequest.setSkRegistration("#ENTITY");
        daoRequest.setMsisdn(simActivateDetails.getMsisdn());
        daoRequest.setRecordCreateChannelId(simActivateDetails.getChannelId());
        daoRequest.setRecordCreateDateTime(formattedDateTime);
        daoRequest.setSimType(simActivateDetails.getSimType());
        daoRequest.setBrand(simActivateDetails.getBrand());
        daoRequest.setRegType(REGISTRATION_TYPE_MAPPING.get(simActivateDetails.getAccountType().getKey()));
        daoRequest.setRegConfirmationNum(simActivateDetails.getExternalId());

        return daoRequest;
    }

    @PostConstruct
    public void init(){
        REGISTRATION_TYPE_MAPPING.put("Sim Owner", "Owner");
        REGISTRATION_TYPE_MAPPING.put("Parent or Legal guardian", "Parent / Legal Guardian");
        REGISTRATION_TYPE_MAPPING.put("Auth Signatory or representative", "Authorized Representative");
        REGISTRATION_TYPE_MAPPING.put("Foreign Tourist", "Foreigner - Tourist");
        REGISTRATION_TYPE_MAPPING.put("Foreigner Working Resident", "Foreigner - Working Resident");
        REGISTRATION_TYPE_MAPPING.put("Foreigner Student Resident", "Foreigner - Student Resident");
        REGISTRATION_TYPE_MAPPING.put("Foreigner Resident", "Foreigner - Resident");
        REGISTRATION_TYPE_MAPPING.put("Foreigner Persona of concern", "Foreigner - Persons of Concern");
    }
}
