package com.example.Veterinario.Model.Service.Perfil;

import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Entity.RoleType;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import io.jsonwebtoken.lang.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService implements IPerfilService{

    @Autowired
    private IRepositoryPerfil repositoryPerfil;

    @Override
    public List<Perfil> findAll_USER_CLIENT() {
        return repositoryPerfil.findByRolesIn(Arrays.asList(new RoleType[]{RoleType.CLIENTE , RoleType.USUARIO}));
    }

    @Override
    public List<Perfil> findAll() {
        return (List<Perfil>) repositoryPerfil.findAll();
    }

    @Override
    public Perfil obtenerPerfilporID(long id) {
        return repositoryPerfil.findById(id).get();
    }

    @Override
    public void eliminarPerfil(long id) {
        repositoryPerfil.deleteById(id);
    }

    @Override
    public boolean actualizarPerfil(Perfil perfil) {
        try {
            Perfil perfil1 = repositoryPerfil.findById(perfil.getId()).get();
            perfil1.setNombre(perfil.getNombre());
            perfil1.setApellido(perfil.getApellido());
            perfil1.setEmail(perfil.getEmail());
            perfil1.setTelefono(perfil.getTelefono());
            repositoryPerfil.save(perfil1);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
