
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
    "captureMode",
    "faceRectangle",
    "icaoAttributes",
    "icaoCropCoordinates",
    "image",
    "index",
    "photoRatio",
    "primary",
    "template"
})
@Generated("jsonschema2pojo")
public class Selfy {

    @JsonProperty("captureMode")
    private String captureMode;
    @JsonProperty("faceRectangle")
    private FaceRectangle faceRectangle;
    @JsonProperty("icaoAttributes")
    private IcaoAttributes icaoAttributes;
    @JsonProperty("icaoCropCoordinates")
    private IcaoAttributes icaoCropCoordinates;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("index")
    private String index;
    @JsonProperty("photoRatio")
    private String photoRatio;
    @JsonProperty("primary")
    private String primary;
    @JsonProperty("template")
    private Template template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("captureMode")
    public String getCaptureMode() {
        return captureMode;
    }

    @JsonProperty("captureMode")
    public void setCaptureMode(String captureMode) {
        this.captureMode = captureMode;
    }

    public Selfy withCaptureMode(String captureMode) {
        this.captureMode = captureMode;
        return this;
    }

    @JsonProperty("faceRectangle")
    public FaceRectangle getFaceRectangle() {
        return faceRectangle;
    }

    @JsonProperty("faceRectangle")
    public void setFaceRectangle(FaceRectangle faceRectangle) {
        this.faceRectangle = faceRectangle;
    }

    public Selfy withFaceRectangle(FaceRectangle faceRectangle) {
        this.faceRectangle = faceRectangle;
        return this;
    }

    @JsonProperty("icaoAttributes")
    public IcaoAttributes getIcaoAttributes() {
        return icaoAttributes;
    }

    @JsonProperty("icaoAttributes")
    public void setIcaoAttributes(IcaoAttributes icaoAttributes) {
        this.icaoAttributes = icaoAttributes;
    }

    public Selfy withIcaoAttributes(IcaoAttributes icaoAttributes) {
        this.icaoAttributes = icaoAttributes;
        return this;
    }

    @JsonProperty("icaoCropCoordinates")
    public IcaoAttributes getIcaoCropCoordinates() {
        return icaoCropCoordinates;
    }

    @JsonProperty("icaoCropCoordinates")
    public void setIcaoCropCoordinates(IcaoAttributes icaoCropCoordinates) {
        this.icaoCropCoordinates = icaoCropCoordinates;
    }

    public Selfy withIcaoCropCoordinates(IcaoAttributes icaoCropCoordinates) {
        this.icaoCropCoordinates = icaoCropCoordinates;
        return this;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    public Selfy withImage(Image image) {
        this.image = image;
        return this;
    }

    @JsonProperty("index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(String index) {
        this.index = index;
    }

    public Selfy withIndex(String index) {
        this.index = index;
        return this;
    }

    @JsonProperty("photoRatio")
    public String getPhotoRatio() {
        return photoRatio;
    }

    @JsonProperty("photoRatio")
    public void setPhotoRatio(String photoRatio) {
        this.photoRatio = photoRatio;
    }

    public Selfy withPhotoRatio(String photoRatio) {
        this.photoRatio = photoRatio;
        return this;
    }

    @JsonProperty("primary")
    public String getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Selfy withPrimary(String primary) {
        this.primary = primary;
        return this;
    }

    @JsonProperty("template")
    public Template getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(Template template) {
        this.template = template;
    }

    public Selfy withTemplate(Template template) {
        this.template = template;
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

    public Selfy withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
