package com.example.TOP_EDUCATION;

import entities.EstudianteEntity;
import entities.TipoColegio;
import org.junit.jupiter.api.Test;
import services.AdministradorPagos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AdministradorPagosTests {
    AdministradorPagos admin = new AdministradorPagos();
    EstudianteEntity estudiante = new EstudianteEntity();
    TipoColegio colegio;

    @Test
    void descuentoPorPagoAlContadoTest(){
        double pagoContado = admin.descuentoPorPagoAlContado();
        assertEquals(750000, pagoContado, 0);
    }

    @Test
    void descuentoPorCuotaTest(){
        TipoColegio colegioM = colegio.MUNICIPAL;
        double descuentoCuotaMunicipal = admin.descuentoPorCuota(colegioM);
        assertEquals(300000,descuentoCuotaMunicipal,0);

        TipoColegio colegioS = colegio.SUBVENCIONADO;
        double descuentoCuotaSubvencionado = admin.descuentoPorCuota(colegioS);
        assertEquals(150000,descuentoCuotaSubvencionado,0);

        TipoColegio colegioP = colegio.PRIVADO;
        double descuentoCuotaPrivado = admin.descuentoPorCuota(colegioP);
        assertEquals(0, descuentoCuotaPrivado, 0);

    }

    @Test void descuentoPorAñoEgresoTest(){
        int año = 2023;
        int año2 = 2022;
        int año3 = 2020;
        int año4 = 2015;

        double menosDe1Año = admin.descuentoPorAñoEgreso(año);
        assertEquals(225000, menosDe1Año, 0);

        double entre1y2 = admin.descuentoPorAñoEgreso(año2);
        assertEquals(120000, entre1y2, 0);

        double entre3y4 = admin.descuentoPorAñoEgreso(año3);
        assertEquals(60000, entre3y4, 0);

        double demas = admin.descuentoPorAñoEgreso(año4);
        assertEquals(0, demas, 0);
    }

    @Test
    void descuentoTotalTest(){

        TipoColegio colegioM = colegio.MUNICIPAL;
        int año2 = 2022;

        double d = admin.descuentoTotal(colegioM,año2);
        assertEquals(420000,d,0);
    }

    @Test
    void pagoPorCuotasTest(){

        TipoColegio colegioS = TipoColegio.SUBVENCIONADO;
        TipoColegio colegioP = TipoColegio.PRIVADO;
        int cuotas = 5;

        double bien = admin.pagoPorCuotas(colegioS, cuotas);
        assertEquals(300000, bien, 0);

        double mal = admin.pagoPorCuotas(colegioP, cuotas);
        assertEquals(0,mal,0);

    }

}
