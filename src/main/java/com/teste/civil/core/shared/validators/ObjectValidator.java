package com.teste.civil.core.shared.validators;

import com.teste.civil.core.shared.exceptions.DomainException;

public class ObjectValidator {

    private ObjectValidator() {

        throw new IllegalStateException("Object Validator");
    }

    public static void isNullAndThrow(Object obj, String message) {

        if (obj == null) {

            throw new DomainException(message);
        }
    }
}
