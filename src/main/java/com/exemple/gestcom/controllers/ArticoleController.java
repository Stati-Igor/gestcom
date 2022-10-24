package com.exemple.gestcom.controllers;


import com.exemple.gestcom.models.articole;
import com.exemple.gestcom.models.clienti;
import com.exemple.gestcom.repo.ArticolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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
    @GetMapping("/Articole/AdArt")
    public String ArtAdArt( Model model) {
        return "AdaugareArticol";
    }

    @PostMapping("/Articole/AdArt")
    public String ArtAdArt(@RequestParam String Nume_articol, @RequestParam String Cod_machet,Long Cantitate_croita, Long Cantitate_cusuta, Long Cantitate_ambalata, Model model) {
        articole articol= new articole(Nume_articol,Cod_machet, 0L,0L,0L);
        articolRepository.save(articol);
        return "redirect:/Articole";
    }
    @GetMapping("/Articole/{id}")
    public String ArticolInfo(@PathVariable(value = "id") long id, Model model) {
        if(!articolRepository.existsById(id)){
            return "redirect:/Articole";
        }
        Optional<articole> articol = articolRepository.findById(id);
        ArrayList<articole> res = new ArrayList<>();
        articol.ifPresent(res::add);
        model.addAttribute("articole",res);
        return "InfoArticol";
    }
}
