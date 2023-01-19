package com.teste.civil.core.shared.exceptions;

import java.util.ArrayList;
import java.util.List;

public class DomainException extends RuntimeException {

    private final List<String> errorMessages;

    public DomainException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public DomainException(String message) {
        this.errorMessages = new ArrayList<>();
        this.errorMessages.add(message);
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
