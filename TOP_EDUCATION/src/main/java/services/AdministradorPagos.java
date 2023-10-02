package services;

import entities.TipoColegio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class AdministradorPagos {

    private static final int matricula = 70000;
    private double arancel = 1500000;


    public double descuentoPorPagoAlContado(){
        return arancel * 0.5;
    }

    public double descuentoPorCuota(TipoColegio colegio){
        if(colegio == TipoColegio.MUNICIPAL){ return arancel * 0.2; }
        else if (colegio == TipoColegio.SUBVENCIONADO) { return arancel * 0.1; }
        else { return 0; }
    }

    public double descuentoPorAñoEgreso(int año){

        LocalDate fechaActual = LocalDate.now();
        int añoActual = fechaActual.getYear();
        int diferenciaAños = añoActual - año;

        if(diferenciaAños<1){ return arancel * 0.15; }
        else if (diferenciaAños>=1 && diferenciaAños<=2) { return arancel * 0.08; }
        else if (diferenciaAños>=3 && diferenciaAños<=4) { return arancel * 0.04; }
        else { return 0; }
    }

    public double descuentoTotal(TipoColegio colegio, int año){
        return descuentoPorCuota(colegio) + descuentoPorAñoEgreso(año);
    }

    public double pagoPorCuotas(TipoColegio colegio, int numCuotas){

        //LocalDate fechaActual = LocalDate.now();
        //int diaActual = fechaActual.getDayOfMonth();

        //if(diaActual>=5 && diaActual<=10){
           if (colegio == TipoColegio.MUNICIPAL && numCuotas<=10){ return arancel/numCuotas; }
           else if (colegio == TipoColegio.SUBVENCIONADO && numCuotas<=7) { return arancel/numCuotas; }
           else if (colegio == TipoColegio.PRIVADO && numCuotas<=4){ return arancel/numCuotas; }
           else { return 0;   }
        }
        //else { return 0; }
    }
//}
