package org.techdisqus.request;

import lombok.Data;

import java.util.Map;

@Data
public class Address {

    private String type;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String city;
    private String area;
    private String subArea;
    private Map<String, String> additionalAddressFields;
    private String postalCode;
}
