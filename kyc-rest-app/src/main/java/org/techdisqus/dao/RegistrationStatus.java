package org.techdisqus.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBTable(tableName = "RegistrationStatus")
public class RegistrationStatus  {

    @DynamoDBHashKey
    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("externalId")
    private String externalId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("type")
    private String type;

    @JsonProperty("lastUpdateDateTime")
    private long lastUpdateDateTime;
    
    @JsonProperty("lastAuthToken")
    private String lastAuthToken;



    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(long lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

	public String getLastAuthToken() {
		return lastAuthToken;
	}

	public void setLastAuthToken(String lastAuthToken) {
		this.lastAuthToken = lastAuthToken;
	}
    
}
