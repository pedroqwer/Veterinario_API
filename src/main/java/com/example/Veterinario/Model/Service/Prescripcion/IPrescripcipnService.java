package com.example.Veterinario.Model.Service.Prescripcion;

import com.example.Veterinario.Model.Entity.Prescripcion;

import java.util.List;

public interface IPrescripcipnService {
    List<Prescripcion> getPrescripcion();
    Prescripcion getPrescripcion(long id);
    boolean addPrescripcion(String medicamrento, String disis, String duracion,
                            String instrucciones, long id_emitido);
    boolean updatePrescripcion(String medicamrento, String disis, String duracion,
                               String instrucciones, long id_emitido);
    void deletePrescripcion(long id);
}
