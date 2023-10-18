package com.example.TOP_EDUCATION.controllers;

import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.entities.ResumenEntity;
import com.example.TOP_EDUCATION.services.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ResumenController {

    @Autowired
    ResumenService resumenService;

    @GetMapping("/resumen")
    public String resumenes(Model model) {
        ArrayList<ResumenEntity> resumenes = resumenService.obtenerResumenes();
        model.addAttribute("resumenes",resumenes);
        return "resumen";
    }

    @PostMapping("/resumen")
    public String nuevoResumen() {
        resumenService.generarResumen();
        return "redirect:/resumen";
    }

}
