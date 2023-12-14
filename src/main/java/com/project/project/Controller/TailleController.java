package com.project.project.Controller;

import com.project.project.Model.Taille;
import com.project.project.Model.repository.TailleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/taille")
public class TailleController {
    @Autowired
    private TailleRepo tailleRepo;

    @PostMapping
    public String insertTaille(@ModelAttribute Taille taille, Model model){
        HashMap<String, Object> response = new HashMap<>();
        try{
            Taille t = tailleRepo.save(taille);
            response.put("statut", true);
            response.put("data", t);
        } catch (RuntimeException e){
            response.put("statut", false);
        }
        model.addAttribute("response",response);
        model.addAttribute("page", "unite");
        model.addAttribute("title", "Unite");
        return "main-component";
    }
}
