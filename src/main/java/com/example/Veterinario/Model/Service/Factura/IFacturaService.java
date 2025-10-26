package com.example.Veterinario.Model.Service.Factura;

import com.example.Veterinario.Model.Entity.Factura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IFacturaService {
    List<Factura> findAll();
    Factura findById(long id);
    boolean save(long id_cliente, BigDecimal monto, String estado,
                 LocalDate vencimiento, String itemJson, LocalDate fecha_pago);
    boolean update(long id_cliente, BigDecimal monto, String estado,
                   LocalDate vencimiento, String itemJson, LocalDate fecha_pago);
    void delete(long id);
}
