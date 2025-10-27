package com.example.Veterinario.Model.Repository.Vacunacion;

import com.example.Veterinario.Model.Entity.Vacunacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVacunaRepository extends CrudRepository<Vacunacion, Long> {

    @Query("SELECT v FROM Vacunacion v WHERE v.proximaDosis BETWEEN :hoy AND :hoy + 7")
    List<Vacunacion> findVacunasProximasAVencer(LocalDate hoy);
}
