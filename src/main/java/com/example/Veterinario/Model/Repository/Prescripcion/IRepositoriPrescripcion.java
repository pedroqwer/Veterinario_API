package com.example.Veterinario.Model.Repository.Prescripcion;

import com.example.Veterinario.Model.Entity.Prescripcion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoriPrescripcion extends CrudRepository<Prescripcion, Long> {
}
