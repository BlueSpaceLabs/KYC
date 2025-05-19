
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
    "height",
    "label",
    "ocrConfidence",
    "orientation",
    "rawValue",
    "type",
    "value",
    "width",
    "x",
    "y"
})
@Generated("jsonschema2pojo")
public class TextField {

    @JsonProperty("height")
    private String height;
    @JsonProperty("label")
    private String label;
    @JsonProperty("ocrConfidence")
    private String ocrConfidence;
    @JsonProperty("orientation")
    private String orientation;
    @JsonProperty("rawValue")
    private String rawValue;
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

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    public TextField withHeight(String height) {
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

    public TextField withLabel(String label) {
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

    public TextField withOcrConfidence(String ocrConfidence) {
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

    public TextField withOrientation(String orientation) {
        this.orientation = orientation;
        return this;
    }

    @JsonProperty("rawValue")
    public String getRawValue() {
        return rawValue;
    }

    @JsonProperty("rawValue")
    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }

    public TextField withRawValue(String rawValue) {
        this.rawValue = rawValue;
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

    public TextField withType(String type) {
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

    public TextField withValue(String value) {
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

    public TextField withWidth(String width) {
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

    public TextField withX(String x) {
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

    public TextField withY(String y) {
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

    public TextField withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
