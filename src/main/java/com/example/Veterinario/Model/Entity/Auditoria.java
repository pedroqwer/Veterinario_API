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
@Table(name = "auditorias")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Perfil usuario;

    @NotBlank(message = "La acción no puede estar en blanco.")
    @Column(nullable = false)
    private String accion;

    @NotBlank(message = "La entidad no puede estar en blanco.")
    @Column(nullable = false)
    private String entidad;

    @Column(name = "fecha_accion")
    private LocalDateTime fechaAccion = LocalDateTime.now();

    @Column(name = "detalles_json", columnDefinition = "TEXT")
    private String detallesJson;
}

