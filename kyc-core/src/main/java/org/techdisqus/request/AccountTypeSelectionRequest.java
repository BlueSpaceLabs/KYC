package org.techdisqus.request;

import lombok.Data;

@Data
public class AccountTypeSelectionRequest extends AbstractRequest{

    private AccountType accountType;


}
