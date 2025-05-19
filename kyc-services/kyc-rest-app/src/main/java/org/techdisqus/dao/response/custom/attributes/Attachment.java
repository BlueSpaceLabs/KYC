
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
    "dataUrl",
    "description",
    "filename",
    "name",
    "nameCode"
})
@Generated("jsonschema2pojo")
public class Attachment {

    @JsonProperty("dataBytes")
    private String dataBytes;
    @JsonProperty("dataUrl")
    private String dataUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameCode")
    private String nameCode;
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

    public Attachment withDataBytes(String dataBytes) {
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

    public Attachment withDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Attachment withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Attachment withFilename(String filename) {
        this.filename = filename;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Attachment withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("nameCode")
    public String getNameCode() {
        return nameCode;
    }

    @JsonProperty("nameCode")
    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

    public Attachment withNameCode(String nameCode) {
        this.nameCode = nameCode;
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

    public Attachment withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
