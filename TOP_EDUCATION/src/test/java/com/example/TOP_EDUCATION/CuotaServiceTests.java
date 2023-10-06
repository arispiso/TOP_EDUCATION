package com.example.TOP_EDUCATION;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.repositories.CuotaRepository;
import com.example.TOP_EDUCATION.services.CuotaService;
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
    private CuotaRepository  cuotaRepository;


    @Test
    public void testObtenerCuotas() {

        int id = 1;
        int id2 = 2;
        String estado = "Pendiente";
        String estado2 = "Solicitado para pagar";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c1 = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut);
        CuotaEntity c2 = new CuotaEntity(id2,estado2,valor,cantidad_cuotas,rut);

        cuotaService.guardarCuota(c1);
        cuotaService.guardarCuota(c2);

        ArrayList<CuotaEntity> resultado = cuotaService.obtenerCuotas();

        assertEquals(2, resultado.size());
        assertEquals("Pendiente", resultado.get(0).getEstado());
        assertEquals("Solicitado para pagar", resultado.get(1).getEstado());

        cuotaService.eliminarCuota(c1);
        cuotaService.eliminarCuota(c2);
    }

    @Test
    public void testObtenerPorId() {

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut);

        cuotaService.guardarCuota(c);

        CuotaEntity cuotaABuscar = cuotaService.obtenerPorId(id);

        assertEquals(1, cuotaABuscar.getId());

        cuotaService.eliminarCuota(c);
    }


    @Test
    public void guardarCuotaTest(){
        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut);

        cuotaService.guardarCuota(c);

        CuotaEntity c2 = cuotaRepository.findById(c.getId());

        assertEquals(c, c2);

        cuotaService.eliminarCuota(c);
    }

    @Test
    public void eliminarCuotaTest(){

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut);
        cuotaService.guardarCuota(c);
        cuotaService.eliminarCuota(c);

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

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut);

        cuotaService.guardarCuota(c);

        cuotaService.actualizarEstado(c.getId());

        CuotaEntity c2 = cuotaService.obtenerPorId(c.getId());


        assertEquals(1,c2.getId());
        assertEquals("Solicitado para pagar",c2.getEstado());

        cuotaService.eliminarCuota(c);
    }

    @Test
    public void pagarCuotaTest(){

        int id = 1;
        String estado = "Pendiente";
        double valor = 10000;
        int cantidad_cuotas = 1;
        String rut = "12345678-K";

        CuotaEntity c = new CuotaEntity(id,estado,valor,cantidad_cuotas,rut);

        cuotaService.guardarCuota(c);

        cuotaService.pagarCuota();

        CuotaEntity c2 = cuotaService.obtenerPorId(c.getId());

        assertEquals(1,c2.getId());
        assertEquals("Solicitado para pagar",c2.getEstado());

        cuotaService.eliminarCuota(c);

    }
}
