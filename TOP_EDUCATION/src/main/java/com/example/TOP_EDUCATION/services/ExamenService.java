package com.example.TOP_EDUCATION.services;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.repositories.ExamenRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


@Service

public class ExamenService {

    @Autowired
    ExamenRepository examenRepository;

    private final Logger logg = LoggerFactory.getLogger(ExamenService.class);

    public ArrayList<ExamenEntity> obtenerExamenes(){
        return (ArrayList<ExamenEntity>) examenRepository.findAll();
    }

    public ExamenEntity obtenerPorId(int id) {
        return examenRepository.findById(id);
    }
    public void guardarExamen(ExamenEntity examen){
        examenRepository.save(examen);
    }

    public void guardarExamenBD(int puntaje, String fecha_examen, String rut_estudiante){
        ExamenEntity examen = new ExamenEntity();
        examen.setPuntaje(puntaje);
        examen.setFecha_examen(fecha_examen);
        examen.setRut_estudiante(rut_estudiante);
        guardarExamen(examen);
    }

    public void eliminarExamen(ExamenEntity examen){
        try {
            examenRepository.delete(examen);
        }
        catch (Exception e) {
            System.out.println("Error al eliminar el examen: " + examen);
        }

    }

    @Generated
    public String guardar(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsv(String direccion){

        String texto = "";
        BufferedReader bf = null;
        examenRepository.deleteAll();
        System.out.println("Estoy dentrooo");
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            System.out.println("Estoy dentrooo 2");
            while((bfRead = bf.readLine()) != null){
                System.out.println("Estoy dentrooo 3");
                if (count == 1){
                    System.out.println("Estoy dentrooo 4");
                    count = 0;
                }
                else{
                    System.out.println("Estoy dentrooo 5");
                    guardarExamenBD(Integer.parseInt(bfRead.split(";")[0]), bfRead.split(";")[1], bfRead.split(";")[2]);
                    System.out.println("Estoy dentrooo 6");
                    temp = temp + "\n" + bfRead;
                    System.out.println("Estoy dentrooo 7");
                }
            }
            System.out.println("Estoy dentrooo 6");
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }


}
