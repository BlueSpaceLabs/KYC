
package org.techdisqus.dao.response.custom.attributes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomDetailsDaoRequest {

    @JsonProperty("customDetails")
    private CustomDetails customDetails;

    public CustomDetails getCustomDetails() {
        return customDetails;
    }

    public void setCustomDetails(CustomDetails customDetails) {
        this.customDetails = customDetails;
    }
}
