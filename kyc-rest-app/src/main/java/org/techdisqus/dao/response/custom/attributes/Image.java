
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
    "captureDevice",
    "dataBytes",
    "dataUrl",
    "format",
    "resolutionDpi"
})
@Generated("jsonschema2pojo")
public class Image {

    @JsonProperty("captureDevice")
    private String captureDevice;
    @JsonProperty("dataBytes")
    private String dataBytes;
    @JsonProperty("dataUrl")
    private String dataUrl;
    @JsonProperty("format")
    private String format;
    @JsonProperty("resolutionDpi")
    private String resolutionDpi;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("captureDevice")
    public String getCaptureDevice() {
        return captureDevice;
    }

    @JsonProperty("captureDevice")
    public void setCaptureDevice(String captureDevice) {
        this.captureDevice = captureDevice;
    }

    public Image withCaptureDevice(String captureDevice) {
        this.captureDevice = captureDevice;
        return this;
    }

    @JsonProperty("dataBytes")
    public String getDataBytes() {
        return dataBytes;
    }

    @JsonProperty("dataBytes")
    public void setDataBytes(String dataBytes) {
        this.dataBytes = dataBytes;
    }

    public Image withDataBytes(String dataBytes) {
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

    public Image withDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
        return this;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    public Image withFormat(String format) {
        this.format = format;
        return this;
    }

    @JsonProperty("resolutionDpi")
    public String getResolutionDpi() {
        return resolutionDpi;
    }

    @JsonProperty("resolutionDpi")
    public void setResolutionDpi(String resolutionDpi) {
        this.resolutionDpi = resolutionDpi;
    }

    public Image withResolutionDpi(String resolutionDpi) {
        this.resolutionDpi = resolutionDpi;
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

    public Image withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
