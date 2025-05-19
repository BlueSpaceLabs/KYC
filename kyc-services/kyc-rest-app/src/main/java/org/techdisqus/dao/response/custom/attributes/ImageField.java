
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
    "extractionParameters",
    "height",
    "label",
    "ocrConfidence",
    "orientation",
    "type",
    "value",
    "width",
    "x",
    "y"
})
@Generated("jsonschema2pojo")
public class ImageField {

    @JsonProperty("extractionParameters")
    private ExtractionParameters extractionParameters;
    @JsonProperty("height")
    private String height;
    @JsonProperty("label")
    private String label;
    @JsonProperty("ocrConfidence")
    private String ocrConfidence;
    @JsonProperty("orientation")
    private String orientation;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;
    @JsonProperty("width")
    private String width;
    @JsonProperty("x")
    private String x;
    @JsonProperty("y")
    private String y;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("extractionParameters")
    public ExtractionParameters getExtractionParameters() {
        return extractionParameters;
    }

    @JsonProperty("extractionParameters")
    public void setExtractionParameters(ExtractionParameters extractionParameters) {
        this.extractionParameters = extractionParameters;
    }

    public ImageField withExtractionParameters(ExtractionParameters extractionParameters) {
        this.extractionParameters = extractionParameters;
        return this;
    }

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    public ImageField withHeight(String height) {
        this.height = height;
        return this;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    public ImageField withLabel(String label) {
        this.label = label;
        return this;
    }

    @JsonProperty("ocrConfidence")
    public String getOcrConfidence() {
        return ocrConfidence;
    }

    @JsonProperty("ocrConfidence")
    public void setOcrConfidence(String ocrConfidence) {
        this.ocrConfidence = ocrConfidence;
    }

    public ImageField withOcrConfidence(String ocrConfidence) {
        this.ocrConfidence = ocrConfidence;
        return this;
    }

    @JsonProperty("orientation")
    public String getOrientation() {
        return orientation;
    }

    @JsonProperty("orientation")
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public ImageField withOrientation(String orientation) {
        this.orientation = orientation;
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

    public ImageField withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public ImageField withValue(String value) {
        this.value = value;
        return this;
    }

    @JsonProperty("width")
    public String getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(String width) {
        this.width = width;
    }

    public ImageField withWidth(String width) {
        this.width = width;
        return this;
    }

    @JsonProperty("x")
    public String getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(String x) {
        this.x = x;
    }

    public ImageField withX(String x) {
        this.x = x;
        return this;
    }

    @JsonProperty("y")
    public String getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(String y) {
        this.y = y;
    }

    public ImageField withY(String y) {
        this.y = y;
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

    public ImageField withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
