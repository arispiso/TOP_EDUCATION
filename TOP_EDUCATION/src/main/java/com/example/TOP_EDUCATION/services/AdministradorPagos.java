package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class AdministradorPagos {

    @Autowired
    CuotaService cuotaService;

    private double arancel = 1500000;

    public double descuentoPorPagoAlContado() {
        return arancel - (arancel * 0.5);
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

    public void descuentoPorExamenAdmision(int puntuaje) {

        ArrayList<CuotaEntity> cuotas = cuotaService.obtenerCuotas();

        for (int i = 0; i <= cuotas.size(); i++) {
            CuotaEntity c = cuotas.get(i);
            if (c.getEstado().equalsIgnoreCase("Pendiente")) {
                if (puntuaje >= 950 && puntuaje <= 1000) {
                    //10% a todas las cuotas pendientes  de pago
                    c.setValor(c.getValor() - c.getValor() * 0.1);
                } else if (puntuaje >= 900 && puntuaje <= 949) {
                    //5%
                    c.setValor(c.getValor() - c.getValor() * 0.05);
                } else if (puntuaje >= 850 && puntuaje <= 899) {
                    //2%
                    c.setValor(c.getValor() - c.getValor() * 0.02);
                }
            }
        }

    }
}



