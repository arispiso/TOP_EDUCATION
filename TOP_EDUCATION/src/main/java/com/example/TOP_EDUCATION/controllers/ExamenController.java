package com.example.TOP_EDUCATION.controllers;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.ExamenEntity;
import com.example.TOP_EDUCATION.services.CuotaService;
import com.example.TOP_EDUCATION.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class ExamenController {

    @Autowired
    ExamenService examenService;

    //@GetMapping("/")
    //public String examenes(Model model) {
    //  ArrayList<ExamenEntity> examenes = examenService.obtenerExamenes();
    //  model.addAttribute("examenes",examenes);
    //  return "";
    //}
}
