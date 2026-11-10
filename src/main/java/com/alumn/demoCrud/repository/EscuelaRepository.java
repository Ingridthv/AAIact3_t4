package com.alumn.demoCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alumn.demoCrud.models.Escuela;

public interface EscuelaRepository extends JpaRepository<Escuela, Integer> {
}