package org.techdisqus.dao;


import java.util.concurrent.Future;

public interface RegistrationStatusDao  {

    void saveRegistration(RegistrationStatus registrationStatus);

    Future<String> saveRegistrationAsync(RegistrationStatus registrationStatus);

    RegistrationStatus loadByMsisdn(String msisdn);

    RegistrationStatus loadByExternalId(String externalId);

    Future<RegistrationStatus> loadByExternalIdAsync(String externalId);

    void updateByExternalId(RegistrationStatus registrationStatus);

    void deleteByMsisdn(String msisdn);


}
