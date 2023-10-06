package com.example.TOP_EDUCATION;

//import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import org.junit.jupiter.api.Test;
import com.example.TOP_EDUCATION.services.AdministradorPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AdministradorPagosTests {

    @Autowired
    AdministradorPagos administradorPagos;

    @Test
    void descuentoPorPagoAlContadoTest(){
        double pagoContado = administradorPagos.descuentoPorPagoAlContado();
        assertEquals(750000, pagoContado, 0);
    }

    @Test
    void descuentoPorCuotaTest(){
        String colegioMunicipal = "Municipal";
        double descuentoCuotaMunicipal = administradorPagos.descuentoPorCuota(colegioMunicipal);
        assertEquals(300000,descuentoCuotaMunicipal,0);

        String colegioSubvencionado = "Subvencionado";
        double descuentoCuotaSubvencionado = administradorPagos.descuentoPorCuota(colegioSubvencionado);
        assertEquals(150000,descuentoCuotaSubvencionado,0);

        String colegioPrivado = "Privado";
        double descuentoCuotaPrivado = administradorPagos.descuentoPorCuota(colegioPrivado);
        assertEquals(0, descuentoCuotaPrivado, 0);

    }
    @Test void descuentoPorAnyoEgresoTest(){
        int anyo = 2023;
        int anyo2 = 2022;
        int anyo3 = 2020;
        int anyo4 = 2015;

        double menosDe1Anyo = administradorPagos.descuentoPorAnyoEgreso(anyo);
        assertEquals(225000, menosDe1Anyo, 0);

        double entre1y2 = administradorPagos.descuentoPorAnyoEgreso(anyo2);
        assertEquals(120000, entre1y2, 0);

        double entre3y4 = administradorPagos.descuentoPorAnyoEgreso(anyo3);
        assertEquals(60000, entre3y4, 0);

        double demas = administradorPagos.descuentoPorAnyoEgreso(anyo4);
        assertEquals(0, demas, 0);
    }
    @Test
    void descuentoTotalTest(){

        String colegioMunicipal = "Municipal";
        int anyo2 = 2022;

        double d = administradorPagos.descuentoTotal(colegioMunicipal,anyo2);
        assertEquals(1080000,d,0);
    }
    @Test
    void pagoPorCuotasTest(){

        String colegioS = "Subvencionado";
        String colegioP = "Privado";
        int anio = 2022;
        int cuotas = 5;

        double bien = administradorPagos.pagoPorCuotas(colegioS,anio, cuotas);
        assertEquals(246000, bien, 0);

        double mal = administradorPagos.pagoPorCuotas(colegioP,anio, cuotas);
        assertEquals(0,mal,0);

    }

}
