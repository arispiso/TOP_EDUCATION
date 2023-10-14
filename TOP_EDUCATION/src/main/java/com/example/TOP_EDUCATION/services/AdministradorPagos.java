package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class AdministradorPagos {

    private double arancel = 1500000;

    public double descuentoPorPagoAlContado() {
        return arancel - (arancel*0.5);
    }

    public double descuentoPorCuota(String colegio) {
        if (colegio.equalsIgnoreCase("Municipal")) {
            return arancel * 0.2;
        } else if (colegio.equalsIgnoreCase("Subvencionado")) {
            return arancel * 0.1;
        } else {
            return 0;
        }
    }

    public double descuentoPorAnyoEgreso(int anyo) {

        LocalDate fechaActual = LocalDate.now();
        int anyoActual = fechaActual.getYear();
        int diferenciaAnyos = anyoActual - anyo;

        if (diferenciaAnyos < 1) {
            return arancel * 0.15;
        } else if (diferenciaAnyos >= 1 && diferenciaAnyos <= 2) {
            return arancel * 0.08;
        } else if (diferenciaAnyos >= 3 && diferenciaAnyos <= 4) {
            return arancel * 0.04;
        } else {
            return 0;
        }
    }

    public double descuentoTotal(String colegio, int anyo) {
        return arancel - (descuentoPorCuota(colegio) + descuentoPorAnyoEgreso(anyo));
    }

    public double pagoPorCuotas(String colegio, int anyo, int numCuotas) {


        if (colegio.equalsIgnoreCase("Municipal") && numCuotas <= 10) {
            return descuentoTotal(colegio, anyo) / numCuotas;
        } else if (colegio.equalsIgnoreCase("Subvencionado") && numCuotas <= 7) {
            return descuentoTotal(colegio, anyo) / numCuotas;
        } else if (colegio.equalsIgnoreCase("Privado") && numCuotas <= 4) {
            return descuentoTotal(colegio, anyo) / numCuotas;
        } else {
            return 0;
        }
    }



    // public double interesPorAtraso(int mes){

        //ArrayList<CuotaEntity> cuotas = cuotaService.obtenerCuotas();

    // LocalDate fechaActual = LocalDate.now();
    //int mesActual = fechaActual.getMonthValue();
    // int diferenciaAnyos = mesActual - mes;

    // if(diferenciaAnyos <= 0){
    //     return 0;
    // } else if (diferenciaAnyos == 1) {
    //     //3%
    //       return 0;
    //  }else if (diferenciaAnyos == 2) {
    //       //6%
    //      return 0;
    //   }else if (diferenciaAnyos == 3) {
            //9%
    //       return 0;
    //   }
    //   else {
            //15%
    //      return 0;
    //  }
    // }
}



