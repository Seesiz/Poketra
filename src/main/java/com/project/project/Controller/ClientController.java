package com.project.project.Controller;

import com.project.project.Model.Client;
import com.project.project.Model.repository.ClientRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepo clientRepo;
    @GetMapping
    public String toClient(Model model, HttpServletRequest request){
        model.addAttribute("page", "client");
        model.addAttribute("title", "Client");
        return "main-component";
    }

    @PostMapping
    public String insert(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("genre") String genre){
        Client c = new Client();
        c.setGenre(genre);
        c.setNom(nom);
        c.setPrenom(prenom);
        clientRepo.save(c);
        return "redirect:/client";
    }
}
