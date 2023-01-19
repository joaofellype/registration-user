package com.teste.civil.core.domain.aggregates.pessoa;

import java.util.Arrays;

public enum TypeServidor {
    Temporario(1),
    Efetivo(2);


    private final int type;

    TypeServidor(int type) {
        this.type = type;
    }

    public static TypeServidor fromInt(int type) {

        var values = TypeServidor.values();

        var item = Arrays.stream(values)
                .filter(value -> value.getType() == type)
                .toList();

        if (!item.isEmpty()) return item.get(0);

        return null;

    }

    public int getType() {
        return type;
    }
}
