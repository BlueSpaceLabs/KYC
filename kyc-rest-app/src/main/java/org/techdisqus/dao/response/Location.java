
package org.techdisqus.dao.response;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "line",
    "column"
})
@Generated("jsonschema2pojo")
public class Location {

    @JsonProperty("line")
    private Integer line;
    @JsonProperty("column")
    private Integer column;

    @JsonProperty("line")
    public Integer getLine() {
        return line;
    }

    @JsonProperty("line")
    public void setLine(Integer line) {
        this.line = line;
    }

    public Location withLine(Integer line) {
        this.line = line;
        return this;
    }

    @JsonProperty("column")
    public Integer getColumn() {
        return column;
    }

    @JsonProperty("column")
    public void setColumn(Integer column) {
        this.column = column;
    }

    public Location withColumn(Integer column) {
        this.column = column;
        return this;
    }

}
