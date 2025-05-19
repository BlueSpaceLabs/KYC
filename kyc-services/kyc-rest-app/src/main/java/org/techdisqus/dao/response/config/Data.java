
package org.techdisqus.dao.response.config;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codeDefs"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("codeDefs")
    private List<CodeDef> codeDefs;

    @JsonProperty("codeDefs")
    public List<CodeDef> getCodeDefs() {
        return codeDefs;
    }

    @JsonProperty("codeDefs")
    public void setCodeDefs(List<CodeDef> codeDefs) {
        this.codeDefs = codeDefs;
    }

    public Data withCodeDefs(List<CodeDef> codeDefs) {
        this.codeDefs = codeDefs;
        return this;
    }

}
