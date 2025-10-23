package com.example.Veterinario.Model.Service.Archivo;

import com.example.Veterinario.Model.Entity.Archivo;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Repository.Archivo.IArchivoRepositori;
import com.example.Veterinario.Model.Repository.Perfil.IRepositoryPerfil;
import com.example.Veterinario.Model.Service.UsuarioService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArchivoService implements IArchivoService{

    @Autowired
    private IArchivoRepositori archivoRepositorio;

    @Autowired
    private IRepositoryPerfil iRepositoryPerfil;

    @Override
    public boolean CrearArchivo(String nombre_Archivo, String ruta_Archivo, String tipoArchivo, long tamanoArchivo, long idUsuario) {
        try {

            Perfil idPerfil = iRepositoryPerfil.findById(idUsuario).orElseThrow();

            LocalDateTime fecha = LocalDateTime.now();

            Archivo archivo = new Archivo();
            archivo.setNombre(nombre_Archivo);
            archivo.setRuta(ruta_Archivo);
            archivo.setTamaño(tamanoArchivo);
            archivo.setSubidoPor(idPerfil);
            archivo.setTipoMime(tipoArchivo);
            archivo.setFechaSubida(fecha);

            archivoRepositorio.save(archivo);

            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void DeletarArchivo(long idArchivo) {
        archivoRepositorio.deleteById(idArchivo);
    }
}
