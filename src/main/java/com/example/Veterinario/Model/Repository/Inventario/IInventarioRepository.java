package com.example.Veterinario.Model.Repository.Inventario;

import com.example.Veterinario.Model.Entity.Inventario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepository extends CrudRepository<Inventario, Long> {
}
