package com.example.Veterinario.Model.Service.Cita;

import com.example.Veterinario.Model.Entity.Cita;
import com.example.Veterinario.Model.Entity.Mascota;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Repository.Cita.ICitaRepository;
import com.example.Veterinario.Model.Repository.Mascota.IMascotaRepositoru;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService implements ICitaService{

    @Autowired
    private ICitaRepository citaRepository;

    @Autowired
    private IRepositoryPerfil perfilRepository;

    @Autowired
    IMascotaRepositoru imascotaRepositoru;

    @Override
    public List<Cita> getCitas() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public Cita getCita(long id) {
        return citaRepository.findById(id).get();
    }

    @Override
    public boolean addCita(long idMascota, long id_Cliente, long id_Veterinario, String estado, LocalDate fechaInicio, LocalDate fechaFin, String motivo, long id_recepcionista) {
        try {

            Optional<Perfil> perfilrecepcionosta = perfilRepository.findById(id_recepcionista);
            Optional<Perfil> perfilrCliente = perfilRepository.findById(id_Cliente);
            Optional<Perfil> perfilrVeterinario = perfilRepository.findById(id_Veterinario);
            Optional<Mascota> mascota = imascotaRepositoru.findById(idMascota);

            Verificacion(perfilrecepcionosta, perfilrCliente, perfilrVeterinario, mascota);

            Cita cita = new Cita();
            cita.setCliente(perfilrCliente.get());
            cita.setMascota(mascota.get());
            cita.setEstado(estado);
            cita.setCreadoPor(perfilrecepcionosta.get());
            cita.setFechaInicio(LocalDateTime.now());
            cita.setMotivo(motivo);
            cita.setVeterinario(perfilrVeterinario.get());

            citaRepository.save(cita);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCita(long idMascota, long id_Cliente, long id_Veterinario, String estado, LocalDate fechaInicio, LocalDate fechaFin, String motivo, long id_recepcionista) {
        try{

            Optional<Perfil> perfilrecepcionosta = perfilRepository.findById(id_recepcionista);
            Optional<Perfil> perfilrCliente = perfilRepository.findById(id_Cliente);
            Optional<Perfil> perfilrVeterinario = perfilRepository.findById(id_Veterinario);
            Optional<Mascota> mascota = imascotaRepositoru.findById(idMascota);

            Verificacion(perfilrecepcionosta, perfilrCliente, perfilrVeterinario, mascota);

            Cita cita = new Cita();
            cita.setCliente(perfilrCliente.get());
            cita.setMascota(mascota.get());
            cita.setEstado(estado);
            cita.setCreadoPor(perfilrecepcionosta.get());
            cita.setFechaInicio(LocalDateTime.now());
            cita.setMotivo(motivo);
            cita.setVeterinario(perfilrVeterinario.get());

            citaRepository.save(cita);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void deleteCita(long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public boolean FinalizarCita(long id) {
        try {
            Optional<Cita> optionalCita = citaRepository.findById(id);

            if (optionalCita.isPresent()) {
                Cita cita = optionalCita.get();
                cita.setEstado("Finalizada");
                cita.setFechaFin(LocalDateTime.now());
                citaRepository.save(cita);
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    @Override
    public List<Cita> findAllByEstadoPendiente() {
        return (List<Cita>) citaRepository.findAllByEstadoPendiente();
    }

    private boolean Verificacion(Optional<Perfil> perfilrecepcionosta, Optional<Perfil> perfilrCliente, Optional<Perfil> perfilrVeterinario, Optional<Mascota> mascota) {
        if (perfilrecepcionosta.isEmpty() && perfilrCliente.isEmpty() && perfilrVeterinario.isEmpty()) {
            System.out.println("Faltan datos para la cita");
            return false;
        }

        if(mascota.isEmpty()){
            System.out.println("Error al obtener la mascota");
            return false;
        }
        return true;
    }

}
