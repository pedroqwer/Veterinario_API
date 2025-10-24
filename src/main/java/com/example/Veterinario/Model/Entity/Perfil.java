package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Perfil")
public class Perfil extends Usuario{

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    @Size(min = 2, max = 30, message = "El nombre debe tener entre 2 y 30 caracteres")
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @Size(min = 2, max = 30, message = "El apellido debe tener entre 2 y 30 caracteres")
    private String apellido;

    @Column(unique = true, nullable = false, name = "dni")
    private String dni;

    @Column(unique = true, nullable = false, name = "email")
    private String email;

    @Column(unique = true, nullable = false, name = "telefono")
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;
}
