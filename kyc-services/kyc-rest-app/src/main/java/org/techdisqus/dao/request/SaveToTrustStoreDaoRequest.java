package org.techdisqus.dao.request;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "externalId",
        "onboardingStatus"
})
@Generated("jsonschema2pojo")
public class SaveToTrustStoreDaoRequest {

    @JsonProperty("externalId")
    private String externalId;
    @JsonProperty("onboardingStatus")
    private String onboardingStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("externalId")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SaveToTrustStoreDaoRequest withExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    @JsonProperty("onboardingStatus")
    public String getOnboardingStatus() {
        return onboardingStatus;
    }

    @JsonProperty("onboardingStatus")
    public void setOnboardingStatus(String onboardingStatus) {
        this.onboardingStatus = onboardingStatus;
    }

    public SaveToTrustStoreDaoRequest withOnboardingStatus(String onboardingStatus) {
        this.onboardingStatus = onboardingStatus;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SaveToTrustStoreDaoRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}