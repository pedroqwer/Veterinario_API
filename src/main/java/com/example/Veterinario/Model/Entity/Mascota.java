package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil cliente;

    @NotBlank(message = "El nombre del animal no puede estar en blanco.")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La especie no puede estar en blanco.")
    @Column(nullable = false)
    private String especie;

    @NotBlank(message = "La raza no puede estar en blanco.")
    @Column(nullable = false)
    private String raza;

    @NotBlank(message = "El sexo no puede estar en blanco.")
    @Column(nullable = false)
    private String sexo;

    @NotBlank(message = "La fecha de nacimiento no puede estar en blanco.")
    @Column(nullable = false, name = "fecha de nacimiento")
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private boolean microchip;

    private String notas;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<Cita> citas;
}
