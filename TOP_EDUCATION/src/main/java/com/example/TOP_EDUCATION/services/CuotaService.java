package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
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
    private AdministradorPagos administradorPagos;


    public ArrayList<CuotaEntity> obtenerCuotas(){
        return (ArrayList<CuotaEntity>) cuotaRepository.findAll();
    }

    public Optional<CuotaEntity> obtenerPorId(Long id) {
        return cuotaRepository.findById(id);
    }
    public void guardarCuota(CuotaEntity cuota){
        cuotaRepository.save(cuota);
    }

    public void eliminarCuota(CuotaEntity cuota){
        try {
            cuotaRepository.delete(cuota);
        }catch (Exception e) {
            System.out.println("Error al eliminar el cuota: " + cuota);
        }

    }

    //Método para pasar el estado de la cuota de Pendiente a Pagado
    public void actualizarEstado(int id){

        LocalDate fechaActual = LocalDate.now();
        int diaActual = fechaActual.getDayOfMonth();

        if(diaActual>=5 && diaActual<=10){
             CuotaEntity c =  cuotaRepository.findById(id);

             c.setEstado("Solicitado el:" + fechaActual + "para pagar");

             guardarCuota(c);
        }
    }

    public void pagarCuota(){

        ArrayList<CuotaEntity> cuotas =  obtenerCuotas();
        int numCuotas = cuotas.size();
        int i = 1;
        boolean enc = false;

        while((i<=numCuotas) && !enc){
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
}

