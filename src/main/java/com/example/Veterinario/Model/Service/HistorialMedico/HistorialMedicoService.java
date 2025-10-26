package com.example.Veterinario.Model.Service.HistorialMedico;

import com.example.Veterinario.Model.Entity.HistorialMedico;
import com.example.Veterinario.Model.Entity.Mascota;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Entity.Prescripcion;
import com.example.Veterinario.Model.Repository.HistorialMedico.IHistorialMedicoRepository;
import com.example.Veterinario.Model.Repository.Mascota.IMascotaRepositoru;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import com.example.Veterinario.Model.Repository.Prescripcion.IRepositoriPrescripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService implements IHistorialMedicoService {

    @Autowired
    private IMascotaRepositoru mascotaRepositoru;

    @Autowired
    private IRepositoryPerfil repositoryPerfil;

    @Autowired
    private IHistorialMedicoRepository historialMedicoRepository;

    @Autowired
    private IRepositoriPrescripcion repositoriPrescripcion;
    @Override
    public List<HistorialMedico> listarHistorialMedico() {
        return (List<HistorialMedico>) historialMedicoRepository.findAll();
    }

    @Override
    public HistorialMedico buscarHistorialMedico(long id) {
        return historialMedicoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean agregarHistorialMedico(long id_Mascota, long id_Veterinario, LocalDateTime fechaVisita,
                                          String resumen, String diagnostico, String notas, String archivosJson,long prescripcion) {
        try {
            Optional<Perfil> optionalPerfil = repositoryPerfil.findById(id_Mascota);
            Optional<Mascota> optionalMascota = mascotaRepositoru.findById(id_Veterinario);
            Optional<Prescripcion> optionalPrescripcion = repositoriPrescripcion.findById(prescripcion);

            Verificacion(optionalPerfil, optionalMascota, optionalPrescripcion);

            fechaVisita = LocalDateTime.now();

            HistorialMedico historialMedico = new HistorialMedico();
            historialMedico.setNotas(notas);
            historialMedico.setDiagnostico(diagnostico);
            historialMedico.setResumen(resumen);
            historialMedico.setFechaVisita(fechaVisita);
            historialMedico.setArchivosJson(archivosJson);
            historialMedico.setMascota(optionalMascota.get());
            historialMedico.setVeterinario(optionalPerfil.get());
            historialMedico.setPrescripcion(optionalPrescripcion.get());

            historialMedicoRepository.save(historialMedico);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean actualizarHistorialMedico(long id_Mascota, long id_Veterinario, String resumen,
                                             String diagnostico, String notas, String archivosJson, long prescripcion) {
        try {
            Optional<Perfil> optionalPerfil = repositoryPerfil.findById(id_Mascota);
            Optional<Mascota> optionalMascota = mascotaRepositoru.findById(id_Veterinario);
            Optional<Prescripcion> optionalPrescripcion = repositoriPrescripcion.findById(prescripcion);

            Verificacion(optionalPerfil, optionalMascota, optionalPrescripcion);

            HistorialMedico historialMedico = new HistorialMedico();
            historialMedico.setNotas(notas);
            historialMedico.setDiagnostico(diagnostico);
            historialMedico.setResumen(resumen);
            historialMedico.setArchivosJson(archivosJson);
            historialMedico.setMascota(optionalMascota.get());
            historialMedico.setVeterinario(optionalPerfil.get());
            historialMedico.setPrescripcion(optionalPrescripcion.get());

            historialMedicoRepository.save(historialMedico);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void eliminarHistorialMedico(long id) {
        historialMedicoRepository.deleteById(id);
    }

    private boolean Verificacion(Optional<Perfil> optionalPerfil, Optional<Mascota> optionalMascota, Optional<Prescripcion> optionalPrescripcion) {
        if (optionalPerfil.isPresent() && optionalMascota.isPresent()) {
            System.out.println("Faltan el veterinario o mascota o prescipción");
            return false;
        }
        return true;
    }

}
