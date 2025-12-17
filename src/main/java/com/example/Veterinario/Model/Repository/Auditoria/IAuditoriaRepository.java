package com.example.Veterinario.Model.Repository.Auditoria;

import com.example.Veterinario.Model.Entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuditoriaRepository extends CrudRepository<Auditoria, Integer> {
    @Query("select a from Auditoria a where  a.usuario =: id_User")
    List<Auditoria> findAllByUsuario(long id_User);

    @Query("select a from Auditoria a where a.entidad =: entidad")
    List<Auditoria> findAllByEntidad(String entidad);
}
