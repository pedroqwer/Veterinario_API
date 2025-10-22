package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "historial_id")
    private HistorialMedico historialMedico;

    private String medicamento;

    private String dosis;

    private String duracion;

    private String instrucciones;

    @ManyToOne
    @JoinColumn(name = "emitido_por")
    private Usuario emitidoPor;
}

