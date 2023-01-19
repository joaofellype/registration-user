package com.teste.civil.core.shared.validators;

import com.teste.civil.core.shared.exceptions.DomainException;

import java.util.List;

public class ListValidator {

    private ListValidator() {
        throw new IllegalStateException("List Validator");
    }

    public static <T> boolean isEmpty(List<T> lists) {
        return !((lists != null) && !lists.isEmpty());
    }

    public static <T> void isEmptyAndThrow(List<T> lists, String errorMessage) {
        if (isEmpty(lists))
            throw new DomainException(errorMessage);
    }
}
