package com.example.TOP_EDUCATION;

//import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import org.junit.jupiter.api.Test;
import com.example.TOP_EDUCATION.services.AdministradorPagos;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;


public class AdministradorPagosTests {
    AdministradorPagos admin = new AdministradorPagos();
    //EstudianteEntity estudiante = new EstudianteEntity();


    @Test
    void descuentoPorPagoAlContadoTest(){
        double pagoContado = admin.descuentoPorPagoAlContado();
        assertEquals(750000, pagoContado, 0);
    }

    @Test
    void descuentoPorCuotaTest(){
        String colegioMunicipal = "Municipal";
        double descuentoCuotaMunicipal = admin.descuentoPorCuota(colegioMunicipal);
        assertEquals(300000,descuentoCuotaMunicipal,0);

        String colegioSubvencionado = "Subvencionado";
        double descuentoCuotaSubvencionado = admin.descuentoPorCuota(colegioSubvencionado);
        assertEquals(150000,descuentoCuotaSubvencionado,0);

        String colegioPrivado = "Privado";
        double descuentoCuotaPrivado = admin.descuentoPorCuota(colegioPrivado);
        assertEquals(0, descuentoCuotaPrivado, 0);

    }

    @Test void descuentoPorAnyoEgresoTest(){
        int anyo = 2023;
        int anyo2 = 2022;
        int anyo3 = 2020;
        int anyo4 = 2015;

        double menosDe1Anyo = admin.descuentoPorAnyoEgreso(anyo);
        assertEquals(225000, menosDe1Anyo, 0);

        double entre1y2 = admin.descuentoPorAnyoEgreso(anyo2);
        assertEquals(120000, entre1y2, 0);

        double entre3y4 = admin.descuentoPorAnyoEgreso(anyo3);
        assertEquals(60000, entre3y4, 0);

        double demas = admin.descuentoPorAnyoEgreso(anyo4);
        assertEquals(0, demas, 0);
    }

    @Test
    void descuentoTotalTest(){

        String colegioMunicipal = "Municipal";
        int anyo2 = 2022;

        double d = admin.descuentoTotal(colegioMunicipal,anyo2);
        assertEquals(1080000,d,0);
    }

    @Test
    void pagoPorCuotasTest(){

        String colegioS = "Subvencionado";
        String colegioP = "Privado";
        int anyo = 2022;
        int cuotas = 5;

        double bien = admin.pagoPorCuotas(colegioS,anyo, cuotas);
        assertEquals(246000, bien, 0);

        double mal = admin.pagoPorCuotas(colegioP,anyo, cuotas);
        assertEquals(0,mal,0);

    }

}
