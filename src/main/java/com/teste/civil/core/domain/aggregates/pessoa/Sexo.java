package com.teste.civil.core.domain.aggregates.pessoa;

import java.util.Arrays;

public enum Sexo {
    Masculino(1),
    Feminino(2);

    private final int type;

    Sexo(int type) {
        this.type = type;
    }

    public static Sexo fromString(String eventType) {

        var values = Sexo.values();

        var item = Arrays.stream(values)
                .filter(value -> value.name().equalsIgnoreCase(eventType))
                .toList();

        if (!item.isEmpty()) return item.get(0);

        return null;

    }


    public int getType() {
        return type;
    }

}
