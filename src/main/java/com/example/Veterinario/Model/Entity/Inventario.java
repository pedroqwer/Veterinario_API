package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El medicamento no puede estar en blanco.")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El medicamento no puede estar en blanco.")
    @Column(nullable = false)
    private String codigo;

    @Column(name = "cantidad_disponible")
    private Integer cantidadDisponible;

    @Column(name = "minimo_alerta")
    private Integer minimoAlerta;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion = LocalDateTime.now();
}
