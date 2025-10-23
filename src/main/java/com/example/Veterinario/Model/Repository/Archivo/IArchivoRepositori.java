package com.example.Veterinario.Model.Repository.Archivo;

import com.example.Veterinario.Model.Entity.Archivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArchivoRepositori extends CrudRepository<Archivo, Long> {
}
