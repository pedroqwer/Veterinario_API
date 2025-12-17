package com.example.Veterinario.Model.Service.Perfil;

import com.example.Veterinario.Model.Entity.Perfil;

import java.time.LocalDateTime;
import java.util.List;

public interface IPerfilService {
    List<Perfil> findAll_USER_CLIENT();
    List<Perfil> findAll();
    Perfil obtenerPerfilporID(long id);
    void eliminarPerfil(long id);
    boolean actualizarPerfil(Perfil perfil);
    List<Perfil> findAllByDni(String dni);
    List<Perfil> findUsuariosByUltimoLoginReciente(LocalDateTime fechaLimite);

}
