package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prescripciones")
public class Prescripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El medicamento no puede estar en blanco.")
    @Column(nullable = false)
    private String medicamento;

    @NotBlank(message = "La dosis no puede estar en blanco.")
    @Column(nullable = false)
    private String dosis;

    @NotBlank(message = "La duración no puede estar en blanco.")
    @Column(nullable = false)
    private String duracion;

    @NotBlank(message = "La instrucciones no puede estar en blanco.")
    @Column(nullable = false)
    private String instrucciones;

    @ManyToOne
    @JoinColumn(name = "emitido_por")
    private Perfil emitidoPor;
}

