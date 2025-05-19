
package org.techdisqus.dao.response.config;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.techdisqus.dao.response.GraphQlError;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data"
})
@Generated("jsonschema2pojo")
public class ConfigDataDaoResponse {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("errors")
    private List<GraphQlError> errors;

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    public ConfigDataDaoResponse withData(Data data) {
        this.data = data;
        return this;
    }

    public List<GraphQlError> getErrors() {
        return errors;
    }

    public void setErrors(List<GraphQlError> errors) {
        this.errors = errors;
    }

}
