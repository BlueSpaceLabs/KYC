
package org.techdisqus.dao.response.custom.attributes;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "updateApplicantCustomDetails"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("updateApplicantCustomDetails")
    private UpdateApplicantCustomDetails updateApplicantCustomDetails;

    @JsonProperty("updateApplicantCustomDetails")
    public UpdateApplicantCustomDetails getUpdateApplicantCustomDetails() {
        return updateApplicantCustomDetails;
    }

    @JsonProperty("updateApplicantCustomDetails")
    public void setUpdateApplicantCustomDetails(UpdateApplicantCustomDetails updateApplicantCustomDetails) {
        this.updateApplicantCustomDetails = updateApplicantCustomDetails;
    }

    public Data withUpdateApplicantCustomDetails(UpdateApplicantCustomDetails updateApplicantCustomDetails) {
        this.updateApplicantCustomDetails = updateApplicantCustomDetails;
        return this;
    }

}
