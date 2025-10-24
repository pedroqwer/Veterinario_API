package com.example.Veterinario.Model.Repository.Vacunacion;

import com.example.Veterinario.Model.Entity.Vacunacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVacunaRepository extends CrudRepository<Vacunacion, Long> {
}
