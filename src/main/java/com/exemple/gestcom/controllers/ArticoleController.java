package com.exemple.gestcom.controllers;


import com.exemple.gestcom.models.articole;
import com.exemple.gestcom.repo.ArticolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticoleController {

    @Autowired
    private ArticolRepository articolRepository;
    @GetMapping("/Articole")
    public String ArticView(Model model){
        Iterable<articole> articole = articolRepository.findAll();
        model.addAttribute("articole", articole);
        return "Articole";
    }

}
