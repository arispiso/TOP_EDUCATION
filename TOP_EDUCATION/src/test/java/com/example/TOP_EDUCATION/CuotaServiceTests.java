package com.example.TOP_EDUCATION;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.repositories.CuotaRepository;
import com.example.TOP_EDUCATION.services.CuotaService;
import com.example.TOP_EDUCATION.services.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CuotaServiceTests {

    @Autowired
    private CuotaService cuotaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CuotaRepository  cuotaRepository;

    @Test
    public void obtenerCuotasTest() {


        int id = 1;
        int id2 = 2;
        String estado = "Pendiente";
        String estado2 = "Solicitado para pagar";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,"Aritz","Lamelas",null,null,null,1,null, 1);
        estudianteService.guardarEstudiante(e);

        CuotaEntity c1 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        CuotaEntity c2 = new CuotaEntity(id2,estado2,valor,cantidad_cuotas,rut,"2023-10-12");

        cuotaService.guardarCuota(c1);
        cuotaService.guardarCuota(c2);

        ArrayList<CuotaEntity> resultado = cuotaService.obtenerCuotas();

        assertEquals(2, resultado.size());
        assertEquals("Pendiente", resultado.get(0).getEstado());
        assertEquals("Solicitado para pagar", resultado.get(1).getEstado());

        cuotaService.eliminarCuota(c1);
        cuotaService.eliminarCuota(c2);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void obtenerPorIdTest() {

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        estudianteService.guardarEstudiante(e);

        cuotaService.guardarCuota(c);

        CuotaEntity cuotaABuscar = cuotaService.obtenerPorId(id);

        assertEquals(1, cuotaABuscar.getId());

        cuotaService.eliminarCuota(c);
        estudianteService.eliminarEstudiante(e);
    }


    @Test
    public void guardarCuotaTest(){
        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";


        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        estudianteService.guardarEstudiante(e);
        cuotaService.guardarCuota(c);

        CuotaEntity c2 = cuotaRepository.findById(c.getId());

        assertEquals(c, c2);

        cuotaService.eliminarCuota(c);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void eliminarCuotaTest(){

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        estudianteService.guardarEstudiante(e);
        cuotaService.guardarCuota(c);
        cuotaService.eliminarCuota(c);
        estudianteService.eliminarEstudiante(e);
        CuotaEntity c2 = cuotaRepository.findById(c.getId());
        assertNull(c2);
    }

    @Test
    public void actualizarEstadoTest(){

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);

        estudianteService.guardarEstudiante(e);

        cuotaService.guardarCuota(c);

        cuotaService.actualizarEstado(c.getId());

        CuotaEntity c2 = cuotaService.obtenerPorId(c.getId());

        assertEquals(1,c2.getId());

        //Solo sirve entre los días 5 y 10 de cada mes
        //assertEquals("Solicitado para pagar",c2.getEstado());

        assertEquals("Pendiente",c2.getEstado());

        cuotaService.eliminarCuota(c);
        estudianteService.eliminarEstudiante(e);
    }

    @Test
    public void pagarCuotaTest(){

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        CuotaEntity cc = new CuotaEntity(2,"Solicitado para pagar",valor,cantidad_cuotas,rut,"2023-10-12");


        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        estudianteService.guardarEstudiante(e);

        cuotaService.guardarCuota(c);
        cuotaService.guardarCuota(cc);

        cuotaService.pagarCuota();

        CuotaEntity c1 = cuotaService.obtenerPorId(c.getId());
        CuotaEntity c2 = cuotaService.obtenerPorId(cc.getId());

        assertEquals(1,c1.getId());
        assertEquals(2,c2.getId());


        //Solo sirve entre los días 5 y 10 de cada mes
        //assertEquals("Solicitado para pagar",c1.getEstado());
        assertEquals("Solicitado para pagar",c2.getEstado());

        //Sino, este sería el assertEquals a probar:
        assertEquals("Pendiente",c1.getEstado());


        cuotaService.eliminarCuota(c);
        cuotaService.eliminarCuota(cc);
        estudianteService.eliminarEstudiante(e);

    }


    @Test
    public void descuentoPorExamenAdmisionTest(){

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        int puntaje = 951;
        int puntaje1 = 921;
        int puntaje2 = 891;

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");

        estudianteService.guardarEstudiante(e);

        cuotaService.guardarCuota(c);
        cuotaService.descuentoPorExamenAdmision(puntaje);
        assertEquals(9000,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c);

        cuotaService.guardarCuota(c);
        cuotaService.descuentoPorExamenAdmision(puntaje1);
        assertEquals(9500,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c);

        cuotaService.guardarCuota(c);
        cuotaService.descuentoPorExamenAdmision(puntaje2);
        assertEquals(9800,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c);

    }

    @Test
    public void interesPorAtrasoTest(){

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        EstudianteEntity e = new EstudianteEntity(rut,null,null,null,null,null,0,null,0);
        estudianteService.guardarEstudiante(e);


        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-10-12");
        cuotaService.guardarCuota(c);

        cuotaService.interesPorAtraso();
        assertEquals(valor,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c);

        CuotaEntity c1 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-09-12");
        cuotaService.guardarCuota(c1);

        cuotaService.interesPorAtraso();
        assertEquals(10300,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c1);

        CuotaEntity c2 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-08-12");
        cuotaService.guardarCuota(c2);

        cuotaService.interesPorAtraso();
        assertEquals(10600,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c2);

        CuotaEntity c3 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-07-12");
        cuotaService.guardarCuota(c3);

        cuotaService.interesPorAtraso();
        assertEquals(10900,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c3);


        CuotaEntity c4 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut,"2023-03-12");
        cuotaService.guardarCuota(c4);

        cuotaService.interesPorAtraso();
        assertEquals(11500,cuotaService.obtenerPorId(id).getValor());
        cuotaService.eliminarCuota(c4);

    }
}
