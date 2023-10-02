package services;

import entities.EstudianteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EstudianteRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public ArrayList<EstudianteEntity> obtenerEstudiantes(){
        return (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
    }

    public Optional<EstudianteEntity> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    public EstudianteEntity obtenerPorRut(String rut){
        return estudianteRepository.findByRut(rut);
    }

    public void guardarEstudiante(EstudianteEntity estudiante){
        estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(EstudianteEntity estudiante){
        try {
            estudianteRepository.delete(estudiante);
        }catch (Exception e) {
            System.out.println("Error al eliminar el estudiante: " + estudiante);
        }

    }

}
