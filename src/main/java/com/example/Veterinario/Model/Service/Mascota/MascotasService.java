package com.example.Veterinario.Model.Service.Mascota;

import com.example.Veterinario.Model.Entity.Mascota;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Repository.Cita.ICitaRepository;
import com.example.Veterinario.Model.Repository.Mascota.IMascotaRepositoru;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import com.example.Veterinario.Model.Service.Cita.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MascotasService implements IMascotasService{

    @Autowired
    private IMascotaRepositoru mascotaRepositoru;

    @Autowired
    private IRepositoryPerfil repositoryPerfil;

    @Override
    public List<Mascota> getMascotas() {
        return (List<Mascota>) mascotaRepositoru.findAll();
    }

    @Override
    public Mascota getMascotaID(long id) {
        return mascotaRepositoru.findById(id).get();
    }

    @Override
    public boolean addMascota(String nombre, String especie, String raza, String sexo, LocalDate fechaNacimiento,
                              boolean microchip, String notas, long id_Cliente) {
        try {

            Optional<Perfil> perfil= repositoryPerfil.findById(id_Cliente);
            if (perfil.isEmpty()) {
                System.out.println("⚠️ Cliente no encontrado con ID: " + id_Cliente);
                return false;
            }

            Mascota mascota = new Mascota();
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setSexo(sexo);
            mascota.setFechaNacimiento(fechaNacimiento);
            mascota.setMicrochip(microchip);
            mascota.setNotas(notas);

            mascotaRepositoru.save(mascota);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateMascota(String nombre, String especie, String raza, String sexo, LocalDate fechaNacimiento,
                                 boolean microchip, String notas, long id_Cliente) {
        try {
            Optional<Perfil> perfil = repositoryPerfil.findById(id_Cliente);
            if (perfil.isEmpty()) {
                System.out.println("⚠️ Cliente no encontrado con ID: " + id_Cliente);
                return false;
            }
            Mascota mascota = new Mascota();
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setSexo(sexo);
            mascota.setFechaNacimiento(fechaNacimiento);
            mascota.setMicrochip(microchip);
            mascota.setNotas(notas);
            mascota.setId(id_Cliente);

            mascotaRepositoru.save(mascota);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void deleteMascota(long id) {
        mascotaRepositoru.deleteById(id);
    }
}
