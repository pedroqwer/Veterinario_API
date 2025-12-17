package com.example.Veterinario.Model.Service.Auditoria;

import com.example.Veterinario.Model.Entity.Auditoria;

import java.util.List;

public interface IAuditoriaService {
    List<Auditoria> getAll();
    Auditoria getById(long id);
    boolean add(long id_User, String accion, String entidad, String detalles);
    void delete(long id);
    List<Auditoria> findAllByUsuario(long id_User);
    List<Auditoria> findAllByEntidad(String entidad);
}
