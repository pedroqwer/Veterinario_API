package com.example.Veterinario.Model.Service.Autentication;

import com.example.Veterinario.Model.Entity.Usuario;

public interface IAuthenticationService {
    public Usuario signup(Usuario newUser);

    public String authenticate(Usuario user);
}
