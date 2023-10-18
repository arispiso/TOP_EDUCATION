package com.example.TOP_EDUCATION;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.entities.ResumenEntity;
import com.example.TOP_EDUCATION.repositories.ResumenRepository;
import com.example.TOP_EDUCATION.services.CuotaService;
import com.example.TOP_EDUCATION.services.EstudianteService;
import com.example.TOP_EDUCATION.services.ExamenService;
import com.example.TOP_EDUCATION.services.ResumenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class ResumenServiceTests {

    @Autowired
    ResumenService resumenService;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    CuotaService cuotaService;

    @Autowired
    ExamenService examenService;

    @Autowired
    ResumenRepository resumenRepository;


    @Test
    public void obtenerResumenesTest(){

        int id = 1;
        int id2 = 2;
        String estado = "Pendiente";
        String estado2 = "Solicitado para pagar";
        double valor = 10000;
        int cantidad_cuotas = 2;
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,"Aritz","Lamelas",null,"Municipal","Aben",2020,"Por cuotas",2);
        estudianteService.guardarEstudiante(e);

        CuotaEntity c1 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        CuotaEntity c2 = new CuotaEntity(id2,estado2,3000,cantidad_cuotas,rut,"2023-10-12");
        cuotaService.guardarCuota(c1);
        cuotaService.guardarCuota(c2);

        ExamenEntity ex = new ExamenEntity(id,900,"2020-12-12",rut);
        examenService.guardarExamen(ex);

        resumenService.generarResumen();

        ArrayList<ResumenEntity> resumenes = resumenService.obtenerResumenes();

        assertEquals(1,resumenes.size());
        resumenService.eliminarResumenes();
        cuotaService.eliminarCuota(c1);
        cuotaService.eliminarCuota(c2);
        examenService.eliminarExamen(ex);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void guardarResumenTest(){
        int id = 1;
        int id2 = 2;
        String estado = "Pendiente";
        String estado2 = "Solicitado para pagar";
        double valor = 10000;
        int cantidad_cuotas = 2;
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,"Aritz","Lamelas",null,"Municipal","Aben",2020,"Por cuotas",2);
        estudianteService.guardarEstudiante(e);

        CuotaEntity c1 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        CuotaEntity c2 = new CuotaEntity(id2,estado2,3000,cantidad_cuotas,rut,"2023-10-12");
        cuotaService.guardarCuota(c1);
        cuotaService.guardarCuota(c2);

        ExamenEntity ex = new ExamenEntity(id,900,"2020-12-12",rut);
        examenService.guardarExamen(ex);

        resumenService.generarResumen();

        ArrayList<ResumenEntity> resumenes = resumenService.obtenerResumenes();

        assertEquals(1,resumenes.size());

        resumenService.eliminarResumenes();
        cuotaService.eliminarCuota(c1);
        cuotaService.eliminarCuota(c2);
        examenService.eliminarExamen(ex);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void eliminarResumenTest(){
        int id = 1;
        int id2 = 2;
        String estado = "Pendiente";
        String estado2 = "Solicitado para pagar";
        double valor = 10000;
        int cantidad_cuotas = 2;
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,"Aritz","Lamelas",null,"Municipal","Aben",2020,"Por cuotas",2);
        estudianteService.guardarEstudiante(e);

        CuotaEntity c1 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        CuotaEntity c2 = new CuotaEntity(id2,estado2,3000,cantidad_cuotas,rut,"2023-10-12");
        cuotaService.guardarCuota(c1);
        cuotaService.guardarCuota(c2);

        ExamenEntity ex = new ExamenEntity(id,900,"2020-12-12",rut);
        examenService.guardarExamen(ex);

        resumenService.generarResumen();

        resumenService.eliminarResumenes();

        assertEquals(0,resumenRepository.obtenerNumResumenes());

        cuotaService.eliminarCuota(c1);
        cuotaService.eliminarCuota(c2);
        examenService.eliminarExamen(ex);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void generarResumenTest(){
        int id = 1;
        int id2 = 2;
        String estado = "Pendiente";
        String estado2 = "Solicitado para pagar";
        double valor = 10000;
        int cantidad_cuotas = 2;
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,"Aritz","Lamelas",null,"Municipal","Aben",2020,"Por cuotas",2);
        estudianteService.guardarEstudiante(e);

        CuotaEntity c1 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        CuotaEntity c2 = new CuotaEntity(id2,estado2,3000,cantidad_cuotas,rut,"2023-10-12");
        cuotaService.guardarCuota(c1);
        cuotaService.guardarCuota(c2);

        ExamenEntity ex = new ExamenEntity(id,900,"2020-12-12",rut);
        examenService.guardarExamen(ex);

        resumenService.generarResumen();

        ArrayList<ResumenEntity> resumenes = resumenService.obtenerResumenes();

        assertEquals(1,resumenes.size());

        resumenService.eliminarResumenes();
        cuotaService.eliminarCuota(c1);
        cuotaService.eliminarCuota(c2);
        examenService.eliminarExamen(ex);
        estudianteService.eliminarEstudiante(e);
    }
}
