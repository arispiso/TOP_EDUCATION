package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.example.TOP_EDUCATION.repositories.EstudianteRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CuotaService {

    @Autowired
    CuotaRepository cuotaRepository;

    @Autowired
    private AdministradorPagos administradorPagos;


    public ArrayList<CuotaEntity> obtenerCuotas(){
        return (ArrayList<CuotaEntity>) cuotaRepository.findAll();
    }

    public Optional<CuotaEntity> obtenerPorId(Long id) {
        return cuotaRepository.findById(id);
    }
    public void guardarCuota(CuotaEntity cuota){
        cuotaRepository.save(cuota);
    }

    public void eliminarCuota(CuotaEntity cuota){
        try {
            cuotaRepository.delete(cuota);
        }catch (Exception e) {
            System.out.println("Error al eliminar el cuota: " + cuota);
        }

    }

}
