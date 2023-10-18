package com.example.TOP_EDUCATION.repositories;
import com.example.TOP_EDUCATION.entities.ResumenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
@Repository
public interface ResumenRepository extends JpaRepository<ResumenEntity,Long> {

    //dos maneras diferentes de hacer una consulta a nuestra BD,
    // en este caso para buscar por su nombre
    @Query("select r from ResumenEntity r where r.rut_estudiante= :rut_estudiante")
    ResumenEntity findByRUTCustomQuery(@Param("rut_estudiante")String rut_estudiante);

    @Query(value = "select * from resumenes as r where r.rut_estudiante= :rut_estudiante",
            nativeQuery = true)
    ResumenEntity findByRUTNativeQuery(@Param("rut_estudiante")String rut_estudiante);

    @Query(value ="select * from resumenes",
            nativeQuery = true)
    ArrayList<ResumenEntity> findAllResumenes();

    @Query(value ="select count(*) from resumenes",
            nativeQuery = true)
    int obtenerNumResumenes();

}
