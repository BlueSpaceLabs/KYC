
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
    "maxEyeDistance",
    "minEyeDistance"
})
@Generated("jsonschema2pojo")
public class ExtractionParameters {

    @JsonProperty("maxEyeDistance")
    private String maxEyeDistance;
    @JsonProperty("minEyeDistance")
    private String minEyeDistance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("maxEyeDistance")
    public String getMaxEyeDistance() {
        return maxEyeDistance;
    }

    @JsonProperty("maxEyeDistance")
    public void setMaxEyeDistance(String maxEyeDistance) {
        this.maxEyeDistance = maxEyeDistance;
    }

    public ExtractionParameters withMaxEyeDistance(String maxEyeDistance) {
        this.maxEyeDistance = maxEyeDistance;
        return this;
    }

    @JsonProperty("minEyeDistance")
    public String getMinEyeDistance() {
        return minEyeDistance;
    }

    @JsonProperty("minEyeDistance")
    public void setMinEyeDistance(String minEyeDistance) {
        this.minEyeDistance = minEyeDistance;
    }

    public ExtractionParameters withMinEyeDistance(String minEyeDistance) {
        this.minEyeDistance = minEyeDistance;
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

    public ExtractionParameters withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
