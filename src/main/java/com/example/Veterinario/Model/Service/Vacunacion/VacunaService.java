package com.example.Veterinario.Model.Service.Vacunacion;

import com.example.Veterinario.Model.Entity.Mascota;
import com.example.Veterinario.Model.Entity.Vacunacion;
import com.example.Veterinario.Model.Repository.Mascota.IMascotaRepositoru;
import com.example.Veterinario.Model.Repository.Vacunacion.IVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VacunaService implements IVacunaService {

    @Autowired
    private IMascotaRepositoru mascotaRepositoru;

    @Autowired
    private IVacunaRepository vacunaRepository;

    @Override
    public List<Vacunacion> getVacunacion() {
        return (List<Vacunacion>) vacunaRepository.findAll();
    }

    @Override
    public Vacunacion getVacunacion(long id) {
        return vacunaRepository.findById(id).get();
    }

    @Override
    public boolean addVacunacion(long id_Mascota, String nombreVacuna, LocalDate fechaAplicacion, LocalDate proximaDosis, String lote) {
        try {

            Optional<Mascota> mascota = mascotaRepositoru.findById(id_Mascota);
            if (mascota.isEmpty()) {
                System.out.println("Falta la mascota");
            }

            fechaAplicacion = LocalDate.now();

            Vacunacion vacunacion = new Vacunacion();
            vacunacion.setNombreVacuna(nombreVacuna);
            vacunacion.setFechaAplicacion(fechaAplicacion);
            vacunacion.setProximaDosis(proximaDosis);
            vacunacion.setLote(lote);
            vacunacion.setMascota(mascota.get());

            vacunaRepository.save(vacunacion);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateVacunacion(long id_Mascota, String nombreVacuna, LocalDate fechaAplicacion, LocalDate proximaDosis, String lote) {
        try {

            Optional<Mascota> mascota = mascotaRepositoru.findById(id_Mascota);
            if (mascota.isEmpty()) {
                System.out.println("Falta la mascota");
            }

            fechaAplicacion = LocalDate.now();

            Vacunacion vacunacion = new Vacunacion();
            vacunacion.setNombreVacuna(nombreVacuna);
            vacunacion.setFechaAplicacion(fechaAplicacion);
            vacunacion.setProximaDosis(proximaDosis);
            vacunacion.setLote(lote);
            vacunacion.setMascota(mascota.get());

            vacunaRepository.save(vacunacion);
            return true;
        }catch (Exception e){
            return false;
        }    }

    @Override
    public void deleteVacunacion(long id) {
        vacunaRepository.deleteById(id);
    }
}
