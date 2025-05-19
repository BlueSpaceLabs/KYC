package org.techdisqus.dao.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationEventDaoRequest {

	@JsonProperty("eventName")
	private String eventName;
	
	@JsonProperty("PK_REGISTRATION")
	private String pkRegistration;
	
	@JsonProperty("SK_REGISTRATION")
	private String skRegistration;
	
	@JsonProperty("msisdn")
	private String msisdn;
	
	@JsonProperty("recordCreateChannelId")
	private String recordCreateChannelId;
	
	@JsonProperty("recordCreateDateTime")
	private String recordCreateDateTime;
	
	@JsonProperty("simType")
	private String simType;
	
	@JsonProperty("brand")
	private String brand;
	
	@JsonProperty("regType")
	private String regType;
	
	@JsonProperty("regConfirmationNum")
	private String regConfirmationNum;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("eventName")
	public String getEventName() {
		return eventName;
	}

	@JsonProperty("eventName")
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@JsonProperty("PK_REGISTRATION")
	public String getPkRegistration() {
		return pkRegistration;
	}

	@JsonProperty("PK_REGISTRATION")
	public void setPkRegistration(String pkRegistration) {
		this.pkRegistration = pkRegistration;
	}

	@JsonProperty("SK_REGISTRATION")
	public String getSkRegistration() {
		return skRegistration;
	}

	@JsonProperty("SK_REGISTRATION")
	public void setSkRegistration(String skRegistration) {
		this.skRegistration = skRegistration;
	}

	@JsonProperty("msisdn")
	public String getMsisdn() {
		return msisdn;
	}

	@JsonProperty("msisdn")
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@JsonProperty("recordCreateChannelId")
	public String getRecordCreateChannelId() {
		return recordCreateChannelId;
	}

	@JsonProperty("recordCreateChannelId")
	public void setRecordCreateChannelId(String recordCreateChannelId) {
		this.recordCreateChannelId = recordCreateChannelId;
	}

	@JsonProperty("recordCreateDateTime")
	public String getRecordCreateDateTime() {
		return recordCreateDateTime;
	}

	@JsonProperty("recordCreateDateTime")
	public void setRecordCreateDateTime(String recordCreateDateTime) {
		this.recordCreateDateTime = recordCreateDateTime;
	}

	@JsonProperty("simType")
	public String getSimType() {
		return simType;
	}

	@JsonProperty("simType")
	public void setSimType(String simType) {
		this.simType = simType;
	}

	@JsonProperty("brand")
	public String getBrand() {
		return brand;
	}

	@JsonProperty("brand")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@JsonProperty("regType")
	public String getRegType() {
		return regType;
	}

	@JsonProperty("regType")
	public void setRegType(String regType) {
		this.regType = regType;
	}

	@JsonProperty("regConfirmationNum")
	public String getRegConfirmationNum() {
		return regConfirmationNum;
	}

	@JsonProperty("regConfirmationNum")
	public void setRegConfirmationNum(String regConfirmationNum) {
		this.regConfirmationNum = regConfirmationNum;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
