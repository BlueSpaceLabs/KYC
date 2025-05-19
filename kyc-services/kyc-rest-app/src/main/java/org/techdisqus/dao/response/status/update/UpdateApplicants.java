
package org.techdisqus.dao.response.status.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affectedRows"
})
@Generated("jsonschema2pojo")
public class UpdateApplicants {

    @JsonProperty("affectedRows")
    private Integer affectedRows;

    @JsonProperty("affectedRows")
    public Integer getAffectedRows() {
        return affectedRows;
    }

    @JsonProperty("affectedRows")
    public void setAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
    }

    public UpdateApplicants withAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
        return this;
    }

}
