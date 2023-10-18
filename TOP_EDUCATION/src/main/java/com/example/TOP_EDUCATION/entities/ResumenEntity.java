package com.example.TOP_EDUCATION.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resumenes") //Mapeo de la clase estudiante con la tabla estudiantes de la BD
@Data //getters y setters de lombok
@NoArgsConstructor
@AllArgsConstructor
public class ResumenEntity {
    @Id
    @Column(unique = true, nullable = false)
    private String rut_estudiante;

    private String nombre_estudiante;
    private int num_examenes;
    private double promedio_examenes;
    private double valor_total;
    private String tipo_pago;
    private int numCuotas;
    private int numCuotas_pagadas;
    private double valor_pagado;
    private String fecha_pago;
    private double saldoPorPagar;
    private int numCuotas_retraso;
}
