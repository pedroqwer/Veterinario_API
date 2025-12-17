package com.example.Veterinario.Model.Service.Auditoria;

import com.example.Veterinario.Model.Entity.Auditoria;
import com.example.Veterinario.Model.Repository.Auditoria.IAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaService implements IAuditoriaService {

    @Autowired
    private IAuditoriaRepository auditoriaRepository;

    @Override
    public List<Auditoria> getAll() {
        return List.of();
    }

    @Override
    public Auditoria getById(long id) {
        return null;
    }

    @Override
    public boolean add(long id_User, String accion, String entidad, String detalles) {
        return false;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Auditoria> findAllByUsuario(long id_User) {
        return (List<Auditoria>) auditoriaRepository.findAllByUsuario(id_User);
    }

    @Override
    public List<Auditoria> findAllByEntidad(String entidad) {
        return (List<Auditoria>) auditoriaRepository.findAllByEntidad(entidad);
    }
}
