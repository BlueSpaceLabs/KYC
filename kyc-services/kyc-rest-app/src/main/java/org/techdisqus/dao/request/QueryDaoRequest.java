package org.techdisqus.dao.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class QueryDaoRequest  {

    @JsonProperty("query")
    private String query;

    @JsonProperty("variables")
    private Map<String, Object> variables;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
