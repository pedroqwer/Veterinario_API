package com.example.Veterinario.Model.Service.Vacunacion;

import com.example.Veterinario.Model.Entity.Vacunacion;

import java.time.LocalDate;
import java.util.List;

public interface IVacunaService {
    List<Vacunacion> getVacunacion();
    Vacunacion getVacunacion(long id);
    boolean addVacunacion(long id_Mascota, String nombreVacuna, LocalDate fechaAplicacion,
                             LocalDate proximaDosis,String lote);
    boolean updateVacunacion(long id_Mascota, String nombreVacuna, LocalDate fechaAplicacion,
                                LocalDate proximaDosis,String lote);
    void deleteVacunacion(long id);
}
