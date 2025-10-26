package com.example.Veterinario.Model.Service.Inventario;

import com.example.Veterinario.Model.Entity.Inventario;
import com.example.Veterinario.Model.Repository.Inventario.IInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioService implements IInventarioService {

    @Autowired
    private IInventarioRepository IInventarioRepository;

    @Override
    public List<Inventario> getInventario() {
        return (List<Inventario>) IInventarioRepository.findAll();
    }

    @Override
    public Inventario getInventarioById(long id) {
        return IInventarioRepository.findById(id).get();
    }

    @Override
    public boolean addInventario(Inventario inventario) {
        try {
            Inventario newInventario = new Inventario();
            newInventario.setNombre(inventario.getNombre());
            newInventario.setCodigo(inventario.getCodigo());
            newInventario.setCantidadDisponible(inventario.getCantidadDisponible());
            newInventario.setUltimaActualizacion(inventario.getUltimaActualizacion());
            newInventario.setMinimoAlerta(inventario.getMinimoAlerta());
            IInventarioRepository.save(newInventario);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateInventario(Inventario inventario) {
        try {
            Inventario newInventario = new Inventario();
            newInventario.setNombre(inventario.getNombre());
            newInventario.setCodigo(inventario.getCodigo());
            newInventario.setCantidadDisponible(inventario.getCantidadDisponible());
            newInventario.setUltimaActualizacion(inventario.getUltimaActualizacion());
            newInventario.setMinimoAlerta(inventario.getMinimoAlerta());
            IInventarioRepository.save(newInventario);
            return true;
        }catch (Exception e){
            return false;
        }    }

    @Override
    public void deleteInventario(long id) {
        IInventarioRepository.deleteById(id);
    }

    @Override
    public List<Inventario> obtenerProductosConBajoStock() {
        //return inventarioRepository.findByCantidadDisponibleLessThanMinimoAlerta();
        return List.of();
    }
}
