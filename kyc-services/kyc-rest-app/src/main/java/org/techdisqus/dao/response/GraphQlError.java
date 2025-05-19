package org.techdisqus.dao.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "locations"
})
@Generated("jsonschema2pojo")
public class GraphQlError {
    @JsonProperty("message")
    private String message;
    @JsonProperty("locations")
    private List<Location> locations;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public GraphQlError withMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public GraphQlError withLocations(List<Location> locations) {
        this.locations = locations;
        return this;
    }

}
