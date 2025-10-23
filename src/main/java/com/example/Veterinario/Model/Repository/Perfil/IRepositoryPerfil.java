package com.example.Veterinario.Model.Repository.Perfil;

import com.example.Veterinario.Model.Entity.Perfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryPerfil extends CrudRepository<Perfil, Long> {
    // Encuentra perfiles por rol
    List<Perfil> findByRolIn(List<String> roles);
}
