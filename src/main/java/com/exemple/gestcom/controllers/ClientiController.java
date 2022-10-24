package com.exemple.gestcom.controllers;

import com.exemple.gestcom.models.clienti;
import com.exemple.gestcom.repo.clientiRepository;
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
public class ClientiController {

    @Autowired
    private clientiRepository repoClienti;

    @GetMapping("/Clienti")
    public String info(Model model){
        Iterable<clienti> clientii = repoClienti.findAll();
        model.addAttribute("clientii", clientii);
        return "Clienti";
    }
    @GetMapping("/Clienti/AdCli")
    public String CliAdCli( Model model) {
        return "AdaugareClient";
    }
    @PostMapping("/Clienti/AdCli")
    public String CliAdCli(@RequestParam String Nume_client,@RequestParam String Telefon_client, Model model) {
        clienti client= new clienti(Nume_client,Telefon_client);
        repoClienti.save(client);
        return "redirect:/Clienti";
    }
    @GetMapping("/Clienti/{id}")
    public String ClientInfo(@PathVariable(value = "id") long id, Model model) {
        if(!repoClienti.existsById(id)){
            return "redirect:/Clienti";
        }
        Optional<clienti> clienti = repoClienti.findById(id);
        ArrayList<clienti> res = new ArrayList<>();
        clienti.ifPresent(res::add);
        model.addAttribute("clienti",res);
        return "InfoClient";
    }
    @GetMapping("/Clienti/{id}/edit")
    public String ClientEdit(@PathVariable(value = "id") long id, Model model) {
        if(!repoClienti.existsById(id)){
            return "redirect:/Clienti";
        }
        Optional<clienti> clienti = repoClienti.findById(id);
        ArrayList<clienti> res = new ArrayList<>();
        clienti.ifPresent(res::add);
        model.addAttribute("clienti",res);
        return "EditClient";
    }
    @PostMapping("/Clienti/{id}/edit")
    public String CliUpdate(@PathVariable(value = "id") long id, @RequestParam String Nume_client,@RequestParam String Telefon_client, Model model) {
        clienti client= repoClienti.findById(id).orElseThrow();
        client.setNume_client(Nume_client);
        client.setTelefon_client(Telefon_client);
        repoClienti.save(client);
        return "redirect:/Clienti";
    }
    @PostMapping("/Clienti/{id}/delete")
    public String CliDelete(@PathVariable(value = "id") long id, Model model) {
        clienti client= repoClienti.findById(id).orElseThrow();
        repoClienti.delete(client);
        return "redirect:/Clienti";
    }
}
