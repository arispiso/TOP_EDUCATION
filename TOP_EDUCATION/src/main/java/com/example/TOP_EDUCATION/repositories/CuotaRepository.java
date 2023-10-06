package com.example.TOP_EDUCATION.repositories;
import com.example.TOP_EDUCATION.entities.CuotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CuotaRepository extends JpaRepository<CuotaEntity,Long> {

    public CuotaEntity findById(int id);

    //dos maneras diferentes de hacer una consulta a nuestra BD, en este caso
    // para buscar por su nombre
    @Query("select c from CuotaEntity c where c.id= :id")
    CuotaEntity findByIDCustomQuery(@Param("id")int id);

    @Query(value = "select * from cuotas as c where c.id= :id",
            nativeQuery = true)
    CuotaEntity findByIDNativeQuery(@Param("id")int id);

}
