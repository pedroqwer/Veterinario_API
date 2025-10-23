package com.example.Veterinario.Model.Service.Archivo;

import com.example.Veterinario.Model.Entity.Archivo;

import java.util.List;

public interface IArchivoService {

    /**Crear Archivo**/
    boolean CrearArchivo(String nombre_Archivo, String ruta_Archivo, String tipoArchivo, long tamanoArchivo, long idUsuario);
    /**Delete**/
    void DeletarArchivo(long idArchivo);
}
