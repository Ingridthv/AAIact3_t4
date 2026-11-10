package com.alumn.demoCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alumn.demoCrud.models.Alumno;
import com.alumn.demoCrud.models.Escuela;
import com.alumn.demoCrud.services.AlumnoService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    // LEER
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alumnos", service.listar());
        return "alumnos";
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Alumno alumno = new Alumno();
        alumno.setEscuela(new Escuela());
        model.addAttribute("alumno", alumno);
        model.addAttribute("escuelas", service.listarEscuelas());
        return "alumno_form";
    }

    // CREAR Y ACTUALIZAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Alumno alumno) {
        service.guardar(alumno);
        return "redirect:/alumnos";
    }

    // FORM EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("alumno", service.buscar(id));
        model.addAttribute("escuelas", service.listarEscuelas());
        return "alumno_form";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/alumnos";
    }
}