package com.example.Veterinario.Model.Entity;

public enum Tipo {
    ADMIN(1),
    VETERINARIO(2),
    RECEPCIONISTA(3),
    CLIENTE(4),
    USUARIO(5);

    private final int value;

    Tipo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Método para obtener un Tipo desde un número
    public static Tipo fromInt(int value) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.getValue() == value) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo inválido: " + value);
    }
}
