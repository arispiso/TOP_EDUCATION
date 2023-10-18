package com.example.TOP_EDUCATION;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.repositories.ExamenRepository;
import com.example.TOP_EDUCATION.services.CuotaService;
import com.example.TOP_EDUCATION.services.EstudianteService;
import com.example.TOP_EDUCATION.services.ExamenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExamenServiceTests {

    @Autowired
    ExamenRepository examenRepository;

    @Autowired
    ExamenService examenService;

    @Autowired
    private EstudianteService estudianteService;

    @Test
    public void obtenerExamenesTest(){
        int id = 1;
        int puntaje = 900;
        String fecha = "2023-10-12";
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        ExamenEntity examen = new ExamenEntity(id,puntaje,fecha,rut);
        ExamenEntity examen1 = new ExamenEntity(2,899,fecha,rut);
        ExamenEntity examen2 = new ExamenEntity(3,456,fecha,rut);


        estudianteService.guardarEstudiante(e);
        examenService.guardarExamen(examen);
        examenService.guardarExamen(examen1);
        examenService.guardarExamen(examen2);

        ArrayList<ExamenEntity> resultados = examenService.obtenerExamenes();

        assertEquals(3,resultados.size());
        assertEquals(900,resultados.get(0).getPuntaje());
        assertEquals(899,resultados.get(1).getPuntaje());
        assertEquals(456,resultados.get(2).getPuntaje());

        examenService.eliminarExamen(examen);
        examenService.eliminarExamen(examen1);
        examenService.eliminarExamen(examen2);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void obtenerNumExamenesTest(){
        int id = 1;
        int puntaje = 900;
        String fecha = "2023-10-12";
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        ExamenEntity examen = new ExamenEntity(id,puntaje,fecha,rut);
        ExamenEntity examen1 = new ExamenEntity(2,899,fecha,rut);
        ExamenEntity examen2 = new ExamenEntity(3,456,fecha,rut);


        estudianteService.guardarEstudiante(e);
        examenService.guardarExamen(examen);
        examenService.guardarExamen(examen1);
        examenService.guardarExamen(examen2);

        int resultados = examenService.obtenerNumExamenes(rut);

        assertEquals(3,resultados);

        examenService.eliminarExamen(examen);
        examenService.eliminarExamen(examen1);
        examenService.eliminarExamen(examen2);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void obtenerPromedioExamenesTest(){
        int id = 1;
        int puntaje = 900;
        String fecha = "2023-10-12";
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        ExamenEntity examen = new ExamenEntity(id,puntaje,fecha,rut);
        ExamenEntity examen1 = new ExamenEntity(2,899,fecha,rut);
        ExamenEntity examen2 = new ExamenEntity(3,456,fecha,rut);


        estudianteService.guardarEstudiante(e);
        examenService.guardarExamen(examen);
        examenService.guardarExamen(examen1);
        examenService.guardarExamen(examen2);

        double resultados = examenService.obtenerPromedioExamenes(rut);

        assertEquals(751.66,resultados,0.01);

        examenService.eliminarExamen(examen);
        examenService.eliminarExamen(examen1);
        examenService.eliminarExamen(examen2);
        estudianteService.eliminarEstudiante(e);
    }


    @Test
    public void guardarExamenTest(){
        int id = 1;
        int puntaje = 900;
        String fecha = "2023-10-12";
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        ExamenEntity examen = new ExamenEntity(id,puntaje,fecha,rut);
        ExamenEntity examen1 = new ExamenEntity(2,899,fecha,rut);
        ExamenEntity examen2 = new ExamenEntity(3,456,fecha,rut);

        estudianteService.guardarEstudiante(e);
        examenService.guardarExamen(examen);
        examenService.guardarExamen(examen1);
        examenService.guardarExamen(examen2);


        ExamenEntity ex = examenRepository.findByIdCustomQuery(examen.getId());
        ExamenEntity ex1 = examenRepository.findByIdCustomQuery(examen1.getId());
        ExamenEntity ex2 = examenRepository.findByIdCustomQuery(examen2.getId());

        assertEquals(ex,examen);
        assertEquals(ex1,examen1);
        assertEquals(ex2,examen2);

        examenService.eliminarExamen(examen);
        examenService.eliminarExamen(examen1);
        examenService.eliminarExamen(examen2);
    }
    @Test
    public void guardarExamenTestBD(){
        int id = 1;
        int puntaje = 900;
        String fecha = "2023-10-12";
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);

        estudianteService.guardarEstudiante(e);

        examenService.guardarExamenBD(puntaje,fecha,rut);
        examenService.guardarExamenBD(899,fecha,rut);
        examenService.guardarExamenBD(456,fecha,rut);

        ArrayList<ExamenEntity> resultado = examenService.obtenerExamenes();

        assertEquals(3,resultado.size());

        examenRepository.deleteAll();
    }


    @Test
    public void eliminarExamenTest(){

        int id = 1;
        int puntaje = 900;
        String fecha = "2023-10-12";
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        ExamenEntity examen = new ExamenEntity(id,puntaje,fecha,rut);
        ExamenEntity examen1 = new ExamenEntity(2,899,fecha,rut);
        ExamenEntity examen2 = new ExamenEntity(3,456,fecha,rut);

        estudianteService.guardarEstudiante(e);
        examenService.guardarExamen(examen);
        examenService.guardarExamen(examen1);
        examenService.guardarExamen(examen2);

        examenService.eliminarExamen(examen);
        examenService.eliminarExamen(examen1);
        examenService.eliminarExamen(examen2);
        estudianteService.eliminarEstudiante(e);

        ArrayList<ExamenEntity> resultado = examenService.obtenerExamenes();

        assertEquals(0,resultado.size());
    }



}
