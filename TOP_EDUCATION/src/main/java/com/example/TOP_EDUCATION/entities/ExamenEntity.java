package com.example.TOP_EDUCATION.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "examenes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExamenEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int puntaje;
    private String fecha_examen;
    private String rut_estudiante;
}
