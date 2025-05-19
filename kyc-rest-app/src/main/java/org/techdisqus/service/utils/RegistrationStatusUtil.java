package org.techdisqus.service.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.RegistrationStatus;
import org.techdisqus.dao.RegistrationStatusDao;
import org.techdisqus.exception.ApiExecutionException;
import org.techdisqus.request.AccountType;
import org.techdisqus.request.RegisterUserRequest;
import org.techdisqus.service.KycBaseService;
import org.techdisqus.service.RegistrationStatusCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.techdisqus.service.utils.DateUtils.now;

@Component
public class RegistrationStatusUtil extends KycBaseService {

    @Autowired
    private RegistrationStatusDao registrationStatusDao;

    public boolean registerCustomer(String externalId, String msisdn, AccountType accountType,
                                    RegistrationStatusCode registrationStatusCode){

        RegistrationStatus registrationStatus = new RegistrationStatus();
        registrationStatus.setMsisdn(encryptionUtil.encrypt(msisdn));
        registrationStatus.setExternalId(externalId);
        registrationStatus.setStatus(registrationStatusCode.name());
        registrationStatus.setType(accountType.getKey());
        registrationStatus.setLastUpdateDateTime(now().toEpochSecond());

        try {
            registrationStatusDao.saveRegistration(registrationStatus);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void onDeactivate(String msisdn){
        registrationStatusDao.deleteByMsisdn(msisdn);
    }

    public void deleteByMsisdn(String msisdn){
        registrationStatusDao.deleteByMsisdn(msisdn);
    }

    public RegistrationStatus getByMsisdn(String msisdn){
        return registrationStatusDao.loadByMsisdn(msisdn);
    }

    public RegistrationStatus getByExternalId(String externalId){
        return registrationStatusDao.loadByExternalId(externalId);
    }
    
    
    public List<RegistrationStatus> getByExternalIds(List<String> externalIds, RegisterUserRequest request){

        List<Future<RegistrationStatus>> futures = new ArrayList<>(externalIds.size());
        List<RegistrationStatus> registrationStatuses = new ArrayList<>(externalIds.size());

        for(String externalId : externalIds){
            futures.add(registrationStatusDao.loadByExternalIdAsync(externalId));
        }

        for(Future<RegistrationStatus> registrationStatusFuture : futures) {
            try {
                registrationStatuses.add(registrationStatusFuture.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new ApiExecutionException(e, request);
            }
        }

        return registrationStatuses;
    }
}
