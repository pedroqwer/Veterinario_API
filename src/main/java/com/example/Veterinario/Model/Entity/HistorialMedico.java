package com.example.Veterinario.Model.Entity;

import com.example.Veterinario.Model.Entity.Mascota;
import com.example.Veterinario.Model.Entity.Perfil;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historiales_medicos")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Perfil veterinario;

    @Column(name = "fecha_visita")
    private LocalDateTime fechaVisita = LocalDateTime.now();

    private String resumen;

    private String diagnostico;

    private String notas;

    @Column(name = "archivos_json", columnDefinition = "TEXT")
    private String archivosJson;
}
