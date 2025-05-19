
package org.techdisqus.dao.response.custom.attributes;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affectedRows"
})
@Generated("jsonschema2pojo")
public class UpdateApplicantCustomDetails {

    @JsonProperty("affectedRows")
    private Integer affectedRows;

    @JsonProperty("errors")
    private String[] errors;

    @JsonProperty("affectedRows")
    public Integer getAffectedRows() {
        return affectedRows;
    }

    @JsonProperty("affectedRows")
    public void setAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
    }

    public UpdateApplicantCustomDetails withAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
        return this;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }
}
