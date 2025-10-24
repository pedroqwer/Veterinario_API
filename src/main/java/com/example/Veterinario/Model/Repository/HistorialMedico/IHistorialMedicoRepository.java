package com.example.Veterinario.Model.Repository.HistorialMedico;

import com.example.Veterinario.Model.Entity.HistorialMedico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistorialMedicoRepository extends CrudRepository<HistorialMedico, Long> {
}
