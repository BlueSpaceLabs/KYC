
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
    "dataBytes",
    "dataUrl"
})
@Generated("jsonschema2pojo")
public class Template {

    @JsonProperty("dataBytes")
    private String dataBytes;
    @JsonProperty("dataUrl")
    private String dataUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("dataBytes")
    public String getDataBytes() {
        return dataBytes;
    }

    @JsonProperty("dataBytes")
    public void setDataBytes(String dataBytes) {
        this.dataBytes = dataBytes;
    }

    public Template withDataBytes(String dataBytes) {
        this.dataBytes = dataBytes;
        return this;
    }

    @JsonProperty("dataUrl")
    public String getDataUrl() {
        return dataUrl;
    }

    @JsonProperty("dataUrl")
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public Template withDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
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

    public Template withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
