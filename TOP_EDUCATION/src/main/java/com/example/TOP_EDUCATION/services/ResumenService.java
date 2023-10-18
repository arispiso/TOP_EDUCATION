package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.entities.ResumenEntity;
import com.example.TOP_EDUCATION.repositories.ResumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResumenService {

    @Autowired
    ResumenRepository resumenRepository;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    CuotaService cuotaService;

    @Autowired
    ExamenService examenService;

    public ArrayList<ResumenEntity> obtenerResumenes(){
        generarResumen();
        return resumenRepository.findAllResumenes();
    }

    public void guardarResumen(ResumenEntity resumen){
        resumenRepository.save(resumen);
    }

    public void eliminarResumenes(){
        resumenRepository.deleteAll();
    }

    public void generarResumen(){
        ResumenEntity resumen = new ResumenEntity();

        ArrayList<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();
        EstudianteEntity e = estudiantes.get(0);
        String rut = e.getRut();

        ArrayList<CuotaEntity> cuotas = cuotaService.obtenerCuotasPorRUT(rut);

        resumen.setRut_estudiante(rut);
        resumen.setNombre_estudiante(e.getNombre());
        resumen.setNum_examenes(examenService.obtenerNumExamenes(rut));
        resumen.setPromedio_examenes(examenService.obtenerPromedioExamenes(rut));
        resumen.setValor_total(cuotaService.calcularValorCuotas(rut));
        resumen.setTipo_pago(e.getPago());
        resumen.setNumCuotas(e.getNum_cuotas());
        resumen.setNumCuotas_pagadas(cuotaService.obtenerNumCuotasPagadas(rut));
        resumen.setValor_pagado(cuotaService.obtenerValorPagado(rut));
        resumen.setFecha_pago(cuotas.get(0).getFecha_cuota());
        resumen.setSaldoPorPagar(cuotaService.obtenerValorPendiente(rut));
        resumen.setNumCuotas_retraso(cuotaService.obtenerNumCuotasPendientes(rut));

        guardarResumen(resumen);
    }
}
