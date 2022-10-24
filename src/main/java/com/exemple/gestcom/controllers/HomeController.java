package com.exemple.gestcom.controllers;

import com.exemple.gestcom.models.principal;
import com.exemple.gestcom.repo.principalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private principalRepository repoPrincipal;

    @GetMapping("/Principala")
    public String Principala( Model model) {
        Iterable<principal> principale = repoPrincipal.findAll();
        model.addAttribute("principale", principale);
        return "Principala";
    }
    @GetMapping("/Principala/AdCom")
    public String PrinAdCom( Model model) {
              return "AdaugareComanda";
    }

}