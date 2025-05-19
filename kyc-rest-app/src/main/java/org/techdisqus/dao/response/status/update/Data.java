
package org.techdisqus.dao.response.status.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "updateApplicants"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("updateApplicants")
    private UpdateApplicants updateApplicants;

    public UpdateApplicants getUpdateApplicants() {
        return updateApplicants;
    }

    public void setUpdateApplicants(UpdateApplicants updateApplicants) {
        this.updateApplicants = updateApplicants;
    }
}
