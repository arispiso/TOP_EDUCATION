package com.example.TOP_EDUCATION;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.repositories.CuotaRepository;
import com.example.TOP_EDUCATION.repositories.EstudianteRepository;
import com.example.TOP_EDUCATION.services.CuotaService;
import com.example.TOP_EDUCATION.services.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
public class EstudianteServiceTests {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    CuotaService cuotaService;

    @Autowired
    CuotaRepository cuotaRepository;

    @Test
    public void obtenerEstudiantesTest() throws ParseException {

        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";
        int anyo_Egreso = 2022;
        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago2, num_cuotas1);
        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso, pago2, num_cuotas2);
        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso, pago2, num_cuotas3);

        estudianteService.guardarEstudiante(e);
        estudianteService.guardarEstudiante(e1);
        estudianteService.guardarEstudiante(e2);
        estudianteService.guardarEstudiante(e3);

        ArrayList<EstudianteEntity> resultado = estudianteService.obtenerEstudiantes();

        //System.out.println("Estudiante 0: " + e);
        //System.out.println("Estudiante 1: " + e1);
        //System.out.println("Estudiante 2: " + e2);
        //System.out.println("Estudiante 3: " + e3);
        //System.out.println("Resultado" + resultado);

        assertEquals(4, resultado.size());
        assertEquals(e.getRut(),resultado.get(0).getRut());
        assertEquals(e1.getRut(),resultado.get(1).getRut());
        assertEquals(e2.getRut(),resultado.get(2).getRut());
        assertEquals(e3.getRut(),resultado.get(3).getRut());

        estudianteService.eliminarEstudiante(e);
        estudianteService.eliminarEstudiante(e1);
        estudianteService.eliminarEstudiante(e2);
        estudianteService.eliminarEstudiante(e3);
    }

    @Test
    public void obtenerPorRut() throws ParseException {
        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";
        int anyo_Egreso = 2022;
        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago2, num_cuotas1);
        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso, pago2, num_cuotas2);
        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso, pago2, num_cuotas3);

        estudianteService.guardarEstudiante(e);
        estudianteService.guardarEstudiante(e1);
        estudianteService.guardarEstudiante(e2);
        estudianteService.guardarEstudiante(e3);

        EstudianteEntity resultadoE = estudianteService.obtenerPorRut(rut);
        EstudianteEntity resultadoE1 = estudianteService.obtenerPorRut(rut1);
        EstudianteEntity resultadoE2 = estudianteService.obtenerPorRut(rut2);
        EstudianteEntity resultadoE3 = estudianteService.obtenerPorRut(rut3);

        assertEquals(rut,resultadoE.getRut());
        assertEquals(rut1,resultadoE1.getRut());
        assertEquals(rut2,resultadoE2.getRut());
        assertEquals(rut3,resultadoE3.getRut());

        estudianteService.eliminarEstudiante(e);
        estudianteService.eliminarEstudiante(e1);
        estudianteService.eliminarEstudiante(e2);
        estudianteService.eliminarEstudiante(e3);
    }

    @Test
    public void guardarEstudianteTest() throws ParseException {

        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";
        int anyo_Egreso = 2022;
        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago2, num_cuotas1);
        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso, pago2, num_cuotas2);
        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso, pago2, num_cuotas3);

        estudianteService.guardarEstudiante(e);
        estudianteService.guardarEstudiante(e1);
        estudianteService.guardarEstudiante(e2);
        estudianteService.guardarEstudiante(e3);

        EstudianteEntity resultadoE = estudianteService.obtenerPorRut(rut);
        EstudianteEntity resultadoE1 = estudianteService.obtenerPorRut(rut1);
        EstudianteEntity resultadoE2 = estudianteService.obtenerPorRut(rut2);
        EstudianteEntity resultadoE3 = estudianteService.obtenerPorRut(rut3);

        assertEquals(e, resultadoE);
        assertEquals(e1, resultadoE1);
        assertEquals(e2, resultadoE2);
        assertEquals(e3, resultadoE3);

        estudianteService.eliminarEstudiante(e);
        estudianteService.eliminarEstudiante(e1);
        estudianteService.eliminarEstudiante(e2);
        estudianteService.eliminarEstudiante(e3);
    }

    @Test
    public void eliminarEstudianteTest() throws ParseException {

        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";
        int anyo_Egreso = 2022;
        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago2, num_cuotas1);
        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso, pago2, num_cuotas2);
        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso, pago2, num_cuotas3);

        estudianteService.guardarEstudiante(e);
        estudianteService.guardarEstudiante(e1);
        estudianteService.guardarEstudiante(e2);
        estudianteService.guardarEstudiante(e3);

        estudianteService.eliminarEstudiante(e);
        estudianteService.eliminarEstudiante(e1);
        estudianteService.eliminarEstudiante(e2);
        estudianteService.eliminarEstudiante(e3);

        ArrayList<EstudianteEntity> resultado = estudianteService.obtenerEstudiantes();
        assertEquals(0, resultado.size());
    }

    @Test
    public void obtenerNumeroCuotasTest() throws ParseException{
        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";
        int anyo_Egreso = 2022;
        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago2, num_cuotas1);
        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso, pago2, num_cuotas2);
        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso, pago2, num_cuotas3);

        estudianteService.guardarEstudiante(e);
        estudianteService.guardarEstudiante(e1);
        estudianteService.guardarEstudiante(e2);
        estudianteService.guardarEstudiante(e3);

        int numCuotasEstudiante = estudianteService.obtenerNumeroCuotas(rut);
        int numCuotasEstudiante1 = estudianteService.obtenerNumeroCuotas(rut1);
        int numCuotasEstudiante2 = estudianteService.obtenerNumeroCuotas(rut2);
        int numCuotasEstudiante3 = estudianteService.obtenerNumeroCuotas(rut3);

        assertEquals(num_cuotas,numCuotasEstudiante);
        assertEquals(num_cuotas1,numCuotasEstudiante1);
        assertEquals(num_cuotas2,numCuotasEstudiante2);
        assertEquals(num_cuotas3,numCuotasEstudiante3);

        estudianteService.eliminarEstudiante(e);
        estudianteService.eliminarEstudiante(e1);
        estudianteService.eliminarEstudiante(e2);
        estudianteService.eliminarEstudiante(e3);
    }

    @Test
    public void obtenerTipoColegioTest() throws ParseException {
        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";
        int anyo_Egreso = 2022;
        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago2, num_cuotas1);
        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso, pago2, num_cuotas2);
        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso, pago2, num_cuotas3);

        estudianteService.guardarEstudiante(e);
        estudianteService.guardarEstudiante(e1);
        estudianteService.guardarEstudiante(e2);
        estudianteService.guardarEstudiante(e3);

        String tipoColegioEstudiante = estudianteService.obtenerTipoColegio(rut);
        String tipoColegioEstudiante1 = estudianteService.obtenerTipoColegio(rut1);
        String tipoColegioEstudiante2 = estudianteService.obtenerTipoColegio(rut2);
        String tipoColegioEstudiante3 = estudianteService.obtenerTipoColegio(rut3);

        assertEquals(colegio_procedente,tipoColegioEstudiante);
        assertEquals(colegio_procedente,tipoColegioEstudiante1);
        assertEquals(colegio_procedente2,tipoColegioEstudiante2);
        assertEquals(colegio_procedente3,tipoColegioEstudiante3);

        estudianteService.eliminarEstudiante(e);
        estudianteService.eliminarEstudiante(e1);
        estudianteService.eliminarEstudiante(e2);
        estudianteService.eliminarEstudiante(e3);
    }

    @Test
    public void obtenerAnyoEgresoTest() throws ParseException {
        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";
        int anyo_Egreso = 2022;
        int anyo_Egreso1 = 2020;
        int anyo_Egreso2 = 2023;
        int anyo_Egreso3 = 2004;
        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso1, pago2, num_cuotas1);
        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso2, pago2, num_cuotas2);
        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso3, pago2, num_cuotas3);

        estudianteService.guardarEstudiante(e);
        estudianteService.guardarEstudiante(e1);
        estudianteService.guardarEstudiante(e2);
        estudianteService.guardarEstudiante(e3);

        int anyoEgresoEstudiante = estudianteService.obtenerAnyoEgreso(rut);
        int anyoEgresoEstudiante1 = estudianteService.obtenerAnyoEgreso(rut1);
        int anyoEgresoEstudiante2 = estudianteService.obtenerAnyoEgreso(rut2);
        int anyoEgresoEstudiante3 = estudianteService.obtenerAnyoEgreso(rut3);

        assertEquals(anyo_Egreso,anyoEgresoEstudiante);
        assertEquals(anyo_Egreso1,anyoEgresoEstudiante1);
        assertEquals(anyo_Egreso2,anyoEgresoEstudiante2);
        assertEquals(anyo_Egreso3,anyoEgresoEstudiante3);

        estudianteService.eliminarEstudiante(e);
        estudianteService.eliminarEstudiante(e1);
        estudianteService.eliminarEstudiante(e2);
        estudianteService.eliminarEstudiante(e3);
    }

    @Test
    public void generarCuotaTest() throws ParseException{
        String rut = "12345678-K";
        String rut1 = "12345999-K";
        String rut2 = "22226789-K";
        String rut3 = "23456789-K";

        String nombre = "Aritz";
        String apellidos = "Lamelas";

        Date fecha_nacimiento;
        String fechaEnString = "2002-06-28";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha_nacimiento = formato.parse(fechaEnString);

        String colegio_procedente = "Municipal";
        String colegio_procedente2 = "Subvencionado";
        String colegio_procedente3 = "Privado";

        String nombre_colegio = "Aben";

        int anyo_Egreso = 2022;
        int anyo_Egreso1 = 2020;
        int anyo_Egreso2 = 2023;
        int anyo_Egreso3 = 2004;

        String pago = "Al contado";
        String pago2 = "Por cuotas";

        int num_cuotas = 1;
        int num_cuotas1 = 9;
        int num_cuotas2 = 6;
        int num_cuotas3 = 3;

        EstudianteEntity e = new EstudianteEntity(rut, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso, pago, num_cuotas);
        estudianteService.guardarEstudiante(e);
        estudianteService.generarCuota(e);
        ArrayList<CuotaEntity> listaCuotas = cuotaRepository.findAllCuotas();
        assertEquals(num_cuotas,listaCuotas.size());
        for(int i = 0; i<num_cuotas; i++){
            cuotaService.eliminarCuota(listaCuotas.get(i));
        }
        estudianteService.eliminarEstudiante(e);

        EstudianteEntity e1 = new EstudianteEntity(rut1, nombre, apellidos, fecha_nacimiento, colegio_procedente, nombre_colegio, anyo_Egreso1, pago2, num_cuotas1);
        estudianteService.guardarEstudiante(e1);
        estudianteService.generarCuota(e1);
        ArrayList<CuotaEntity> listaCuotas1 = cuotaRepository.findAllCuotas();
        assertEquals(num_cuotas1,listaCuotas1.size());
        for(int i = 0; i<num_cuotas1; i++){
            cuotaService.eliminarCuota(listaCuotas1.get(i));
        }
        estudianteService.eliminarEstudiante(e1);

        EstudianteEntity e2 = new EstudianteEntity(rut2, nombre, apellidos, fecha_nacimiento, colegio_procedente2, nombre_colegio, anyo_Egreso2, pago2, num_cuotas2);
        estudianteService.guardarEstudiante(e2);
        estudianteService.generarCuota(e2);
        ArrayList<CuotaEntity> listaCuotas2 = cuotaRepository.findAllCuotas();
        assertEquals(num_cuotas2,listaCuotas2.size());
        for(int i = 0; i<num_cuotas2; i++){
            cuotaService.eliminarCuota(listaCuotas2.get(i));
        }
        estudianteService.eliminarEstudiante(e2);

        EstudianteEntity e3 = new EstudianteEntity(rut3, nombre, apellidos, fecha_nacimiento, colegio_procedente3, nombre_colegio, anyo_Egreso3, pago2, num_cuotas3);
        estudianteService.guardarEstudiante(e3);
        estudianteService.generarCuota(e3);
        ArrayList<CuotaEntity> listaCuotas3 = cuotaRepository.findAllCuotas();
        assertEquals(num_cuotas3,listaCuotas3.size());
        for(int i = 0; i<num_cuotas3; i++){
            cuotaService.eliminarCuota(listaCuotas3.get(i));
        }
        estudianteService.eliminarEstudiante(e3);
    }

}
