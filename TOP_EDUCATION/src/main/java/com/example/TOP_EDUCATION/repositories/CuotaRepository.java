package com.example.TOP_EDUCATION.repositories;
import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CuotaRepository extends JpaRepository<CuotaEntity,Long> {

    public CuotaEntity findById(int id);
    public ArrayList<CuotaEntity> findByRutEstudiante(String rut);

    //dos maneras diferentes de hacer una consulta a nuestra BD, en este caso
    // para buscar por su nombre
    @Query("select c from CuotaEntity c where c.id= :id")
    CuotaEntity findByIDCustomQuery(@Param("id")int id);

    @Query(value = "select * from cuotas as c where c.id= :id",
            nativeQuery = true)
    CuotaEntity findByIDNativeQuery(@Param("id")int id);

    @Query(value ="select * from cuotas",
            nativeQuery = true)
    ArrayList<CuotaEntity> findAllCuotas();

    @Query(value = "select count(*) from cuotas where estado = 'Solicitado a pagar' AND rut_estudiante=:rut_estudiante ",
            nativeQuery = true)
    int obtenerNumCuotasPagadas(@Param("rut_estudiante")String rut_estudiante);

    @Query(value = "select count(*) from cuotas where estado = 'Pendiente' AND rut_estudiante=:rut_estudiante ",
            nativeQuery = true)
    int obtenerNumCuotasPendientes(@Param("rut_estudiante")String rut_estudiante);

    @Query(value = "select sum(valor) from cuotas where estado = 'Solicitado a pagar' AND rut_estudiante=:rut_estudiante ",
            nativeQuery = true)
    List<Double> obtenerValorPagado(@Param("rut_estudiante")String rut_estudiante);

    @Query(value = "select sum(valor) from cuotas where estado = 'Pendiente' AND rut_estudiante=:rut_estudiante ",
            nativeQuery = true)
    List<Double> obtenerValorPendiente(@Param("rut_estudiante")String rut_estudiante);

}
