package com.edticsa.demoCrud.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    // Controlador para manejar las rutas de autenticación y autorización
  @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "home";
    }
}
