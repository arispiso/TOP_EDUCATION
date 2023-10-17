package com.example.TOP_EDUCATION.controllers;

import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping
public class ExamenController {

    @Autowired
    ExamenService examenService;

    @GetMapping("/adjuntarPrueba")
    public String examenes(Model model) {
        ArrayList<ExamenEntity> examenes = examenService.obtenerExamenes();
        model.addAttribute("examenes",examenes);
        return "adjuntarPrueba";
    }

    @PostMapping("/adjuntarPrueba")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        examenService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        examenService.leerCsv(file.getOriginalFilename());
        return "redirect:/adjuntarPrueba";
    }

}
