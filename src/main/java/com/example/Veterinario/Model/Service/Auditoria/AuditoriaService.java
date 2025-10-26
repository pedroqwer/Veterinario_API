package com.example.Veterinario.Model.Service.Auditoria;

import com.example.Veterinario.Model.Entity.Auditoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaService implements IAuditoriaService {
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
}
