package com.example.Veterinario.Model.Service.Prescripcion;

import com.example.Veterinario.Model.Entity.HistorialMedico;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Entity.Prescripcion;
import com.example.Veterinario.Model.Repository.HistorialMedico.IHistorialMedicoRepository;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import com.example.Veterinario.Model.Repository.Prescripcion.IRepositoriPrescripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescripcionService implements IPrescripcipnService{

    @Autowired
    private IHistorialMedicoRepository historialMedicoRepository;

    @Autowired
    private IRepositoryPerfil repositoryPerfil;

    @Autowired
    private IRepositoriPrescripcion repositoriPrescripcion;
    @Override
    public List<Prescripcion> getPrescripcion() {
        return (List<Prescripcion>) repositoriPrescripcion.findAll();
    }

    @Override
    public Prescripcion getPrescripcion(long id) {
        return repositoriPrescripcion.findById(id).get();
    }

    @Override
    public boolean addPrescripcion(String medicamrento, String disis, String duracion, String instrucciones, long id_emitido) {
        try {
            Optional<Perfil> optionalPerfil = repositoryPerfil.findById(id_emitido);
            
            Verificacion(optionalPerfil);

            Prescripcion prescripcion = new Prescripcion();
            prescripcion.setMedicamento(medicamrento);
            prescripcion.setDosis(disis);
            prescripcion.setDuracion(duracion);
            prescripcion.setInstrucciones(instrucciones);
            prescripcion.setEmitidoPor(optionalPerfil.get());

            repositoriPrescripcion.save(prescripcion);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    private boolean Verificacion(Optional<Perfil> optionalPerfil) {
        if (optionalPerfil.isEmpty()) {
            System.out.println("Falta historial médico y/o perfil");
        }
        return true;
    }

    @Override
    public boolean updatePrescripcion(String medicamrento, String disis, String duracion, String instrucciones, long id_emitido) {
        try {
            Optional<Perfil> optionalPerfil = repositoryPerfil.findById(id_emitido);

            Verificacion(optionalPerfil);

            Prescripcion prescripcion = new Prescripcion();
            prescripcion.setMedicamento(medicamrento);
            prescripcion.setDosis(disis);
            prescripcion.setDuracion(duracion);
            prescripcion.setInstrucciones(instrucciones);
            prescripcion.setEmitidoPor(optionalPerfil.get());

            repositoriPrescripcion.save(prescripcion);
            return true;

        }catch (Exception e){
            return false;
        }    }

    @Override
    public void deletePrescripcion(long id) {
        repositoriPrescripcion.deleteById(id);
    }
}
