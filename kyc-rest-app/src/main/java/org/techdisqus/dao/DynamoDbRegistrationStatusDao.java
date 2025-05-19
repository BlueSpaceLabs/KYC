package org.techdisqus.dao;

import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class DynamoDbRegistrationStatusDao implements RegistrationStatusDao{

    private static final String EXTERNAL_ID_GSI_INDEX = "externalId-index";

    private static final String EXTERNAL_ID = "externalId";
    
    @Autowired(required = false)
    private AmazonDynamoDbClient amazonDynamoDbClient;

    public void saveRegistration(RegistrationStatus registrationStatus){
    	amazonDynamoDbClient.getDbMapper().save(registrationStatus);
    }

    @Async
    public Future<String> saveRegistrationAsync(RegistrationStatus registrationStatus){
    	amazonDynamoDbClient.getDbMapper().save(registrationStatus);
        return AsyncResult.forValue("success");
    }
    public RegistrationStatus loadByMsisdn(String msisdn){
    	
        return amazonDynamoDbClient.getDbMapper().load(RegistrationStatus.class, msisdn);
        
    }

    public RegistrationStatus loadByExternalId(String externalId){

        Table table = amazonDynamoDbClient.getTable();
        Index index = table.getIndex(EXTERNAL_ID_GSI_INDEX);
        QuerySpec spec = new QuerySpec().withHashKey(EXTERNAL_ID, externalId);

        ItemCollection<QueryOutcome> items = index.query(spec);

        Iterator<Item> iterator = items.iterator();
        if (iterator.hasNext()) {
            try {
                Item item = iterator.next();
                return new ObjectMapper().readValue(item.toJSON(), RegistrationStatus.class);
            } catch (IOException e) {
                throw new RuntimeException("Error parsing item to RegistrationStatus", e);
            }
        }

        return null;

    }

    @Async
    public Future<RegistrationStatus> loadByExternalIdAsync(String externalId){
        return AsyncResult.forValue(loadByExternalId(externalId));
    }

    public List<RegistrationStatus> loadByExternalIds(List<String> externalIds) {
        List<Future<RegistrationStatus>> futures = new ArrayList<>(externalIds.size());

        for(String externalId : externalIds){
            futures.add(loadByExternalIdAsync(externalId));
        }

        List<RegistrationStatus> registrationStatuses = new ArrayList<>(externalIds.size());

        for(Future<RegistrationStatus> registrationStatusFuture : futures) {
            try {
                registrationStatuses.add(registrationStatusFuture.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return registrationStatuses;
    }

    public void updateByExternalId(RegistrationStatus registrationStatus){
    	
    	amazonDynamoDbClient.getDbMapper().save(registrationStatus);
    }

    public void deleteByMsisdn(String msisdn){
    	
        RegistrationStatus registrationStatus = new RegistrationStatus();
        registrationStatus.setMsisdn(msisdn);
        
        amazonDynamoDbClient.getDbMapper().delete(registrationStatus);
    }
}
