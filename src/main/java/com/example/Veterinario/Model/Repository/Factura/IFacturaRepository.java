package com.example.Veterinario.Model.Repository.Factura;

import com.example.Veterinario.Model.Entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacturaRepository extends CrudRepository<Factura, Long> {
    @Query("SELECT f FROM Factura f WHERE f.cliente.id = :clienteId")
    List<Factura> findByClienteId(long clienteId);
}
