package org.techdisqus.service;

import lombok.extern.slf4j.Slf4j;
import org.techdisqus.request.*;
import org.techdisqus.response.AccountTypeSelectionResponse;
import org.techdisqus.response.UserConfigResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class UserConfigServiceImpl extends KycBaseService implements UserConfigService{
    @Override
    public UserConfigResponse getAccountTypes(UserConfigRequest request, KycRequestHeaders kycRequestHeaders) {

        log.info("getting account types started");

        UserConfigResponse response = UserConfigResponse.builder().build();

        response.setUserData(request.getRequestInformation());
        List<AccountType> accountTypeList = new ArrayList<>();
        accountTypeList.add(getAccountType("Sim Owner","label.sim.owner",request));
        accountTypeList.add(getAccountType("Parent or Legal guardian","label.parent.or.legal.guardian",request));
        accountTypeList.add(getAccountType("Auth Signatory or representative","label.auth.signatory.or.rep",request));
        accountTypeList.add(getAccountType("Foreign Tourist","label.foreigner.tourist",request));
        accountTypeList.add(getAccountType("Foreigner Working Resident","label.foreigner.working.resident",request));
        accountTypeList.add(getAccountType("Foreigner Student Resident","label.foreigner.student.resident",request));
        accountTypeList.add(getAccountType("Foreigner Resident","label.foreigner.resident",request));
        accountTypeList.add(getAccountType("Foreigner Persona of concern","label.foreigner.person.of.concern",request));
        response.setAccountTypes(accountTypeList);

        log.info("getting account types ended");
        return response;
    }

    @Override
    public AccountTypeSelectionResponse submitAccountType(AccountTypeSelectionRequest request, KycRequestHeaders kycRequestHeaders) {
        log.info("submit account types started");
        AccountTypeSelectionResponse response =  AccountTypeSelectionResponse.builder().build();
        response.setAccountType(request.getAccountType());
        Map<String,String> map = request.getRequestInformation();
        map.put("accountType",request.getAccountType().getKey());
        response.setUserData(map);
        log.info("submit account types ended");

        return response;
    }


    private AccountType getAccountType(String typeKey, String code, AbstractRequest request){
        AccountType accountType = new AccountType();
        accountType.setKey(typeKey);
        String label = messageProvider.getMessage(code, toLocale(request));
        accountType.setValue(label);

        return accountType;
    }
}
