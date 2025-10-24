package com.example.Veterinario.Model.Service.HistorialMedico;

import com.example.Veterinario.Model.Entity.HistorialMedico;

import java.time.LocalDateTime;
import java.util.List;

public interface IHistorialMedicoService {
    List<HistorialMedico> listarHistorialMedico();
    HistorialMedico buscarHistorialMedico(long id);
    boolean agregarHistorialMedico(long id_Mascota, long id_Veterinario, LocalDateTime fechaVisita, String resumen,
                                   String diagnostico, String notas, String archivosJson);
    boolean actualizarHistorialMedico(long id_Mascota, long id_Veterinario, String resumen,
                                      String diagnostico, String notas, String archivosJson);
    void eliminarHistorialMedico(long id);
}
