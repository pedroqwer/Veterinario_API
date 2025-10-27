package com.example.Veterinario.Model.Service.Mascota;

import com.example.Veterinario.Model.Entity.Cita;
import com.example.Veterinario.Model.Entity.Mascota;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IMascotasService {
    List<Mascota> getMascotas();
    Mascota getMascotaID(long id);
    boolean addMascota(String nombre, String especie, String raza, String sexo, LocalDate fechaNacimiento, boolean microchip, String notas, long id_Cliente);
    boolean updateMascota(String nombre, String especie, String raza, String sexo, LocalDate fechaNacimiento,
                          boolean microchip, String notas, long id_Cliente);
    void deleteMascota(long id);
    List<Mascota> findAllByNombre(String nombre);

}
