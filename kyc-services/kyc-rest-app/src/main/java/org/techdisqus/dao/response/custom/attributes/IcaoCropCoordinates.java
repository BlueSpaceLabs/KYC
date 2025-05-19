
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
    "bottomLeft",
    "bottomRight",
    "topLeft",
    "topRight"
})
@Generated("jsonschema2pojo")
public class IcaoCropCoordinates {

    @JsonProperty("bottomLeft")
    private BottomLeft bottomLeft;
    @JsonProperty("bottomRight")
    private BottomRight bottomRight;
    @JsonProperty("topLeft")
    private TopLeft topLeft;
    @JsonProperty("topRight")
    private TopRight topRight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("bottomLeft")
    public BottomLeft getBottomLeft() {
        return bottomLeft;
    }

    @JsonProperty("bottomLeft")
    public void setBottomLeft(BottomLeft bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public IcaoCropCoordinates withBottomLeft(BottomLeft bottomLeft) {
        this.bottomLeft = bottomLeft;
        return this;
    }

    @JsonProperty("bottomRight")
    public BottomRight getBottomRight() {
        return bottomRight;
    }

    @JsonProperty("bottomRight")
    public void setBottomRight(BottomRight bottomRight) {
        this.bottomRight = bottomRight;
    }

    public IcaoCropCoordinates withBottomRight(BottomRight bottomRight) {
        this.bottomRight = bottomRight;
        return this;
    }

    @JsonProperty("topLeft")
    public TopLeft getTopLeft() {
        return topLeft;
    }

    @JsonProperty("topLeft")
    public void setTopLeft(TopLeft topLeft) {
        this.topLeft = topLeft;
    }

    public IcaoCropCoordinates withTopLeft(TopLeft topLeft) {
        this.topLeft = topLeft;
        return this;
    }

    @JsonProperty("topRight")
    public TopRight getTopRight() {
        return topRight;
    }

    @JsonProperty("topRight")
    public void setTopRight(TopRight topRight) {
        this.topRight = topRight;
    }

    public IcaoCropCoordinates withTopRight(TopRight topRight) {
        this.topRight = topRight;
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

    public IcaoCropCoordinates withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
