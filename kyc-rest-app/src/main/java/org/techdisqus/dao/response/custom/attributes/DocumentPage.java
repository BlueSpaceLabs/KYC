
package org.techdisqus.dao.response.custom.attributes;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataBytes",
    "dataUrl",
    "format",
    "height",
    "imageFields",
    "orientation",
    "textFields",
    "type",
    "width",
    "x",
    "y"
})
@Generated("jsonschema2pojo")
public class DocumentPage {

    @JsonProperty("dataBytes")
    private String dataBytes;
    @JsonProperty("dataUrl")
    private String dataUrl;
    @JsonProperty("format")
    private String format;
    @JsonProperty("height")
    private String height;
    @JsonProperty("imageFields")
    private List<ImageField> imageFields;
    @JsonProperty("orientation")
    private String orientation;
    @JsonProperty("textFields")
    private List<TextField> textFields;
    @JsonProperty("type")
    private String type;
    @JsonProperty("width")
    private String width;
    @JsonProperty("x")
    private String x;
    @JsonProperty("y")
    private String y;
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

    public DocumentPage withDataBytes(String dataBytes) {
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

    public DocumentPage withDataUrl(String dataUrl) {
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

    public DocumentPage withFormat(String format) {
        this.format = format;
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

    public DocumentPage withHeight(String height) {
        this.height = height;
        return this;
    }

    @JsonProperty("imageFields")
    public List<ImageField> getImageFields() {
        return imageFields;
    }

    @JsonProperty("imageFields")
    public void setImageFields(List<ImageField> imageFields) {
        this.imageFields = imageFields;
    }

    public DocumentPage withImageFields(List<ImageField> imageFields) {
        this.imageFields = imageFields;
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

    public DocumentPage withOrientation(String orientation) {
        this.orientation = orientation;
        return this;
    }

    @JsonProperty("textFields")
    public List<TextField> getTextFields() {
        return textFields;
    }

    @JsonProperty("textFields")
    public void setTextFields(List<TextField> textFields) {
        this.textFields = textFields;
    }

    public DocumentPage withTextFields(List<TextField> textFields) {
        this.textFields = textFields;
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

    public DocumentPage withType(String type) {
        this.type = type;
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

    public DocumentPage withWidth(String width) {
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

    public DocumentPage withX(String x) {
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

    public DocumentPage withY(String y) {
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

    public DocumentPage withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
