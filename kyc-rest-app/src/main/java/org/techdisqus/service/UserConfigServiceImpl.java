package org.techdisqus.service;

import org.techdisqus.request.AbstractRequest;
import org.techdisqus.request.AccountType;
import org.techdisqus.request.AccountTypeSelectionRequest;
import org.techdisqus.request.UserConfigRequest;
import org.techdisqus.response.AccountTypeSelectionResponse;
import org.techdisqus.response.UserConfigResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserConfigServiceImpl extends KycBaseService implements UserConfigService{
    @Override
    public UserConfigResponse getAccountTypes(UserConfigRequest request) {

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
        response.setRequestId(request.getRequestId());
        response.setSpanId(getRequestId());

        return response;
    }

    @Override
    public AccountTypeSelectionResponse submitAccountType(AccountTypeSelectionRequest request) {
        AccountTypeSelectionResponse response =  AccountTypeSelectionResponse.builder().build();
        response.setSpanId(request.getRequestId());
        response.setAccountType(request.getAccountType());
        Map<String,String> map = request.getRequestInformation();
        map.put("accountType",request.getAccountType().getKey());
        response.setUserData(map);
        response.setSpanId(getRequestId());

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
