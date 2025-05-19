
package org.techdisqus.dao.response.custom.attributes;

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
    "candidateExternalId",
    "score"
})
@Generated("jsonschema2pojo")
public class IdentifyCandidate {

    @JsonProperty("candidateExternalId")
    private String candidateExternalId;
    @JsonProperty("score")
    private String score;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("candidateExternalId")
    public String getCandidateExternalId() {
        return candidateExternalId;
    }

    @JsonProperty("candidateExternalId")
    public void setCandidateExternalId(String candidateExternalId) {
        this.candidateExternalId = candidateExternalId;
    }

    public IdentifyCandidate withCandidateExternalId(String candidateExternalId) {
        this.candidateExternalId = candidateExternalId;
        return this;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    public IdentifyCandidate withScore(String score) {
        this.score = score;
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

    public IdentifyCandidate withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
