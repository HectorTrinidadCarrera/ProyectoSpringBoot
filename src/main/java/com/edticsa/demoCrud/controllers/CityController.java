/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edticsa.demoCrud.controllers;

import com.edticsa.demoCrud.models.City;
import com.edticsa.demoCrud.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author hecto
 */

@Controller
public class CityController {
    
private final CityRepository repo;

    CityController(CityRepository repo) {
        this.repo = repo;
    }

    // LISTAR
    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("cities", repo.findAll());
        return "index";
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("city", new City());
        return "form";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute City city) {
        repo.save(city);
        return "redirect:/";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        City city = repo.findById(id).orElse(null);
        model.addAttribute("city", city);
        return "form";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/";
    }
    
}
