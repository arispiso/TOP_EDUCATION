package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class ExamenService {

    @Autowired
    ExamenRepository examenRepository;

    public ArrayList<ExamenEntity> obtenerExamenes(){
        return (ArrayList<ExamenEntity>) examenRepository.findAll();
    }

    public ExamenEntity obtenerPorId(int id) {
        return examenRepository.findById(id);
    }
    public void guardarExamen(ExamenEntity examen){
        examenRepository.save(examen);
    }

    public void eliminarExamen(ExamenEntity examen){
        try {
            examenRepository.delete(examen);
        }
        catch (Exception e) {
            System.out.println("Error al eliminar el examen: " + examen);
        }

    }
}
