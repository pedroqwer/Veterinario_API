package com.example.Veterinario.Model.Repository.Archivo;

import com.example.Veterinario.Model.Entity.Archivo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArchivoRepositori extends CrudRepository<Archivo, Long> {
    @Query("SELECT a FROM Archivo a WHERE a.subidoPor.id = :usuarioId")
    List<Archivo> findArchivosByUsuarioId(long usuarioId);
}
