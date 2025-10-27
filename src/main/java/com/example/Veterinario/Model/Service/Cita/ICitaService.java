package com.example.Veterinario.Model.Service.Cita;

import com.example.Veterinario.Model.Entity.Cita;

import java.time.LocalDate;
import java.util.List;

public interface ICitaService {
    List<Cita> getCitas();
    Cita getCita(long id);
    boolean addCita(long idMascota, long id_Cliente, long id_Veterinario, String estado, LocalDate fechaInicio, LocalDate fechaFin,
                    String motivo, long id_recepcionista);
    boolean updateCita(long idMascota, long id_Cliente, long id_Veterinario, String estado, LocalDate fechaInicio, LocalDate fechaFin,
                       String motivo, long id_recepcionista);
    void deleteCita(long id);
    boolean FinalizarCita(long id);
    List<Cita> findAllByEstadoPendiente();
}
