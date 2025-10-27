package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "archivos")
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ruta;

    //.pdf .img
    private String tipoMime;

    private Long tamaño;

    private LocalDateTime fechaSubida;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "subido_por")
    private Perfil subidoPor;
}
