package com.example.TOP_EDUCATION.controllers;

import com.example.TOP_EDUCATION.entities.CuotaEntity;
import com.example.TOP_EDUCATION.entities.EstudianteEntity;
import com.example.TOP_EDUCATION.services.CuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping
public class CuotaController {

    @Autowired
     CuotaService cuotaService;

    @GetMapping("/pagos")
    public String cuotas(Model model) {
        ArrayList<CuotaEntity> cuotas = cuotaService.obtenerCuotas();
        model.addAttribute("cuotas",cuotas);
        return "pagos";
    }

    @PostMapping("/datos")
    public String nuevaCuota() {
     return "redirect:/pagos";
    }

    @PostMapping("/pagos")
    public String pagarCuota() {
        cuotaService.pagarCuota();
        return "redirect:/datos";
    }

}
