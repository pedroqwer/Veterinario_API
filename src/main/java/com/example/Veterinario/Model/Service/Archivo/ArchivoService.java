package com.example.Veterinario.Model.Service.Archivo;

import com.example.Veterinario.Model.Entity.Archivo;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Repository.Archivo.IArchivoRepositori;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArchivoService implements IArchivoService {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private IArchivoRepositori archivoRepositorio;

    @Autowired
    private IRepositoryPerfil iRepositoryPerfil;

    @Override
    public boolean subirArchivo(MultipartFile file, String nombre_Archivo, String ruta_Archivo, String tipoArchivo,
                                long tamanoArchivo, long idUsuario) {
        try {

            Perfil idPerfil = iRepositoryPerfil.findById(idUsuario).orElseThrow();

            LocalDateTime fecha = LocalDateTime.now();

            if (file.isEmpty()) {
                throw new RuntimeException("El archivo está vacío");
            }

            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            Path filePath = Paths.get(UPLOAD_DIR, ruta_Archivo, nombre_Archivo);
            Files.createDirectories(filePath.getParent()); // crear directorios si no existen

            // Guardar el archivo
            Files.write(filePath, file.getBytes());

            Archivo archivo = new Archivo();
            archivo.setNombre(nombre_Archivo);
            archivo.setRuta(filePath.toString());
            archivo.setTipoMime(file.getContentType());
            archivo.setTamaño(file.getSize());
            archivo.setSubidoPor(idPerfil);
            archivo.setFechaSubida(fecha);

            archivoRepositorio.save(archivo);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Archivo obtenerArchivoPorId(Long id) {
        return archivoRepositorio.findById(id).get();
    }


    public void eliminarArchivo(Long id) throws IOException {
        Archivo archivo = archivoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Archivo no encontrado"));

        // Eliminar archivo del sistema
        Path ruta = Paths.get(archivo.getRuta());
        if (Files.exists(ruta)) {
            Files.delete(ruta);
        }

        // Eliminar registro de la BD
        archivoRepositorio.deleteById(id);
    }

    @Override
    public List<Archivo> listarArchivos() {
        return (List<Archivo>) archivoRepositorio.findAll();
    }
}
