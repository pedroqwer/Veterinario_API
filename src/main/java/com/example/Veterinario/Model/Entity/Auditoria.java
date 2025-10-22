package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
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
    private Usuario usuario;

    private String accion;

    private String entidad;

    @Column(name = "id_entidad")
    private Long idEntidad;

    @Column(name = "fecha_accion")
    private LocalDateTime fechaAccion = LocalDateTime.now();

    @Column(name = "detalles_json", columnDefinition = "TEXT")
    private String detallesJson;
}

