package com.example.Veterinario.Model.Repository.Mascota;

import com.example.Veterinario.Model.Entity.Mascota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IMascotaRepositoru extends CrudRepository<Mascota, Long> {
    @Query("SELECT mas from Mascota mas where mas.nombre =: nombre")
    List<Mascota> findAllByNombre(String nombre);

}
