package com.alumn.demoCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alumn.demoCrud.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}