package com.example.Veterinario.Model.Repository.Cita;

import com.example.Veterinario.Model.Entity.Cita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitaRepository extends CrudRepository<Cita, Long> {
    @Query("select c from Cita c where c.estado = 'pendiente'")
    List<Cita> findAllByEstadoPendiente();
}
