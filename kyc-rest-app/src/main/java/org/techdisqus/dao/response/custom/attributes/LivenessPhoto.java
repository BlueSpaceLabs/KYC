
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
    "assertion",
    "dataBytes",
    "dataUrl",
    "format",
    "icaoCropCoordinates",
    "livenessConfidence",
    "livenessScore",
    "similarityVsPrimarySelfieScore",
    "source",
    "type"
})
@Generated("jsonschema2pojo")
public class LivenessPhoto {

    @JsonProperty("assertion")
    private String assertion;
    @JsonProperty("dataBytes")
    private String dataBytes;
    @JsonProperty("dataUrl")
    private String dataUrl;
    @JsonProperty("format")
    private String format;
    @JsonProperty("icaoCropCoordinates")
    private IcaoCropCoordinates icaoCropCoordinates;
    @JsonProperty("livenessConfidence")
    private String livenessConfidence;
    @JsonProperty("livenessScore")
    private String livenessScore;
    @JsonProperty("similarityVsPrimarySelfieScore")
    private String similarityVsPrimarySelfieScore;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("assertion")
    public String getAssertion() {
        return assertion;
    }

    @JsonProperty("assertion")
    public void setAssertion(String assertion) {
        this.assertion = assertion;
    }

    public LivenessPhoto withAssertion(String assertion) {
        this.assertion = assertion;
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

    public LivenessPhoto withDataBytes(String dataBytes) {
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

    public LivenessPhoto withDataUrl(String dataUrl) {
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

    public LivenessPhoto withFormat(String format) {
        this.format = format;
        return this;
    }

    @JsonProperty("icaoCropCoordinates")
    public IcaoCropCoordinates getIcaoCropCoordinates() {
        return icaoCropCoordinates;
    }

    @JsonProperty("icaoCropCoordinates")
    public void setIcaoCropCoordinates(IcaoCropCoordinates icaoCropCoordinates) {
        this.icaoCropCoordinates = icaoCropCoordinates;
    }

    public LivenessPhoto withIcaoCropCoordinates(IcaoCropCoordinates icaoCropCoordinates) {
        this.icaoCropCoordinates = icaoCropCoordinates;
        return this;
    }

    @JsonProperty("livenessConfidence")
    public String getLivenessConfidence() {
        return livenessConfidence;
    }

    @JsonProperty("livenessConfidence")
    public void setLivenessConfidence(String livenessConfidence) {
        this.livenessConfidence = livenessConfidence;
    }

    public LivenessPhoto withLivenessConfidence(String livenessConfidence) {
        this.livenessConfidence = livenessConfidence;
        return this;
    }

    @JsonProperty("livenessScore")
    public String getLivenessScore() {
        return livenessScore;
    }

    @JsonProperty("livenessScore")
    public void setLivenessScore(String livenessScore) {
        this.livenessScore = livenessScore;
    }

    public LivenessPhoto withLivenessScore(String livenessScore) {
        this.livenessScore = livenessScore;
        return this;
    }

    @JsonProperty("similarityVsPrimarySelfieScore")
    public String getSimilarityVsPrimarySelfieScore() {
        return similarityVsPrimarySelfieScore;
    }

    @JsonProperty("similarityVsPrimarySelfieScore")
    public void setSimilarityVsPrimarySelfieScore(String similarityVsPrimarySelfieScore) {
        this.similarityVsPrimarySelfieScore = similarityVsPrimarySelfieScore;
    }

    public LivenessPhoto withSimilarityVsPrimarySelfieScore(String similarityVsPrimarySelfieScore) {
        this.similarityVsPrimarySelfieScore = similarityVsPrimarySelfieScore;
        return this;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public LivenessPhoto withSource(String source) {
        this.source = source;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public LivenessPhoto withType(String type) {
        this.type = type;
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

    public LivenessPhoto withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
