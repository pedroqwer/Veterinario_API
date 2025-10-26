package com.example.Veterinario.Model.Repository.Factura;

import com.example.Veterinario.Model.Entity.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepository extends CrudRepository<Factura, Long> {
}
