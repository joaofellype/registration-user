package com.teste.civil.core.shared.validators;

import com.teste.civil.core.shared.exceptions.DomainException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.Set;

public class CustomValidator {

    private CustomValidator() {
        throw new IllegalStateException("Custom Validator");
    }

    public static void validateAndThrow(Object obj) {
        ObjectValidator.isNullAndThrow(obj, "Object validated is null");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);

        var errorMessages = new ArrayList<String>() {
        };
        for (ConstraintViolation<Object> violation : violations) {
            errorMessages.add(violation.getMessage());
        }

        if (!errorMessages.isEmpty())
            throw new DomainException(errorMessages);
    }
}
