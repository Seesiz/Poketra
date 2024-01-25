package com.project.project.Controller;

import com.project.project.Model.Poste;
import com.project.project.Model.repository.PosteRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/poste")
public class PosteController {
    @Autowired
    private PosteRepo posteRepo;

    @GetMapping
    public String toPoste(Model model, HttpServletRequest request){
        request.setAttribute("poste", posteRepo.findAll());
        model.addAttribute("page", "poste");
        model.addAttribute("title", "Poste");
        return "main-component";
    }

    @PostMapping
    public String add(@RequestParam("designation") String designation, @RequestParam("salaire") double salaire){
        Poste p = new Poste();
        p.setDesignation(designation);
        p.setSalaireBase(salaire);
        posteRepo.save(p);
        return "redirect:/poste";
    }
}
