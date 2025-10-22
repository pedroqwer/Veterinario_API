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
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil cliente;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Perfil veterinario;

    @Column(nullable = false)
    private String estado;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @NotBlank(message = "El motivo no puede estar en blanco.")
    @Column(nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "creado_por")
    private Perfil creadoPor;
}

