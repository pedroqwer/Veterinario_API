package com.example.Veterinario.Model.Service.UsuarioService;

import com.example.Veterinario.Model.Entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioService extends UserDetailsService {
    List<Usuario> findUsuariosActivos();
}
