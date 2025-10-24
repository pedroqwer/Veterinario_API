package com.example.Veterinario.Model.Repository.Mascota;

import com.example.Veterinario.Model.Entity.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepositoru extends CrudRepository<Mascota, Long> {
}
