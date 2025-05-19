package org.techdisqus.request;

import lombok.Data;

@Data
public class Consent {

    private String consentType;
    private boolean consentGiven;

}
