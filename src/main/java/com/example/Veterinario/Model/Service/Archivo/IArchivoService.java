package com.example.Veterinario.Model.Service.Archivo;

import com.example.Veterinario.Model.Entity.Archivo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IArchivoService {

    boolean subirArchivo(String nombre_Archivo, String ruta_Archivo, String tipoArchivo,
                         long tamanoArchivo, long idUsuario,String contenido) throws IOException;
    Archivo obtenerArchivoPorId(Long id);
    void eliminarArchivo(Long id) throws IOException;
    List<Archivo> listarArchivos();
}
