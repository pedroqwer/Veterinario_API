package com.example.Veterinario.Model.Service.Inventario;

import com.example.Veterinario.Model.Entity.Inventario;

import java.util.List;

public interface IInventarioService {
    List<Inventario> getInventario();
    Inventario getInventarioById(long id);
    boolean addInventario(Inventario inventario);
    boolean updateInventario(Inventario inventario);
    void deleteInventario(long id);
    List<Inventario> obtenerProductosConBajoStock();
}
