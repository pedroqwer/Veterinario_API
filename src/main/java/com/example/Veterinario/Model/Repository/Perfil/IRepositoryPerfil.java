package com.example.Veterinario.Model.Repository.Perfil;

import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Entity.RoleType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryPerfil extends CrudRepository<Perfil, Long> {
    // Encuentra perfiles por rol
    List<Perfil> findByRolesIn(List<RoleType> roles);

    @Query("select p from Perfil p where p.dni =: dni")
    List<Perfil> findAllByDni(String dni);
}
