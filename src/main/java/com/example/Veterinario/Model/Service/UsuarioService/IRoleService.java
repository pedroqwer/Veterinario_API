package com.example.Veterinario.Model.Service.UsuarioService;

import com.example.Veterinario.Model.Entity.Rol;

import java.util.List;

public interface IRoleService {
    List<Rol> obtenerRolesByNombre(List<Integer> nombre);
}
