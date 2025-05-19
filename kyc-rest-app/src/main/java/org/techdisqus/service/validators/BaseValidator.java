package org.techdisqus.service.validators;

import com.innovatrics.dot.integrationsamples.disapi.model.GetCustomerResponse;

import java.util.Objects;

public abstract class BaseValidator {

    protected static boolean isCustomerNull(GetCustomerResponse response){
        return Objects.isNull(response) || Objects.isNull(response.getCustomer());
    }
}
