/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alumn.demoCrud.repository;

import com.alumn.demoCrud.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ingri
 */
public interface CityRepository extends JpaRepository<City, Integer>{
    
}
