package com.example.Veterinario.Model.Entity;

import lombok.Getter;

@Getter
public enum RoleType {
    ADMIN(1),
    VETERINARIO(2),
    RECEPCIONISTA(3),
    CLIENTE(4),
    USUARIO(5);

    private int value;

    RoleType(int value) {
        this.value = value;
    }
}
