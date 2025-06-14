package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entity {

    private String code;
    private String name;

}
