package com.example.Veterinario.Model.Repository.Usuario;

import com.example.Veterinario.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>
{
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE u.activo = true")
    List<Usuario> findUsuariosActivos();
}