package com.example.Veterinario.Model.Service.Archivo;

import com.example.Veterinario.Model.Entity.Archivo;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Repository.Archivo.IArchivoRepositori;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArchivoService implements IArchivoService {

    @Autowired
    private IArchivoRepositori archivoRepositorio;

    @Autowired
    private IRepositoryPerfil iRepositoryPerfil;

    @Override
    public boolean subirArchivo(String nombre_Archivo, String ruta_Archivo, String tipoArchivo,
                                long tamanoArchivo, long idUsuario, String contenido) {
        try {

            Perfil idPerfil = iRepositoryPerfil.findById(idUsuario).orElseThrow();

            LocalDateTime fecha = LocalDateTime.now();

            File carpeta = new File(ruta_Archivo, "Carpeta_Archivos");
            if (carpeta.exists()) {
                System.out.println("Carpeta existente");
            }else {
                carpeta.mkdir();
                File ficheroCrear = new File(carpeta ,nombre_Archivo+".txt");
                if (ficheroCrear.exists()) {
                    System.out.println("Fichero existente");
                }else {
                    ficheroCrear.createNewFile();

                    Path path = ficheroCrear.toPath();
                    String tipoMime = Files.probeContentType(path);
                    long tamanoReal = Files.size(path);

                    Archivo archivo = new Archivo();
                    archivo.setNombre(nombre_Archivo);
                    archivo.setRuta(ficheroCrear.getAbsolutePath());
                    archivo.setTipoMime(tipoMime);
                    archivo.setTamaño(tamanoReal);
                    archivo.setSubidoPor(idPerfil);
                    archivo.setFechaSubida(fecha);
                    archivo.setContenido(contenido);
                    archivoRepositorio.save(archivo);

                    try (BufferedWriter bf = new BufferedWriter(new FileWriter(ficheroCrear))) {
                        bf.write(nombre_Archivo);
                        bf.newLine();
                        bf.write(ruta_Archivo);
                        bf.newLine();
                        bf.write(tipoMime);
                        bf.newLine();
                        bf.write((int) tamanoReal);
                        bf.newLine();
                        bf.write(contenido);
                    }catch (Exception e){

                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void CrearArchivo(File ficheroCrear) {
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

    @Override
    public List<Archivo> findArchivosByUsuarioId(long usuarioId) {
        return (List<Archivo>) archivoRepositorio.findArchivosByUsuarioId(usuarioId);
    }
}
