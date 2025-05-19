
package org.techdisqus.dao.response.config;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "code",
    "codeValues"
})
@Generated("jsonschema2pojo")
public class CodeDef {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("code")
    private String code;
    @JsonProperty("codeValues")
    private List<CodeValue> codeValues;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public CodeDef withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public CodeDef withCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("codeValues")
    public List<CodeValue> getCodeValues() {
        return codeValues;
    }

    @JsonProperty("codeValues")
    public void setCodeValues(List<CodeValue> codeValues) {
        this.codeValues = codeValues;
    }

    public CodeDef withCodeValues(List<CodeValue> codeValues) {
        this.codeValues = codeValues;
        return this;
    }

}
