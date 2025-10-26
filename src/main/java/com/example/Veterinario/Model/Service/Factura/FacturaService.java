package com.example.Veterinario.Model.Service.Factura;

import ch.qos.logback.core.net.server.Client;
import com.example.Veterinario.Model.Entity.Factura;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Repository.Factura.IFacturaRepository;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import com.example.Veterinario.Model.Service.Perfil.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private IFacturaRepository facturaRepository;

    @Autowired
    private IRepositoryPerfil iRepositoryPerfil;

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }

    @Override
    public Factura findById(long id) {
        return facturaRepository.findById(id).get();
    }

    @Override
    public boolean save(long id_cliente, BigDecimal monto, String estado, LocalDate vencimiento, String itemJson, LocalDate fecha_pago) {
        try {
            Optional<Perfil> optionalClient = iRepositoryPerfil.findById(id_cliente);

            if(optionalClient.isEmpty()) {
                System.out.println("No se encontro el perfil");
            }

            Factura factura = new Factura();
            factura.setCliente(optionalClient.get());
            factura.setEstado(estado);
            factura.setFechaPago(fecha_pago);
            factura.setItemsJson(itemJson);
            factura.setMontoTotal(monto);
            factura.setFechaVencimiento(vencimiento);
            facturaRepository.save(factura);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(long id_cliente, BigDecimal monto, String estado, LocalDate vencimiento, String itemJson, LocalDate fecha_pago) {
        try {
            Optional<Perfil> optionalClient = iRepositoryPerfil.findById(id_cliente);

            if(optionalClient.isEmpty()) {
                System.out.println("No se encontro el perfil");
            }

            Factura factura = new Factura();
            factura.setCliente(optionalClient.get());
            factura.setEstado(estado);
            factura.setFechaPago(fecha_pago);
            factura.setItemsJson(itemJson);
            factura.setMontoTotal(monto);
            factura.setFechaVencimiento(vencimiento);
            facturaRepository.save(factura);
            return true;

        }catch (Exception e){
            return false;
        }    }

    @Override
    public void delete(long id) {

    }
}
