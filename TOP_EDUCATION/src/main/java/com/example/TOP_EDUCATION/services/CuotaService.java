package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.example.TOP_EDUCATION.repositories.EstudianteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CuotaService {

    @Autowired
    CuotaRepository cuotaRepository;

    @Autowired
    AdministradorPagos administradorPagos;

    public ArrayList<CuotaEntity> obtenerCuotas(){
        return (ArrayList<CuotaEntity>) cuotaRepository.findAll();
    }

    public CuotaEntity obtenerPorId(int id) {
        return cuotaRepository.findById(id);
    }
    public void guardarCuota(CuotaEntity cuota){
        cuotaRepository.save(cuota);
    }

    public void eliminarCuota(CuotaEntity cuota){
            cuotaRepository.delete(cuota);
    }

    //Método para pasar el estado de la cuota de Pendiente a Pagado
    public void actualizarEstado(int id){

        LocalDate fechaActual = LocalDate.now();
        int diaActual = fechaActual.getDayOfMonth();

        if(diaActual>=5 && diaActual<=10){
             CuotaEntity c =  cuotaRepository.findById(id);

             c.setEstado("Solicitado para pagar");

             guardarCuota(c);
        }
    }

    public void pagarCuota(){

        ArrayList<CuotaEntity> cuotas =  obtenerCuotas();
        int i = 1;
        boolean enc = false;

        while((i<=cuotas.size()) && !enc){
            CuotaEntity c = cuotaRepository.findById(i);

            if(c.getEstado().equalsIgnoreCase("Pendiente")){
                actualizarEstado(i);
                enc = true;
            }
            else {
                i++;
            }
        }
    }


    public void descuentoPorExamenAdmision(int puntaje) {

        System.out.println("METODO");
        ArrayList<CuotaEntity> cuotas =  cuotaRepository.findAllCuotas();
        System.out.println("METODO" + cuotas);
        for(int i=0; i<=cuotas.size(); i++){

            CuotaEntity c = cuotas.get(i);
            System.out.println("METODO" + c);
            if (c.getEstado().equalsIgnoreCase("Pendiente")) {
                if (puntaje >= 950 && puntaje <= 1000) {
                    System.out.println("METODO DENTRO 1:" + c.getValor());
                    //10% a todas las cuotas pendientes  de pago
                    c.setValor(c.getValor() - (c.getValor() * 0.1));
                    System.out.println("METODO DENTRO 2:"+ c.getValor());
                    guardarCuota(c);
                } else if (puntaje >= 900 && puntaje <= 949) {
                    //5%
                    c.setValor(c.getValor() - (c.getValor() * 0.05));
                    guardarCuota(c);
                } else if (puntaje >= 850 && puntaje <= 899) {
                    //2%
                    c.setValor(c.getValor() - (c.getValor() * 0.02));
                    guardarCuota(c);
                }
            }
        }
    }
}

