package com.example.Veterinario.Model.Service.UsuarioService;

import com.example.Veterinario.Model.Entity.Rol;
import com.example.Veterinario.Model.Repository.Role.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Autowired
    IRolRepository roleRepository;

    @Override
    public List<Rol> obtenerRolesByNombre(List<Integer> nombre) {
        return roleRepository.findByNombreIn(nombre);
    }
}
