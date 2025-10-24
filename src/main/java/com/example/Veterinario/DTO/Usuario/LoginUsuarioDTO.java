package com.example.Veterinario.DTO.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUsuarioDTO implements Serializable {
    public String username;
    public String password;
}