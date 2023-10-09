package com.example.TOP_EDUCATION.repositories;

import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ExamenRepository extends JpaRepository<ExamenEntity,Long> {

    public ExamenEntity findById(int id);

    //dos maneras diferentes de hacer una consulta a nuestra BD,
    // en este caso para buscar por su nombre
    @Query("select e from ExamenEntity e where e.id= :id")
    ExamenEntity findByIdCustomQuery(@Param("id")int id);

    @Query(value = "select * from examenes as e where e.id= :id",
            nativeQuery = true)
    ExamenEntity findByIdNativeQuery(@Param("id")int id);

}
