package org.techdisqus.service.validators;

import org.techdisqus.util.Result;

public interface Validator<T> {

    Result<Boolean> validate(T obj);
}
