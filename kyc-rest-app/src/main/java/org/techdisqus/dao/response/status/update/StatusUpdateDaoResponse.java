
package org.techdisqus.dao.response.status.update;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.techdisqus.dao.response.BaseDaoResponse;
import org.techdisqus.dao.response.GraphQlError;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "errors"
})
@Generated("jsonschema2pojo")
public class StatusUpdateDaoResponse extends BaseDaoResponse {


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

    public StatusUpdateDaoResponse withData(Data data) {
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
