package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "estudiante") //Mapeo de la clase estudiante con la tabla estudiantes de la BD
@Data //getters y setters de lombok
@NoArgsConstructor
@AllArgsConstructor //constructor con y sin parametros de lombok


public class EstudianteEntity {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    private String rut;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private TipoColegio colegioProcedente;
    private String nombreColegio;
    private int añoEgreso;


}