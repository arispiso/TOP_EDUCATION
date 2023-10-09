package com.example.TOP_EDUCATION.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "examenes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExamenEntity {
    @Id
    @Column(unique = true, nullable = false)
    private int id;

    private int puntaje;
    private Date fecha_examen;
    private String rut_estudiante;
}
