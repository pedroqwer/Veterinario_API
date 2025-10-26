package com.example.Veterinario.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Perfil cliente;

    @Column(name = "monto_total", nullable = false)
    private BigDecimal montoTotal;

    private String estado;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "items_json", columnDefinition = "TEXT")
    private String itemsJson;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;
}
