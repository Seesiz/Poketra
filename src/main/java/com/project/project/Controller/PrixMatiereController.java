package com.project.project.Controller;

import com.project.project.Model.Matiere;
import com.project.project.Model.PrixMatiere;
import com.project.project.Model.repository.PrixMatiereRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/prixMatiere")
public class PrixMatiereController {
    @Autowired
    private PrixMatiereRepo pmr;

    @GetMapping
    public String showPrix(HttpServletRequest request, Model model){
        List<PrixMatiere> all = pmr.getAllLastPrixMatiere();
        model.addAttribute("page", "prixMatiere");
        model.addAttribute("title", "prixMatiere");
        request.setAttribute("prixMatiere", all);
        return "main-component";
    }

    @PostMapping
    public String addPrix(
            @RequestParam("matiere") int matiere,
            @RequestParam("date") Date date,
            @RequestParam("prix") double prix
    ){
        PrixMatiere p = new PrixMatiere();
        p.setPrixValue(prix);
        Matiere m = new Matiere();
        m.setMat_id(matiere);
        p.setPrixMatiere(m);
        p.setPrixDate(date);
        pmr.save(p);
        return "redirect:/main/?title=PrixMatiere&page=prixmatiere";
    }
}
