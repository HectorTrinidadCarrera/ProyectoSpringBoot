package com.edticsa.demoCrud.controllers;

import com.edticsa.demoCrud.models.City;
import com.edticsa.demoCrud.repository.CityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CityController {

    private final CityRepository repo;

    public CityController(CityRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("cities", repo.findAll());
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("city", new City());
return "cities/form"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute City city) {
        repo.save(city);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        City city = repo.findById(id).orElse(null);
        model.addAttribute("city", city);
 return "cities/form"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
