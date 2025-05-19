package org.techdisqus.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.techdisqus.request.AccountType;

@Data
@SuperBuilder
public class AccountTypeSelectionResponse extends AbstractResponse{
    private AccountType accountType;
}
