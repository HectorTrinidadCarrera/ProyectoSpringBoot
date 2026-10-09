package com.edticsa.demoCrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.edticsa.demoCrud.repository.UsuarioRepository;


@Controller 
//Sirve para comunucarse con la vista, es decir, con el front-end con frameworks como Angular, React, Vue, etc.
//@RequestMapping("/")

public class UsuarioController {

private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }

@GetMapping("/usuarios")
    public String listar(Model model) {
        model.addAttribute("usuarios", repo.findAll());
        
        return "users/list";
    }



    
}
