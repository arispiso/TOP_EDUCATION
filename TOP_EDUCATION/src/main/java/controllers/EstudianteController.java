package controllers;
import entities.EstudianteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.EstudianteService;

import java.util.ArrayList;

@Controller
@RequestMapping
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService; //la clase controller, referencia a EstudianteService, va a usar funcionalidades de esa capa

    @GetMapping("/listar")
    public String listar(Model model) {
        ArrayList<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();
        model.addAttribute("estudiantes",estudiantes);
        return "pagos";
    }

}
