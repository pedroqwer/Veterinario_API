package com.example.Veterinario.Model.Repository.Cita;

import com.example.Veterinario.Model.Entity.Cita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends CrudRepository<Cita, Long> {
}
