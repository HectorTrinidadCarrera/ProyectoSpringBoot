/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edticsa.demoCrud.repository;

/**
 *
 *  Repository  la comunicacion con la bd con el controlador igual ultilizar modelos y el repository se comunica con la base de datos 
 * Aqui tedremos los metodos para crear(create),actualizar(update),eliminar(delete En la bd 
 * 
 * @author hecto
 */

import com.edticsa.demoCrud.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    
}
