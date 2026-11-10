package com.alumn.demoCrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alumn.demoCrud.models.Alumno;
import com.alumn.demoCrud.models.Escuela;
import com.alumn.demoCrud.repository.AlumnoRepository;
import com.alumn.demoCrud.repository.EscuelaRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private EscuelaRepository escuelaRepo;

    public List<Alumno> listar() {
        return alumnoRepo.findAll();
    }

    public List<Escuela> listarEscuelas() {
        return escuelaRepo.findAll();
    }

    public Alumno buscar(Integer id) {
        return alumnoRepo.findById(id).orElse(null);
    }

    //Busca la escuela elegida y la asigna al alumno antes de guardar
    public void guardar(Alumno alumno) {
        Escuela escuela = escuelaRepo.findById(alumno.getEscuela().getId()).orElse(null);
        alumno.setEscuela(escuela);
        alumnoRepo.save(alumno);
    }

    public void eliminar(Integer id) {
        alumnoRepo.deleteById(id);
    }
}