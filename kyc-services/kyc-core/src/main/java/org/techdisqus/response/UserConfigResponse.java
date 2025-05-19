package org.techdisqus.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.techdisqus.request.AccountType;

import java.util.List;

@Data
@SuperBuilder
public class UserConfigResponse extends AbstractResponse{

    private List<AccountType> accountTypes;
}
