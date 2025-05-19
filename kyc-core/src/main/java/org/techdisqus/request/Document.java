package org.techdisqus.request;

import lombok.Data;

@Data
public class Document {

    private String image;
    private String type;
    private String name;
    private String location;
    private boolean isUploadedSuccessfully;
}
